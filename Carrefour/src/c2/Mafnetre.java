package c2;


import java.awt.*; 
import javax.swing.*; 
import java.util.*; 
import java.awt.event.*; 
//import desperma.feux; 

class Mafenetre extends JFrame 
{ 
public Mafenetre () 
{ 
setTitle ("Carrefour"); 
setSize (550,550); 

carrefour_dessin carre = new carrefour_dessin(); 
getContentPane ().add(carre); 
} 
} 

class carrefour_dessin extends JPanel{ 
private JPanel jPanel1 = new JPanel(); 
private JButton jButton1 = new JButton(); 

public void paintComponent (Graphics g) 
{ 
super.paintComponent(g); 

//feux 
/***********************/ 
g.drawRoundRect(150,100,40,90,10,10); 
g.drawRoundRect(310,310,90,40,10,10); 
g.setColor(Color.red); 
g.fillOval(161,110,20,20); 
g.setColor(Color.orange); 
g.fillOval(161,135,20,20); 
g.setColor(Color.blue); 
g.fillOval(161,165,20,20); 
g.setColor(Color.blue); 
g.fillOval(320,320,20,20); 
g.setColor(Color.orange); 
g.fillOval(345,320,20,20); 
g.setColor(Color.red); 
g.fillOval(370,320,20,20); 

//ligne médiane 
/*****************/ 
g.setColor(Color.black); 

int x =20; 
int x2 =300; 
for (x=20; x<200; x+=10) 
g.drawString("_",x,250); 
for (x2=300; x2<500; x2+=10) 
g.drawString("_",x2,250); 

int y=50; 
int y2=300; 
for (y=50; y<201; y+=10) 
g.drawString("¦",250,y); 
for (y2=301; y2<450; y2+=10) 
g.drawString("¦",250,y2); 

//carrefour 
/*****************/ 
g.drawLine(20,200,200,200); 
g.drawLine(20,300,200,300); 
g.drawLine(300,200,500,200); 
g.drawLine(300,300,500,300); 
g.drawLine(200,50,200,200); 
g.drawLine(300,50,300,200); 
g.drawLine(200,300,200,450); 
g.drawLine(300,300,300,450); 
} 

public carrefour_dessin( ) { 
try { 
jbInit(); 
} 
catch(Exception e) { 
e.printStackTrace(); 
} 
} 

private void jbInit() throws Exception { 
jButton1.setText("jButton1"); 
jButton1.addMouseListener(new java.awt.event.MouseAdapter() { 
public void mouseClicked(MouseEvent e) { 
jButton1_mouseClicked(e); 
} 
}); 
jPanel1.add(jButton1, null); 
} 

void jButton1_mouseClicked(MouseEvent e) { 
System.exit(0); 
} 

}