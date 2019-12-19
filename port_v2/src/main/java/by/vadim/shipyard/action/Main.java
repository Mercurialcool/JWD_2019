package by.vadim.shipyard.action;

import by.vadim.shipyard.storage.Ship;
import by.vadim.shipyard.dock.ShipsProcessor;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		ShipsProcessor shipsProcessor = new ShipsProcessor();
		Random random = new Random();

		boolean needsLoad = true;
		for (int i = 0; i < 10; i++) {
			int maxVolume = random.nextInt(100);
			needsLoad = !needsLoad;
			Ship ship = new Ship("Ship " + i, maxVolume, needsLoad, maxVolume / 2);

			shipsProcessor.processNext(ship);
		}
	}
}
