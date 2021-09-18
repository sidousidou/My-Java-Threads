import java.util.concurrent.Semaphore;

public class GRobot {
	
	static Semaphore S2[]=new Semaphore[10];
	public GRobot(){
		for(int i=0;i<10;i++)
			S2[i]=new Semaphore(0);
	}
	public int travarséH(int x,int i) throws InterruptedException{
		
		if(x==570){
			x=20;
		}else{
			
			x=x+50;
		}
		S2[i].release();
		return x;
		
	}
	public int travarséV(int x,int i) throws InterruptedException{
		S2[i].acquire();
		if(x==570){
			x=20;
		}else{
			x=x+50;
		}
				
		
		return x;
		
	}
}
