package TESTS.Groups;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider2 {

	@Test(dataProvider = "dp1")
	public void testlogin1(String s) {
		System.out.println(s);

	}

	@DataProvider
	public String[] dp1() {
		String data[] = { "xyz", "abc", "123", "234" };
		return data;

	}

	@Test(dataProvider = "dp2")
	public void testlogin2(Integer i) {
		System.out.println(i);

	}

	@DataProvider
	public Integer[] dp2() {
		Integer data[] = { 123, 456, 678, 789, 345 };// we can only add integer to integer array
		return data;
	}

	@Test(dataProvider = "dp3")
	public void testlogin3(Object i) {
		System.out.println(i);

	}

	@DataProvider
	public Object[] dp3() {
		Object data[] = { "xyz", "abc", 123, 234 };// Object is super class of all datatatype clases so we can add ant
													// data type to that object array

		return data;
	}

	@Test(dataProvider = "dp4")
	public void testlogin4(String[] s) {
		System.out.println(s[0] + ">>>>>" + s[1]);
	}

	@DataProvider
	public String[][] dp4() {
		String data[][] = { { "xyz", "abc" }, { "123", "456" }, { "567", "789" } };
		return data;
		// if we place object array in place of string array we can add any data type to
		// that array
	}

	@Test(dataProvider = "dp5")
	public void testlogin5(String s) {
		System.out.println(s);
	}

	@DataProvider
	public Iterator<String> dp5() {
		List<String> data = new ArrayList<>();
		data.add("xyz");
		data.add("abc");
		data.add("anil");
		return data.iterator();
	}
}
