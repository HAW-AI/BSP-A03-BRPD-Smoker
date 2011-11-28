package bs.implementations;

public class Simulation {
	
	public static Simulation create() {
		return new Simulation();
	}
	private Table table;
	private static Smoker smoker1;
	private Smoker smoker2;
	private Smoker smoker3;
	private static Agent agent;
	
	private Simulation() {
		this.table = Table.create(0, 0, 0);
		this.smoker1 = Smoker.create(table, 1, 0, 0);
		this.smoker2 = Smoker.create(table, 0, 1, 0);
		this.smoker3 = Smoker.create(table, 0, 0, 1);
		this.agent = Agent.create(table, 40, 40, 40);
	}
	
	public static void main(String[] args) {
		Simulation simulation = Simulation.create();
		long runtime = System.currentTimeMillis() + 10000;
		try {
			
			smoker1.start();
			agent.start();
			while (System.currentTimeMillis() > runtime) {
				System.exit(0);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
