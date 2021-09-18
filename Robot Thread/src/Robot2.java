

public class Robot2 extends Thread {

	private int x=20;
	GRobot g1 = new GRobot() ;
	
	public void run(){
		
		while (true) {
			try {
				sleep(1000);
				x=g1.travarséH(x,Math.floorDiv(x, 50));
			} catch (InterruptedException e) {}
			
		}
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	
}
