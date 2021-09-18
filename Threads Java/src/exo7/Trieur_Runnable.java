package exo7;

public class Trieur_Runnable extends Thread {

	private int[] t; //tableau a trier
	private int debut,fin; //tranche de ce tableau qu'il faut trier
	
	
	
	
	public Trieur_Runnable(int[] tt) {
		//this.t = tt;
		this(tt,0,tt.length-1);
	}


	public Trieur_Runnable(int[] tt,int debutt, int finn) {
		
		this.t=tt;
		this.debut = debutt;
		this.fin = finn;
	}

	
	private void echanger(int i,int j) {
		int v = t[i];
		t[i]=t[j];
		t[j]=v;
	}

	public void run() {
		
		if (fin-debut <2) {
			if (t[debut]>t[fin]) {
				echanger(t[debut],t[fin]);
			}
		}else {
			int milieu = (debut+fin)/2;
			Trieur t1 = new Trieur(t,debut,milieu);
			Trieur t2 = new Trieur(t,milieu+1,fin);
			
			t1.start();
			t2.start();
			
			try {
				t1.join();
				t2.join();
			} catch (InterruptedException e) {
				
			}
			triFusion(debut, fin);
		}
		
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
	

	
	
	
	public static void main(String[] args) {
		
		int[] t = {5,8,3,2,7,10,1};
		
		Trieur_Runnable trieur = new Trieur_Runnable(t);
		trieur.start();
		
		
		try {
			trieur.join();
		} catch (InterruptedException e) {
			
		}
		
		
		for (int i = 0; i < t.length; i++) {
			System.out.println(t[i]  + " ; ");
		}
		
		System.out.println();
	}

}
