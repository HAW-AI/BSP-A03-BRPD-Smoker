package bs.implementations;

public class Table {
	
	public static Table create(int initialPaper, int initialTobacco, int initialMatches) {
		return new Table(initialPaper, initialTobacco, initialMatches);
	}

	private int paper;
	private int tobacco;
	private int matches;
	
	private Table(int initialPaper, int initialTobacco, int initialMatches) {
		this.paper = initialPaper;
		this.tobacco = initialTobacco;
		this.matches = initialMatches;
	}

	public synchronized boolean hasPaper() throws RuntimeException {
		return paper > 0;
	}

	
	public synchronized boolean hasTobacco() throws RuntimeException {
		return tobacco > 0;
	}

	
	public synchronized boolean hasMatches() throws RuntimeException {
		return matches > 0;
	}

	
	public synchronized void getPaper() throws RuntimeException {
		try {
			wait();
		} catch (Exception e) {
			e.printStackTrace();
		}
		paper -= 1;
	}

	
	public synchronized void getTobacco() throws RuntimeException {
		try {
			wait();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tobacco -= 1;
	}

	
	public synchronized void getMatches() throws RuntimeException {
		try {
			wait();
		} catch (Exception e) {
			e.printStackTrace();
		}
		matches -= 1;
	}

	
	public synchronized void placePaper(int amount) throws RuntimeException {
		try {
			wait();
		} catch (Exception e) {
			e.printStackTrace();
		}
		paper += amount;
		notify();
	}

	
	public synchronized void placeTobacco(int amount) throws RuntimeException {
		try {
			wait();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tobacco += amount;
		notify();
	}

	
	public synchronized void placeMatches(int amount) throws RuntimeException {
		try {
			wait();
		} catch (Exception e) {
			e.printStackTrace();
		}
		matches += amount;
		notify();
	}
	
	public synchronized void signal() {
		notify();
	}

}
