package bs.implementations;

public class Simulation {
	
	public static void main(String[] args) {
		try {
			System.out.println("Entering simulation");
			Table table = Table.create(0, 0, 0);
			Smoker smoker1 = Smoker.create(table, 1, 0, 0);
			Smoker smoker2 = Smoker.create(table, 0, 1, 0);
			Smoker smoker3 = Smoker.create(table, 0, 0, 1);
			Agent agent = Agent.create(table, 40, 40, 40);
			
			agent.start();
			smoker1.start();
			smoker2.start();
			smoker3.start();
		} catch (Exception e) {
			System.out.println(e);
			System.exit(0);
		}
	}
}
