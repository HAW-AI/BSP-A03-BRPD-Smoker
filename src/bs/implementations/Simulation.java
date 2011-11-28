package bs.implementations;

public class Simulation {
	
	public static void main(String[] args) {
		System.out.println("Create objec…");
		Table table = Table.newinstance();
		table.add(new Agent(table));
		table.add(new Smoker(Ingredients.MATCHES, table));
		table.add(new Smoker(Ingredients.TABACCO, table));
		table.add(new Smoker(Ingredients.PAPER, table));
		
		System.out.println("Start simulation…");
		table.start();
	}
}
