package Carrefour;

import java.util.concurrent.Semaphore;

import sun.misc.Signal;


public class Carrefour extends Thread{

	//Semaphore sv1=1 , sv2=1 , sf1=1 , sf2=0 ;
	public static Semaphore sv1 = new Semaphore(1);
	public static Semaphore sv2 = new Semaphore(1);
	public static Semaphore sf1 = new Semaphore(1);
	public static Semaphore sf2 = new Semaphore(0);

	public static Semaphore sem = new Semaphore(0);

	/* proberen - test 
    P(sem ) {
       while (sem <= 0) {
       sem = sem - 1;}
    }


     verhogen - to increment 
    V(sem)
    {
       sem = sem + 1;
    }



    P (csem) {
       while (1)  {
          Acquire_mutex (csem.mutex);

          // NOTE: This logic should look a great case for a CV wait.
          if (csem.value <= 0) {
             insert_queue (getpid(), csem.queue);
             Release_mutex_and_block (csem.mutex); /* atomic: lost wake-up 
          } 
          else {
              csem.value = csem.value – 1;
              Release_mutex (csem.mutex);
              break;
          }
       }
    }


    V (csem) 
    {
        // NOTE: This logic should look a great case for a CV signal.
        Acquire_mutex (csem.mutex);

        csem.value = csem.value + 1;
        dequeue_and_wakeup (csem.queue)

        Release_mutex (csem.mutex);
    }



    Producer()
    {
        while (1)
        {
            <<< produce item >>>
          P(empty); /* Get an empty buffer (decrease count) , block if unavail 
          P(mutex); /* acquire critical section: shared buffer 

          <<< critical section: Put item into shared buffer >>>

          V(mutex); /* release critical section 
          V(full); /* increase number of full buffers 
        }
    }


    Consumer()
    {
        while (1)
        {
           P(full);
           P(mutex);

           <<< critical section: Remove item from shared buffer 

           V(mutex);
           V(empty);
    }




     Writer()
    {
       while (1)
       {
           P(writing);
           <<< perform write >>>
           V (writing);
       }
    }


    Reader() {
      while (1)   {
           P(mutex);
           rd_count++;
           if (1 == rd_count) /* If we are the first reader -- get write lock 
                 P(writing); /* Once we have it, it keeps writers at bay 
           V(mutex); /* 

           <<< perform read >>>

           P(mutex)
           rd_count--;
           if ( 0 == rd_count) /* If we are the last reader to leave -- 
                 V(writing);   /* Allow writers 
           V(mutex);
       } 
    }


	 */


	public void changement(){
		int feu =1;  //voie 1 feu vert


		while (1) {

			sleep(3000);
			if (feu == 1) {
				try {
					sf1.acquire(); /*thread stops here until it gets permit to go on*/
				}catch (InterruptedException e) {} /*exception must be caught or thrown*/
				//CRITICAL SECTION
				sf2.release();
				feu = 2;
			}else {
				try {
					sf2.acquire(); /*thread stops here until it gets permit to go on*/
				}catch (InterruptedException e) {} /*exception must be caught or thrown*/
				//CRITICAL SECTION
				sf1.release();
				feu = 1;
			}


		}

	}



	public void traversee1(){
		try {
			sv1.acquire(); /*thread stops here until it gets permit to go on*/
		}catch (InterruptedException e) {} /*exception must be caught or thrown*/

		try {
			sf1.acquire(); /*thread stops here until it gets permit to go on*/
		}catch (InterruptedException e) {} /*exception must be caught or thrown*/


		//circuler();

		sf1.release();
		sv1.release();

	}


	
	public void traversee2(){
		try {
			sv2.acquire(); /*thread stops here until it gets permit to go on*/
		}catch (InterruptedException e) {} /*exception must be caught or thrown*/

		try {
			sf2.acquire(); /*thread stops here until it gets permit to go on*/
		}catch (InterruptedException e) {} /*exception must be caught or thrown*/


		//circuler();

		sf2.release();
		sv2.release();

	}


}
