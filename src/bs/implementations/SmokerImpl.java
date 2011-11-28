package bs.implementations;

import bs.interfaces.Smoker;
import bs.interfaces.Table;

public class SmokerImpl implements Smoker {
	public static int SMOKING_BREAK_DURATION = 4000;
	public static int CIGARETTE_ROLLING_DURATION = 2000;
	
	private Table table;
	private int paper;
	private int tobacco;
	private int matches;
	
	private SmokerImpl(Table table, int initialPaper, int initialTobacco, int initialMatches) {
		this.table = table;
		this.matches = initialMatches;
		this.tobacco = initialTobacco;
		this.paper = initialPaper;
	}

	public static Smoker create(Table table, int initialPaper, int initialTobacco, int initialMatches) {
		if (table == null || !(table instanceof Table))
			throw new IllegalArgumentException();
		
		return new SmokerImpl(table, initialPaper, initialTobacco, initialMatches);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean hasAllIngedients() {
		if (paper >= 1 && tobacco >= 1 && matches >= 1) {
			return true;
		}
		return false;
	}

	@Override
	public void smoke() {
		rollCigarette();
		try {
			wait(SMOKING_BREAK_DURATION);
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("Something went wrong while smoking the cigarette");
		}
	}

	@Override
	public void rollCigarette() {
		decrementIngredients();
		try {
			wait(CIGARETTE_ROLLING_DURATION);
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("Something went wrong while rolling a cigarette");
		}
	}

	private void decrementIngredients() {
		if (!(tobacco >= 1 && paper >= 1 && matches >= 1)) {
			throw new RuntimeException("Smoked more stuff than was available");
		}
		tobacco -= 1;
		paper -= 1;
		matches -= 1;
	}
	
	private void incrementMatches(int amount) {
		matches += amount;
	}

	private void incrementPaper(int amount) {
		paper += amount;
	}

	private void incrementTobacco(int amount) {
		tobacco += amount;
	}

	public void getMissingIngredients() {
		if (tobacco == 0) {
			incrementTobacco(table.getTobacco());
		}
		if (paper == 0) {
			incrementPaper(table.getPaper());
		}
		if (matches == 0) {
			incrementMatches(table.getMatches());
		}
	}
}
