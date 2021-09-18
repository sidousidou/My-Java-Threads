package Carrefour;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class FF extends JFrame implements Runnable{
	
	private static final long serialVersionUID = 1L;
	
	
	Road r ; //la route
	Lock vfeu1,vfeu2; //verrou du feu 1 et feu 2
	Condition cf1, cf2; //condition du voiture
	FF(Road r , Lock v,Lock v1,Condition cf1,Condition cf2) //constructeur
	{	this.cf2=cf2;  //init
	this.cf1=cf1;
	this.vfeu1=v;
	this.vfeu2=v1;
	this.r=r;
	this.setTitle("Circulation"); //le nom du Panel
	this.setSize(800, 800); // la taille du Panle
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //l'arret d'execution en cliquant sur exit 
	this.setLocationRelativeTo(null);
	this.setContentPane(r);// le contenue de projet 

	this.setVisible(true);//faire apparaitre le panel 

	}
	private void changer() {//methode de changement de feu
		// TODO Auto-generated method stub

		try {
			while (true) {


				Thread.sleep(1000);
				vfeu1.lock();
				vfeu2.lock();
				if(r.feu==1)
				{
					//if(r.x>=100 && r.x<400)
					if(r.x>=100 && r.x<200)
					{
						cf1.await();

					}


					r.img= ImageIO.read(new File("C:/Users/Anonyme/Tutorials/DAC_Controle_Carrefour/src/Carrefour/route.png"));

					r.img1=ImageIO.read(new File("C:/Users/Anonyme/Tutorials/DAC_Controle_Carrefour/src/Carrefour/pietonvert.png"));
					r.img2= ImageIO.read(new File("C:/Users/Anonyme/Tutorials/DAC_Controle_Carrefour/src/Carrefour/pietonrouge.png"));
					r.feu=2;
				}else
				{
					//if(r.y>=120 && r.y<300)
					if(r.y>=200 && r.y<300)
					{ 
						cf2.await();
					}

					r.img= ImageIO.read(new File("C:/Users/Anonyme/Tutorials/DAC_Controle_Carrefour/src/Carrefour/route.png"));

					r.img1=ImageIO.read(new File("C:/Users/Anonyme/Tutorials/DAC_Controle_Carrefour/src/Carrefour/pietonrouge.png"));
					r.img2= ImageIO.read(new File("C:/Users/Anonyme/Tutorials/DAC_Controle_Carrefour/src/Carrefour/pietonvert.png"));


					r.feu=1;


				}
				
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
	public void run() {//faire appeler la methode changer 
		// TODO Auto-generated method stub
		changer();

	}

}
