package mine;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Worker implements Runnable{

  private String name;
  private Semaphore sem;
  private Mine mine;
  
  public Worker(String name, Semaphore sem,Mine mine) 
  {
    this.name=name;
    this.sem=sem;
    this.mine=mine;
  }
  
  public void setName (String name) 
  {
    this.name=name;
  }
  
  public String getName() 
  {
    return name;
  }
  
  public Mine getMine() 
  {
    return mine;
  }
  public void getGold() 
  {
    getMine().setValueOfGold(getMine().getValueOfGold() - 10);
  }
  
  @Override
  public void run() {
    try {
    	
      sem.acquire();
      if(mine.getValueOfGold()<=0) {
  		System.out.println("Worker done their work");
  		System.exit(0);
  	}
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    getGold();
    sem.release();
    
    
  }

  
}