package bs.implementations;

public class Smoker extends Attendee {
	private static int count = 0;
	private int number = 0;
	private Ingredients ingredient;
	
	public static Smoker newinstance(Ingredients ingredient, Table table) {
		return new Smoker(ingredient, table, count++);
	}
	
	private Smoker(Ingredients ingredient, Table table, int number) {
		this.ingredient = ingredient;
		this.table = table;
		this.number = number;
	}

	public void run() {
		while (true) {
			if (!this.table.show().contains(this.ingredient) && !this.table.isEmpty()) {
				this.table.take();
				System.out.println(this + " smoking");
				lazywait();
			}
		}
	}
	
	public String toString() {
		return "Smoker " + number;
	}
}
