package DataProvider;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class TESTdataprovider {
	
	@DataProvider
	public static Object[][] datasuiteA(Method m ) {
		System.out.println(m.getName());
		Object[][]data = new Object[2][2];
		
		data[0][0]= "U1";
	    data[0][1]= "P1";
	   data[1][0] = "U2";
	   data[1][1] = "P2";

		return data;
		
	}

	@DataProvider
	public static Object[][] datasuiteAA(Method m ) {
		System.out.println(m.getName());
	Object[][]data = new Object[2][2];
		
		data[0][0]= "U3";
	    data[0][1]= "P3";
	   data[1][0] = "U4";
	   data[1][1] = "P4";
		return data;
		
	}
	

}
