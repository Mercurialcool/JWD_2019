package by.vadim.shipyard.timeparser;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Util {

	public static void sleepSafeRandomTime() {
		sleepSafe(new Random().nextInt(1000));
	}

	public static void sleepSafe(int millis) {
		try {
			TimeUnit.MILLISECONDS.sleep(millis);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
