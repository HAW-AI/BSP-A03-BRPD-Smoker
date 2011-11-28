package bs.implementations;

public abstract class Attendee extends Thread {
	protected Table table;
	
	protected void lazywait() {
		try {
			synchronized (this) { this.wait(); }
		} catch (InterruptedException e) {
			System.out.println(this + " can't wait");
		}
	}
}
