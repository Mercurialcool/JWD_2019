package by.vadim.shipyard.storage;

import by.vadim.shipyard.dock.ShipOperation;
import by.vadim.shipyard.timeparser.Util;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Storage {
	private static Storage instance;
	private static Logger logger = LogManager.getLogger();
	private static Lock lock = new ReentrantLock();

	private final int maxVolume = 1000;
	private int currentVolume = 0;

	private Storage() {
	}

	public static Storage getInstance() {
		if (instance == null) {
			lock.lock();
			try {
				if (instance == null) {
					instance = new Storage();
				}
			}
			finally {
				lock.unlock();
			}
		}
		return instance;
	}

	public StorageProcessingResult processOperation(ShipOperation shipOperation) {
		lock.lock();
		Util.sleepSafeRandomTime();
		try {
			switch (shipOperation) {
			case LOAD:
				if (currentVolume >= maxVolume) {
					return StorageProcessingResult.STORAGE_FULL;
				}
				currentVolume++;
				break;
			case UNLOAD:
				if (currentVolume <= 0) {
					return StorageProcessingResult.STORAGE_EMPTY;
				}
				currentVolume--;
				break;
			}
			logger.trace("Storage volume: " + currentVolume);
			Util.sleepSafeRandomTime();
			return StorageProcessingResult.SUCCESS;
		}
		finally {
			lock.unlock();
		}
	}
}
