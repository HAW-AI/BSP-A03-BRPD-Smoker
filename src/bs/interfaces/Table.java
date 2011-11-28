package bs.interfaces;

public interface Table {
	boolean hasPaper();
	boolean hasTobacco();
	boolean hasMatches();
	
	int getPaper();
	int getTobacco();
	int getMatches();
	
	void placePaper(int amount);
	void placeTobacco(int amount);
	void placeMatches(int amount);
}
