package bs.implementations;

public class Smoker extends Thread {
	public static int SMOKING_BREAK_DURATION = 500;
	public static int CIGARETTE_ROLLING_DURATION = 500;
	
	private Table table;
	private int paper;
	private int tobacco;
	private int matches;
	
	private Smoker(Table table, int initialPaper, int initialTobacco, int initialMatches) {
		this.table = table;
		this.matches = initialMatches;
		this.tobacco = initialTobacco;
		this.paper = initialPaper;
	}

	public static Smoker create(Table table, int initialPaper, int initialTobacco, int initialMatches) {
		if (table == null || !(table instanceof Table))
			throw new IllegalArgumentException();
		
		return new Smoker(table, initialPaper, initialTobacco, initialMatches);
	}
		
	public void run() {
		while (true) {
			if (!hasAllIngedients()) {
				System.out.println("Dont have all the ingredients I need");
				try {
					getMissingIngredients();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("Got all the ingredients I need");
				try {
					rollCigarette();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				try {
					smoke();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	
	public boolean hasAllIngedients() {
		if (paper >= 1 && tobacco >= 1 && matches >= 1) {
			return true;
		}
		return false;
	}

	
	public void smoke() throws InterruptedException {
		System.out.println("Smoker" + this.toString() + ": Smoking that cigarette");
		wait(SMOKING_BREAK_DURATION);
		System.out.println("Smoker" + this.toString() + ": Done smoking my cigarette");
	}

	
	public void rollCigarette() throws InterruptedException {
		decrementIngredients();
		wait(CIGARETTE_ROLLING_DURATION);
		System.out.println("Smoker" + this.toString() + ": Rolling a cigarette");
	}

	private void decrementIngredients() {
		if (!(tobacco >= 1 && paper >= 1 && matches >= 1)) {
			throw new RuntimeException("Smoked more stuff than was available");
		}
		tobacco -= 1;
		paper -= 1;
		matches -= 1;
	}
	
	private void incrementMatches() {
		matches += 1;
	}

	private void incrementPaper() {
		paper += 1;
	}

	private void incrementTobacco() {
		tobacco += 1;
	}

	public void getMissingIngredients() {
		if (tobacco == 0) {
			try {
				table.getTobacco();
				incrementTobacco();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (paper == 0) {
			try {
				table.getPaper();
				incrementPaper();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (matches == 0) {
			try {
				table.getMatches();
				incrementMatches();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			
		}
	}
}
