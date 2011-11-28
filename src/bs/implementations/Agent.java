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
		System.out.println("Agent: Trying to place some Tobacco on the table");
		if ((tobacco - AMOUNT_TO_BE_PLACED) >= 0) {
			tobacco -= AMOUNT_TO_BE_PLACED;
			table.placeTobacco(AMOUNT_TO_BE_PLACED);
		} else {
			throw new RuntimeException("Agent: I ran out of tobacco.");
		}
		System.out.println("Agent: Placed some Tobacco on the table");
	}

	
	public void placePaperOnTable() {
		System.out.println("Agent: Trying to place some Paper on the table");
		if ((paper - AMOUNT_TO_BE_PLACED) >= 0) {
			paper -= AMOUNT_TO_BE_PLACED;
			table.placePaper(AMOUNT_TO_BE_PLACED);
		} else {
			throw new RuntimeException("Agent: I ran out of paper.");
		}
		System.out.println("Agent: Placed some Paper on the table");
	}

	
	public void placeMatchesOnTable() {
		System.out.println("Agent: Trying to place some Matches on the table");
		if ((matches - AMOUNT_TO_BE_PLACED) >= 0) {
			matches -= AMOUNT_TO_BE_PLACED;
			table.placeMatches(AMOUNT_TO_BE_PLACED);
		} else {
			throw new RuntimeException("Agent: I ran out of matches.");
		}
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
		while (hasIngredients()) {
			switch (randomNum) {
			case 0:
				try {
					placeTobaccoOnTable();
					placePaperOnTable();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 1:
				try {
					placeMatchesOnTable();
					placePaperOnTable();
				} catch (Exception e) {
					e.printStackTrace();				
				}
				break;
			case 2:
				try {
					placeTobaccoOnTable();
					placeMatchesOnTable();
				} catch (Exception e) {
					e.printStackTrace();				
				}
				break;
			default:
				break;
			}
			randomNum = rand.nextInt(max - min + 1) + min;
			System.out.println("I have " + matches + "Matches left, " + paper + "Paper and " + tobacco + "Tobbaco.");
		}
	}

}
