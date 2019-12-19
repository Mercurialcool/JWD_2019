package by.vadim.shipyard.dock;

import by.vadim.shipyard.storage.Ship;
import by.vadim.shipyard.storage.Storage;
import by.vadim.shipyard.storage.StorageProcessingResult;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ShipsProcessor {
	private static final int BERTH_COUNT = 3;
	private static Logger logger = LogManager.getLogger();

	private final Executor processor = Executors.newFixedThreadPool(BERTH_COUNT);

	public void processNext(Ship ship) {
		System.out.println("Added in queue: " + ship);

		processor.execute(() -> {
			logger.trace("Started processing: " + ship);

			if (ship.isNeedsLoad()) {
				startLoading(ship);
			}
			else {
				startUnloading(ship);
			}

			logger.trace("Processing complete: " + ship);
		});
	}

	private void startLoading(Ship ship) {
		while (ship.getCurrentVolume() < ship.getMaxVolume()) {
			StorageProcessingResult storageProcessingResult = Storage.getInstance().
					processOperation(ShipOperation.UNLOAD);
			if (storageProcessingResult == StorageProcessingResult.STORAGE_EMPTY) {
				break;
			} else if (storageProcessingResult == StorageProcessingResult.SUCCESS) {
				ship.load();
			}
		}
	}

	private void startUnloading(Ship ship) {
		while (ship.getCurrentVolume() > 0) {
			ship.unload();
			StorageProcessingResult storageProcessingResult = Storage.getInstance().
					processOperation(ShipOperation.LOAD);
			if (storageProcessingResult == StorageProcessingResult.STORAGE_FULL) {
				ship.load();
				break;
			}
		}
	}
}
