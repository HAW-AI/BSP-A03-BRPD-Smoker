package bs.implementations;

import bs.interfaces.Table;

public class TableImpl implements Table {
	
	public static Table create(int initialPaper, int initialTobacco, int initialMatches) {
		return new TableImpl(initialPaper, initialTobacco, initialMatches);
	}

	private int paper;
	private int tobacco;
	private int matches;
	
	private TableImpl(int initialPaper, int initialTobacco, int initialMatches) {
		this.paper = initialPaper;
		this.tobacco = initialTobacco;
		this.matches = initialMatches;
	}

	@Override
	public boolean hasPaper() {
		return paper > 0;
	}

	@Override
	public boolean hasTobacco() {
		return tobacco > 0;
	}

	@Override
	public boolean hasMatches() {
		return matches > 0;
	}

	@Override
	public int getPaper() {
		paper -= 1;
		return 1;
	}

	@Override
	public int getTobacco() {
		tobacco -= 1;
		return 1;
	}

	@Override
	public int getMatches() {
		matches -= 1;
		return 1;
	}

	@Override
	public void placePaper(int amount) {
		paper += amount;
	}

	@Override
	public void placeTobacco(int amount) {
		tobacco += amount;
	}

	@Override
	public void placeMatches(int amount) {
		matches += amount;
	}

}
