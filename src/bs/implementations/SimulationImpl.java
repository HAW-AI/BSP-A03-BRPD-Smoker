package bs.implementations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import bs.interfaces.Simulation;
import bs.interfaces.Smoker;
import bs.interfaces.Table;

public class SimulationImpl implements Simulation {
	
	public static Simulation create() {
		return new SimulationImpl();
	}
	private Table table;
	private List<Smoker> smokers;
	
	private SimulationImpl() {
		this.table = TableImpl.create(0, 0, 0);
		this.smokers = Arrays.asList(SmokerImpl.create(table, 1, 1, 0),
									 SmokerImpl.create(table, 1, 0, 1),
									 SmokerImpl.create(table, 0, 1, 1));
	}
	
	public static void main(String[] args) {
		Simulation simulation = SimulationImpl.create();
		simulation.run();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
