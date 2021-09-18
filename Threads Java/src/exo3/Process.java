package exo3;

public class Process extends Thread {

	private int id; //identificateur du process
	static int counter = 0; //variable partagée
	private static boolean[] flag = new boolean[2]; //tableau partagé flag
	
	public Process(int id) {  //constructeur
		this.id=id;
		flag[id] = false;  //initialisation du flag
	}
	
	private int random(int n) {  //generation d'un nombre aléatoire entre 0 et n
		return (int) Math.round(n*Math.random() - 0.5);
	}
	
	private void buzy() {  //mettre en attente un process
		try {
			sleep (random(500));
		} 
		catch (InterruptedException e) {
			
		}
	}
	
	private void entry_section() {    //protocole d'accès à la section critique
		flag[id] = true;
		buzy();
		while (flag[1-id]) {
		}
	}
	
	
	private void critical_section() {   //code de la section critique 
		if (id == 0) {
			int temp = counter;
			buzy();
			temp = temp + 1 ;
			counter = temp;
		}
		else {
			int temp = counter;
			buzy();
			temp = temp - 1;
			counter = temp;
		}
		System.out.println("Process" + id +" ; je quitte la S.C : counter = "+counter);
	}
	
	private void exit_section() {   //protocole de libération de la section critique
		flag[id] = false;
	}
	
	private void remainder_section() {  //code en dehors de la section critique 
		
	}
	
	
	public void run() {
		do {
			entry_section();
			critical_section();
			exit_section();
			remainder_section(); // Section NON Critique
		}while(true);
		
	}
	
}// class Process
