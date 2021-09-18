package dAcc;
 	
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Route extends JPanel {
public	Image img , img1,img2;

int feu,x=0 ,y=0;
 public Color col ;
public Route()
{
	

try {
	img1= ImageIO.read(new File("C:/Users/Amine/Desktop/bbb/car/1.png"));
	img2= ImageIO.read(new File("C:/Users/Amine/Desktop/bbb/car/2.png"));
	 img= ImageIO.read(new File("C:/Users/Amine/Desktop/bbb/car/route.png"));
	x=0;
	y=0;
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}


}
@Override
public void  paintComponent(Graphics g)
{

	
	g.drawImage(img,0,0,this.getWidth(),this.getHeight(), this);
 
	g.drawImage(img1,180,140,101,101, this);
	g.drawImage(img2,140,500,140,100, this);
	g.setColor(col);
    g.fillRoundRect(x, 400, 55, 30, 5, 5);
	 g.fillRoundRect(300, y, 50, 50, 5, 5);
			 


}
 
}
