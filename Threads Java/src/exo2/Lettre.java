package exo2;

public class Lettre extends Thread {

public void run() {
		
	for(int i='A';i<='Z';i++) {
		System.out.println((char) i);
	}
	
	}
	
}
