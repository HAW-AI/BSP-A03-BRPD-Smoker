package bs.implementations;

import java.util.List;

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
		List<Ingredients> l;
		while (true) {
			// Was passiert wenn das notifyAll() for dem wait() kommt?
			// FIXEME: mit wait(timeout), agent&smoker laufn ausm takt
			synchronized (this.table) {
				while(this.table.isEmpty()) { this.table.lazywait(); } // Deadlock?!?
				if ((l = this.table.show()) != null && l.size() > 0 && !l.contains(ingredient) ) {
					this.table.take();
					System.out.println(this + " smoking");
//					try {
//						this.sleep(500);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
				}
			}
		}
	}
	
	public String toString() {
		return String.format("Smoker %d (%s)", number, ingredient);
	}
}
