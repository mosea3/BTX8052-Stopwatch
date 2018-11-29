package application;

/**
 * 
 * @author mosea3@bfh.ch
 * @description: Ex2 dislocate Timing functionality out of Main class
 * 
 */

public class Timer {
	long startTime;
	long endTime;
	private long time;

	public Timer() {

		time = 0;
	}

	public void start() {
		startTime = System.currentTimeMillis();
	}

	public long stop() {
		endTime = System.currentTimeMillis();
		time = endTime - startTime;

		return time;
	}

}
