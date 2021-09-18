import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Monde extends JPanel implements ActionListener{
	ImageIcon Robot;
	static Robot1 R1=new Robot1();
	static Robot2 R2=new Robot2();
	
	Timer tm=new Timer(1000, this);
	public void paintComponent(Graphics g ){
		super.paintComponent(g);
		for(int i=70;i<=570;i+=50){
			for(int j=70;j<=570;j+=50){
				g.setColor(Color.BLACK);
				g.drawRect(i,j, 50, 50);
			}
		}
		for(int i=70;i<=570;i+=50){
				Robot = new ImageIcon("src/img/RB.png");
				Robot.paintIcon(this, g, i, R2.getX());
				Robot.paintIcon(this, g, R1.getX(), i);
			}
		
		tm.start();

		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Monde m=new Monde();
		JFrame JF=new JFrame();
		JF.setTitle("DAC");
		JF.setSize(1200, 800);
		JF.setVisible(true);
		JF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JF.setLayout(null);
		JButton start=new JButton("Start");
		start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				R1.start();
				R2.start();
				
			}
		});
		
		start.setBounds(800, 350, 80, 20);
		JF.add(start);
		m.setBounds(0, 0, 700, 700);
		JF.add(m);
	}
}
