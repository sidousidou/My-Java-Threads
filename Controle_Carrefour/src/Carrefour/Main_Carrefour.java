package Carrefour;

import java.awt.Color;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main_Carrefour {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Road r1 =new Road();

		Lock vfeu1 =new ReentrantLock();
		Lock vfeu2 =new ReentrantLock();
		Condition cf1 =vfeu1.newCondition();
		Condition cf2 =vfeu2.newCondition();

		Thread f =new Thread(new FF(r1,vfeu1,vfeu2 ,cf1,cf2));//creation d'un thread de changement de feu

		C1 car =new C1(r1,Color.black,vfeu1,cf1);//creation d'un thread car1	
		C2 car2 =new C2(r1,Color.black ,vfeu2,cf2);//creation d'un thread car2

		f.start();//faire lancer la methode run du thread changement de feu
		car.start();//fair lancer la methode run de thread car1
		car2.start();//fair lancer la methode run de thread car2

	}

}

