package bs.implementations;

public enum Ingredients {
	PAPER, MATCHES, TABACCO;
	
	public Ingredients getNext() {
		return values()[(ordinal()+1) % values().length];
	}
	
	public static Ingredients getRandom() {
		return values()[new Integer((int) (Math.random()*values().length))];
	}
}
