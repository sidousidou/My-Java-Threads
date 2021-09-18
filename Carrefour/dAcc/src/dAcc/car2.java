package dAcc;

import java.awt.Color;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class car2  extends Thread{
	Route r;
	Color c ;
 
	 int y=0;
	 Lock vfeu2; 
	 Condition cf2;
public car2(Route r ,Color c ,Lock v,Condition cf2) {
	this.cf2=cf2;
	this.c=c;
	this.r=r;
	this.r.col=c;
	y=0;
	 vfeu2=v;
	
}
// x=150 ====> debut d intersection 
//x = 500 ===> fin d intersection 
public void traverser2 ()
{
	try {
while(true) {
	
		this.r.col=c;
	 
		Thread.sleep(10);
	
		vfeu2.lock();
		y++;
		 
		System.out.println(this.getName()+" " +y);

	this.r.y=y;
	if(y==500) {
		cf2.signalAll();}
	if(y== 800)
	{
	y=0;}
	
	this.r.repaint();
	vfeu2.unlock();
	 
}
	 } catch (InterruptedException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
		 } finally {
			 vfeu2.unlock();
		 }

}
public void run()
{ 
traverser2();	
}
}
