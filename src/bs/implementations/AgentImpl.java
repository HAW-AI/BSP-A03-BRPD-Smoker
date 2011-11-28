package bs.implementations;

import bs.interfaces.Agent;
import bs.interfaces.Table;

public class AgentImpl implements Agent {
	private static int AMOUNT_TO_BE_PLACED = 1;

	private Table table;
	private AgentImpl(Table table) {
		this.table = table;
	}
	
	public static Agent create(Table table) {
		if (table == null || !(table instanceof Table))
			throw new IllegalArgumentException();
		
		return new AgentImpl(table);
	}
	
	@Override
	public void placeTobaccoOnTable() {
		table.placeTobacco(AMOUNT_TO_BE_PLACED);
	}

	@Override
	public void placePaperOnTable() {
		table.placePaper(AMOUNT_TO_BE_PLACED);
	}

	@Override
	public void placeMatchesOnTable() {
		table.placeMatches(AMOUNT_TO_BE_PLACED);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
