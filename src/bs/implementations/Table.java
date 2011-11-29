package bs.implementations;

import java.util.ArrayList;
import java.util.List;

public class Table {
	private Agent agent; 
	private List<Smoker> smoker;
	private List<Ingredients> ingredients;
	
	public static Table newinstance() {
		return new Table();
	}
	
	private Table() {
		this.smoker = new ArrayList<Smoker>();
		this.ingredients = new ArrayList<Ingredients>(2);
	}
	
	public void add(Agent agent) {
		if (this.agent != null) throw new IllegalAccessError("Agent alredy set");
		this.agent = agent;
	}
	
	public void add(Smoker smoker) {
		this.smoker.add(smoker);
	}

	public boolean isEmpty() {
		return this.ingredients.size() == 0;
	}

	public void place(Ingredients i1, Ingredients i2) {
		this.ingredients.add(i1);
		this.ingredients.add(i2);
	}
	
	public void take() {
		this.ingredients.clear();
	}
	
	public List<Ingredients> show() {
		return this.ingredients;
	}

	public void start() {
		for (Smoker s : smoker) {
			s.start();
		}
		this.agent.start();
	}

	public void lazywait() {
		try {
			this.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
