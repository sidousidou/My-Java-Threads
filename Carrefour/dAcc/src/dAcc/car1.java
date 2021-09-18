package dAcc;

import java.awt.Color;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class car1  extends Thread{
	Route r;
	Color c ;
 
	 int x=0;
	 Lock vfeu1; 
	 Condition cf1;
public car1(Route r ,Color c ,Lock v,Condition cf1) {
	this.cf1=cf1;
	this.c=c;
	this.r=r;
	this.r.col=c;
	x=0;
	 vfeu1=v;
	
}
// x=150 ====> debut d intersection 
//x = 500 ===> fin d intersection 
public void traverser1 ()
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
