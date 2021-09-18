package exo7;

import java.util.concurrent.Semaphore;
import java.util.concurrent.CountDownLatch;

public class TrieurSémaphore extends Thread {

	private int[] t; //tableau a trier
	private int debut,fin; //tranche de ce tableau qu'il faut trier
	private TrieurSémaphore parent;
	private Semaphore FinTreadFils = new Semaphore(0);
	
	/*nbr de terminaison de thread fils * attendre = 2 
	 * valeur initial du sémaphore est 0 pour imposer un blocage
	 * du père tq les 2 fils n'ont pas terminé leur travail qu'il signalisant
	 * par u release V*/
	
	
	
	
	
	private CountDownLatch CompteurFinTri;
	/*utiliser seulement par le thread racine  */
	
	public TrieurSémaphore (int []t,CountDownLatch cpt) {
		this(null,t,0,t.length-1);
		CompteurFinTri = cpt;
		//cas particulier pour signaler la fin de l'ancètre
		this.start();
	}
	
	private TrieurSémaphore(TrieurSémaphore parent,int []t,int debut,int fin) {
		this.parent=parent;
		this.t=t;
		this.debut=debut;
		this.fin=fin;
	}
	
	public void AuthoriseSémaphore() {//donne son authorisation à reprendre son execution
		
		this.FinTreadFils.release();  // 1 release 1 ticket
		
	}
	
	
	private void echanger(int i,int j) {
		int v = t[i];
		t[i]=t[j];
		t[j]=v;
	}
	
	
	
	
	
	private void triFusion(int debut, int fin) {
		int [] tFusion = new int [fin-debut+1];
		int milieu = (debut+fin) / 2;
		int i1 = debut,
				i2 = milieu + 1;


		int iFusion = 0;
		while (i1 <= milieu && i2 <= fin) {

			if (t[i1] < t[i2]) {
				tFusion[iFusion++] = t[i1++];
			}else {
				tFusion[iFusion++] = t[i2++];
			}
		}


		if(i1 > milieu) {
			for (int i = i2; i <= fin; ) {
				tFusion[iFusion++] = t[i++];
			}
		}else {
			for (int i = i1; i<= milieu ; ) {
				tFusion[iFusion++]= t[i++];
			}
		}


		for (int i = 0,j = debut; i<= fin-debut;) {
			t[j++] = tFusion[i++];
		}

	}
	
	
	
	
	
	
	
	public void run() {
		
		
		
		if (fin-debut <2) {
			if (t[debut]>t[fin]) {
				echanger(debut,fin);
			}
		}else {


			int milieu = (debut+fin)/2;
			TrieurSémaphore t1 = new TrieurSémaphore(this,t,debut,milieu);
			TrieurSémaphore t2 = new TrieurSémaphore(this,t,milieu+1,fin);

			t1.start();
			t2.start();
//attend que les deux threads fils aient terminé et incrementé Sem
			
			
				try {
					FinTreadFils.acquire(2); //2 threads 						
					}
				 catch (InterruptedException e) {}
					triFusion(fin, debut);
				
				
			}

			if (parent != null) {
				parent.AuthoriseSémaphore();
				//indique qu'il a fini au parent qui l'attend
			}else {
				CompteurFinTri.countDown();
				//fin du thread ancètre "débloquera main"
			}
			
		}
	
	
	
	
	
	public static void main(String[] args) {

		/*int[] t = {5,8,3,2,7,10,1};

		TrieurSémaphore trieur = new TrieurSémaphore(t);
		trieur.start();*/


		/*for (int i = 0; i < t.length; i++) {
			System.out.println(t[i]  + " ; ");
		}

		System.out.println();*/
		
		CountDownLatch FinTri = new CountDownLatch(1);

		
		try {
			FinTri.await();
		} catch (InterruptedException e) {

		}
		
	}
	
	


	
	}
	
	

