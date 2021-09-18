package dAcc;

import java.awt.Color;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Route r1 =new Route();
 
Lock vfeu1 =new ReentrantLock();
Lock vfeu2 =new ReentrantLock();
Condition cf1 =vfeu1.newCondition();
Condition cf2 =vfeu2.newCondition();

Thread f =new Thread(new Fenetre(r1,vfeu1,vfeu2 ,cf1,cf2));

car1 car =new car1(r1,Color.red ,vfeu1,cf1);
car2 car2 =new car2(r1,Color.red ,vfeu2,cf2);

f.start();
car.start();
car2.start();

	}

}
