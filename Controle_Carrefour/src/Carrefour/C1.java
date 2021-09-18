package Carrefour;

import java.awt.Color;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class C1  extends Thread{
	Road r;
	Color c ;
    
	int x=0;
	Lock vfeu1;//verrou du Feu1 

	Condition cf1;//condition du feu 1 pour le passage du voiture
	
	public C1(Road r ,Color c ,Lock v,Condition cf1) {// constructeur 
		this.cf1=cf1;
		this.c=c;
		this.r=r;
		this.r.col=c;
		x=0;
		vfeu1=v;

	}
	// x=150 ====> debut d intersection 
	//x = 500 ===> fin d intersection 
	public void traverser1 () // fonction de traversee la route 1
	{
		try {
			while(true) {

				this.r.col=c;

				Thread.sleep(10);

				vfeu1.lock();
				x++;


				this.r.x=x;
				if(x==500) {
					cf1.signalAll();}
				if(x== 800)
				{
					x=0;}
				System.out.println(this.getName()+"   " +x);

				this.r.repaint();
				vfeu1.unlock();

			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			vfeu1.unlock();
		}

	}
	public void run()
	{ 
		traverser1();	
	}
}
