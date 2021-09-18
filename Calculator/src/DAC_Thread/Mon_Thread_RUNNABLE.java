package DAC_Thread;

import java.lang.*;

public class Mon_Thread_RUNNABLE implements Runnable {

	public void run () {
		System .out. println ("I'm a thread !");
		}
		public static void main ( String args []) {
		// Un thread possède optionnellement un nom symbolique
		Thread t = new Thread (new Mon_Thread_RUNNABLE(), "My Thread ");
		// MonThread .run () est démarré dans un nouveau thread après
		//l'appel de start ()
		t. start ();
		System .out. println ("Ce code s'exécute en // de run ()");
		}

}
