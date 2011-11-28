package bs.interfaces;

public interface Smoker extends Runnable {
	boolean hasAllIngedients();
	void smoke();
	void rollCigarette();
	void getMissingIngredients();
}
