package Carrefour;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Road extends JPanel {
	public	Image img , img1,img2,imgsdo,imgtak;

	int feu,x=0 ,y=0;//initialisation de coordonnees x et y 
	public Color col ;//faire instancier du classe Color
	public Road()//constucteur qui initialise les images du projet
	{


		try {
			img1= ImageIO.read(new File("C:/Users/Anonyme/Tutorials/DAC_Controle_Carrefour/src/Carrefour/pietonrouge.png"));
			img2= ImageIO.read(new File("C:/Users/Anonyme/Tutorials/DAC_Controle_Carrefour/src/Carrefour/pietonvert.png"));
			img= ImageIO.read(new File("C:/Users/Anonyme/Tutorials/DAC_Controle_Carrefour/src/Carrefour/route.png"));
			x=0;
			y=0;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	@Override
	public void  paintComponent(Graphics g)//methode qui fait apparaitre le contenue de panel
	{

		try {
			imgsdo = ImageIO.read(new File("C:/Users/Anonyme/Tutorials/DAC_Controle_Carrefour/src/Carrefour/sdo.png"));
			imgtak = ImageIO.read(new File("C:/Users/Anonyme/Tutorials/DAC_Controle_Carrefour/src/Carrefour/taki.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		g.drawImage(img,0,0,this.getWidth(),this.getHeight(), this);//dessiner l'image sur le panel

		g.drawImage(img1,177 ,167,80,80, this);

		g.drawImage(img2,177,500,80,80, this);

		g.setColor(col);

		g.drawImage(imgsdo, x, 390, 100, 60, this);

		g.drawImage(imgtak, 320, y, 60, 100, this);

	}

}
