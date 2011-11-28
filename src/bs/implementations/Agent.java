package bs.implementations;

public class Agent extends Attendee {
	private Table table;

	public Agent(Table table) {
		this.table = table;
	}
	
	public void run() {
		Ingredients i1 = null;
		Ingredients i2 = null;
		
		i1 = Ingredients.getRandom();
		i2 = i1.getNext();
		
		while (true) {
			System.out.println("Agent running");
			if (table.isEmpty()) {
				table.place(i1,i2);
			}
			lazywait();
		}
	}
	
	public String toString() {
		return "Agent";
	}
}
