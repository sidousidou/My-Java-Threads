package DAC_Thread;

import java.lang.*;

public class Mon_Thread_THREAD extends Thread {
	
	public void run () {
		System .out. println ("I'm a thread !");
		}
		public static void main ( String args []) {
		// Un thread poss�de optionnellement un nom symbolique
		Thread t = new Thread (new Mon_Thread_THREAD (), "My Thread ");
		// MonThread .run () est d�marr� dans un nouveau thread apr�s
		//l'appel de start ()
		t. start ();
		System .out. println ("Ce code s'ex�cute en // de run ()");
		}
	
}
