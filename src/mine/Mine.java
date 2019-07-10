package mine;

public class Mine {

	  private volatile int valueOfgold = 1000;
	  private String name;
	  public Mine(String name) 
	  {
	    this.name = name;
	  }
	  
	  public void setName(String name) 
	  {
	    this.name = name;
	  }
	  public String getName() 
	  {
	    return name;
	  }
	  
	  public void setValueOfGold(int valueOfGold) 
	  {
	    this.valueOfgold=valueOfGold;
	  }
	  
	  public int getValueOfGold() 
	  {
	    return valueOfgold;
	  }
	  public String getInfo() 
	  {
	    return "Name of mine: " + getName() + "Value of gold in mine : " + getValueOfGold();
	  }
	}