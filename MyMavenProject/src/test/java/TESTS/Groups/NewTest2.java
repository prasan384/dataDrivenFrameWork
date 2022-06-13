package TESTS.Groups;

import org.testng.annotations.Test;

public class NewTest2 {
  @Test(groups= {"smoke"})
  public void test4() {
	  System.out.println("test4");
  }
  @Test (groups= {"smoke","functional","sanity"})
  public void test5() {
	  System.out.println("test5");
  }
  @Test(groups= {"regression","functional"})
  public void test6() {
	  System.out.println("test6");
  }
  @Test
  public void test7() {
	  System.out.println("test7");
  }
}
