package bs.implementations;

public class Simulation {
	
	public static void main(String[] args) {
		System.out.println("Create objec…");
		Table table = Table.newinstance();
		table.add(new Agent(table));
		table.add(Smoker.newinstance(Ingredients.MATCHES, table));
		table.add(Smoker.newinstance(Ingredients.TABACCO, table));
		table.add(Smoker.newinstance(Ingredients.PAPER, table));
		
		System.out.println("Start simulation…");
		table.start();
	}
}
