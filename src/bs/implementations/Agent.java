package bs.implementations;

import java.util.Random;

public class Agent extends Thread {
	private static int AMOUNT_TO_BE_PLACED = 1;

	private Table table;
	private int matches;
	private int paper;
	private int tobacco;
	private Agent(Table table, int tobacco, int paper, int matches) {
		this.table = table;
		this.tobacco = tobacco;
		this.paper = paper;
		this.matches = matches;
	}
	
	public static Agent create(Table table, int tobacco, int paper, int matches) {
		if (table == null || !(table instanceof Table))
			throw new IllegalArgumentException();
		
		return new Agent(table, tobacco, paper, matches);
	}
	
	
	public void placeTobaccoOnTable() {
		tobacco -= AMOUNT_TO_BE_PLACED;
		table.placeTobacco(AMOUNT_TO_BE_PLACED);
		System.out.println("Agent: Placed some Tobacco on the table");
	}

	
	public void placePaperOnTable() {
		paper -= AMOUNT_TO_BE_PLACED;
		table.placePaper(AMOUNT_TO_BE_PLACED);
		System.out.println("Agent: Placed some Paper on the table");
	}

	
	public void placeMatchesOnTable() {
		matches -= AMOUNT_TO_BE_PLACED;
		table.placeMatches(AMOUNT_TO_BE_PLACED);
		System.out.println("Agent: Placed some Matches on the table");
	}
	
	public boolean hasIngredients() {
		if (tobacco <= 0 || paper <= 0 || matches <= 0 ) {
			return false;
		} else {
			return true;
		}
	}

	
	public void run() {
		Random rand = new Random();
		int min, max;
		min = 0;
		max = 2;
		int randomNum = rand.nextInt(max - min + 1) + min;
		while (true) {
			switch (randomNum) {
			case 0:
				try {
					placeTobaccoOnTable();
					placePaperOnTable();
					notifyAll();
				} catch (Exception e) {
					// TODO: handle exception
				}
				break;
			case 1:
				try {
					placeMatchesOnTable();
					placePaperOnTable();
					notifyAll();
				} catch (Exception e) {
					// TODO: handle exception
				}
				break;
			case 2:
				try {
					placeTobaccoOnTable();
					placeMatchesOnTable();
					notifyAll();
				} catch (Exception e) {
					// TODO: handle exception
				}
				break;
			default:
				break;
			}
			randomNum = rand.nextInt(max - min + 1) + min;
		}
	}

}
