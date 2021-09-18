package exo2;

public class Threads {
	

	public static void main(String[] args) {
		//Chiffre ch1 = new Chiffre();
		Lettre l1 = new Lettre();
		
		//Thread t1 = new Thread(ch1);
		Thread t2 = new Thread(l1);
		//t1.start();
		t2.start();   //les exes sont entrelassé est c impossible de pridir le resultat pouvant changer à chaque exe
		              //les threads sont gerés par l'oradannanceur de la JVM et l'oradannanceur de SE
					  //l'oradannanceur du SE gère le processus de la JVM et l'oradannanceur de la JVM gère les thread près à s'executer le resultat depend donc des 2 oradannanceurs et de la capacité de la machine"CPU ..."
		
	}
}
