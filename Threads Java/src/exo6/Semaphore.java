package exo6;

public class Semaphore {

	int n;
	String name;
	public Semaphore (int max,String S) {
		n=max;
		S=name;
	}
	
	
	public synchronized void P() {  //synchronized ==> semaphore
		if (n==0) {
			try {
				wait();
			} catch (InterruptedException e) {
				
			}
			n--;
			
		}
	}
	
	public synchronized void V() {
		n++;
		notify();
	}
}
