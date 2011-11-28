package bs.implementations;

public class Smoker extends Attendee {
	private Ingredients ingredient;
	
	public Smoker(Ingredients ingredient, Table table) {
		this.ingredient = ingredient;
		this.table = table;
	}

	public void run() {
		while (true) {
			if (!this.table.show().contains(this.ingredient)) {
				this.table.take();
				System.out.println("Smoker smoking");
				lazywait();
			}
		}
	}
	
	public String toString() {
		return "Smoker";
	}
}
