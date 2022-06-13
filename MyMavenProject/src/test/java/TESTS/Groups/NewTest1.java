package TESTS.Groups;

import org.testng.annotations.Test;

public class NewTest1 {
	
  @Test(groups= {"smoke","sanity"})
  public void test1() {
	  System.out.println("test1");
  }
  @Test(groups= {"regression","sanity"})
  public void test2() {
	  System.out.println("test2");
  }
  @Test(groups= {"functional"})
  public void test3() {
	  System.out.println("test3");
  }
 
}
