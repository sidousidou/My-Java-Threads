
public class Robot1 extends Thread{
	private static int x=20;
	GRobot g=new GRobot();
	public void run(){
		while (true) {
			try {
				sleep(1000);
				x=g.travarséV(x,Math.floorDiv(x, 50));
			} catch (InterruptedException e) {}
			
		}
	}
	public static int getX() {
		return x;
	}
	public static void setX(int x) {
		Robot1.x = x;
	}
	

}
