package bs.implementations;

public class Agent extends Attendee {
	private Table table;

	public Agent(Table table) {
		this.table = table;
	}
	
	public void run() {
		Ingredients i1 = null;
		Ingredients i2 = null;
		
		while (true) {
			i1 = Ingredients.getRandom();
			i2 = i1.getNext();

			if (table.isEmpty()) {
				synchronized (this.table) {
					System.out.println("Agent placing ("+i1+","+i2+")");
					table.place(i1,i2);
					table.notifyAll();
				}
			}
		}
	}
	
	public String toString() {
		return "Agent";
	}
}
