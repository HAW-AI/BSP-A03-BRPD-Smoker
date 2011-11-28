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

	public boolean hasPaper() {
		return paper > 0;
	}

	
	public boolean hasTobacco() {
		return tobacco > 0;
	}

	
	public boolean hasMatches() {
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
		System.out.println("Table: The Agent is trying to place " + amount + " Paper(s) on the table.");
//		while (paper > 0) {
//			try {
//				wait();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
		paper += amount;
		System.out.println("Table: The Agent placed " + amount + " Paper(s) on the table.");
		notify();
	}

	
	public synchronized void placeTobacco(int amount) throws RuntimeException {
		System.out.println("Table: The Agent is trying to place " + amount + " Tobacco on the table.");
//		while (tobacco > 0) {
//			try {
//				wait();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
		tobacco += amount;
		System.out.println("Table: The Agent placed " + amount + " Tobacco on the table.");
		notify();
	}

	
	public synchronized void placeMatches(int amount) throws RuntimeException {
		System.out.println("Table: The Agent is trying to place " + amount + " Match(es) on the table.");
//		while (matches > 0) {
//			try {
//				wait();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
		matches += amount;
		System.out.println("Table: The Agent placed " + amount + " Match(es) on the table.");
		notify();
	}
}
