package javabasics;

public class test {
	int i;
	public static void main(String[] args) {
	test t1 = new test();
	t1.i=100;
	test t2 = new test();
	t2.i=200;
	test t3 = new test();
	t3.i=300;
	t1=t3;
	t3.i=200+t1.i;
	System.out.print(t1.i);
	t3= new test();
	t2=t3;
	System.out.print(t2.i);
	}

	}

