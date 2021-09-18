package dAcc;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Fenetre extends JFrame implements Runnable{
	Route r ;
	Lock vfeu1,vfeu2;
	Condition cf1, cf2;
	Fenetre(Route r , Lock v,Lock v1,Condition cf1,Condition cf2)
	{	this.cf2=cf2;
		this.cf1=cf1;
		this.vfeu1=v;
		this.vfeu2=v1;
		this.r=r;
		this.setTitle("Animation");
		this.setSize(800, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(r);
		
		this.setVisible(true);
		
	}
	private void changer() {
		// TODO Auto-generated method stub
		
		try {
		while (true) {
		 
		
			Thread.sleep(1000);
			vfeu1.lock();
			vfeu2.lock();
		if(r.feu==1)
		{
			if(r.x>=150 && r.x<500)
			{
			cf1.await();
			 
			}
			
			
			  r.img= ImageIO.read(new File("C:/Users/Amine/Desktop/bbb/car/route.png"));
 
			r.img1=ImageIO.read(new File("C:/Users/Amine/Desktop/bbb/car/2.png"));
			r.img2= ImageIO.read(new File("C:/Users/Amine/Desktop/bbb/car/1.png"));
 				r.feu=2;
		}else
		{
			if(r.y>=188 && r.y<500)
			{ 
			cf2.await();
			}
			
			  r.img= ImageIO.read(new File("C:/Users/Amine/Desktop/bbb/car/route.png"));
			  
				r.img1=ImageIO.read(new File("C:/Users/Amine/Desktop/bbb/car/1.png"));
				r.img2= ImageIO.read(new File("C:/Users/Amine/Desktop/bbb/car/2.png"));
				  
			
			r.feu=1;
			
			
		}
		System.out.println("h");
		r.repaint();
		vfeu1.unlock();
		vfeu2.unlock();
	}
		} catch (InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
	
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		changer();

	}

}
