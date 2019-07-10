package mine;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;



public class App {

	public static void main(String[] args) {
		Mine mine = new Mine("Minecraft");
	    List<Worker> listOfWorkers = new ArrayList<>();
	    Semaphore cd = new Semaphore(1);
	    listOfWorkers.add(new Worker("1",cd,mine));
	    listOfWorkers.add(new Worker("2",cd,mine));
	    listOfWorkers.add(new Worker("3",cd,mine));
	    long startTime = System.currentTimeMillis();
	    while(mine.getValueOfGold() > 0) 
	    {
	      if(((System.currentTimeMillis() - startTime) / 1000) > 10) 
	      {
	        startTime = System.currentTimeMillis();
	        listOfWorkers.add(new Worker(Integer.toString(listOfWorkers.size()+1), cd, mine));
	      }
	      for(Worker worker : listOfWorkers) 
	      {
	        System.out.println("Worker " + worker.getName() + "starts work");
	        new Thread(worker).start();
	        try {
	          TimeUnit.SECONDS.sleep(3);
	        } catch (InterruptedException e) {
	          e.printStackTrace();
	        }
	        System.out.println("Finish his work, gold left's in mine " + mine.getValueOfGold());
	        
	      }
	    }}}