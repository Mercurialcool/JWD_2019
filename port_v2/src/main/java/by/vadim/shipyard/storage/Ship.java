package by.vadim.shipyard.storage;

import by.vadim.shipyard.timeparser.Util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ship {
	private static Logger logger = LogManager.getLogger();
	private final String name;
	private final int maxVolume;
	private final boolean needsLoad;
	private int currentVolume;

	public Ship(String name, int maxVolume, boolean needsLoad, int currentVolume) {
		this.name = name;
		this.maxVolume = maxVolume;
		this.needsLoad = needsLoad;
		this.currentVolume = currentVolume;
	}

	public boolean isNeedsLoad() {
		return needsLoad;
	}

	public int getMaxVolume() {
		return maxVolume;
	}

	public int getCurrentVolume() {
		return currentVolume;
	}

	public void load() {
		Util.sleepSafeRandomTime();
		currentVolume++;
		logger.trace("Loaded: " + toString());
	}

	public void unload() {
		Util.sleepSafeRandomTime();
		currentVolume--;
		logger.trace("Unloaded: " + toString());
	}

	@Override
	public String toString() {
		return "Ship{" +
			"name='" + name + '\'' +
			", maxVolume=" + maxVolume +
			", needsLoad=" + needsLoad +
			", currentVolume=" + currentVolume +
			'}';
	}
}
