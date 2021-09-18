package exo1;

public class Compteurs implements Runnable {

	/*public static void main(String[] args) {
		ThreadCompteur cp1 = new ThreadCompteur(10);
		ThreadCompteur cp2 = new ThreadCompteur(10);
		ThreadCompteur cp3 = new ThreadCompteur(10);
		
		cp1.start();
		cp2.start();
		cp3.start();
		
	}*/
	
	
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
	
	
	public static void main(String[] args) {
		
		ThreadCompteur C1 = new ThreadCompteur(2);
		
		Thread t1 = new Thread(C1);
		t1.currentThread().setPriority(Thread.MAX_PRIORITY);
		Thread t2 = new Thread(C1);
		t2.currentThread().setPriority(Thread.MIN_PRIORITY);
		Thread t3 = new Thread(C1);
		
		t1.start();
		t2.start();
		t3.start();
		
	}
	
	
}
