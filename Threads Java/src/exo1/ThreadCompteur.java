package exo1;

public class ThreadCompteur extends Thread {

	int no_fin;
	
	public ThreadCompteur(int fin) {

		no_fin=fin;
		
	}
	
	
	public void run() {
		
		for(int i=1;i<=no_fin;i++) {
			System.out.println(Thread.currentThread().getName());
		}
		
	}
	
	
	
	
}
