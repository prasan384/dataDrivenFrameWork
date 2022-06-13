package javabasics;

public class LeastnumberINarray {

		public static void main(String[] args) {
			int ar[]= {31,4,98,9,2738,8902};
			int x=ar[0];
			for(int i=0;i<ar.length;i++) {
				if(x>ar[i]) {
					x=ar[i];
				}
			}
			System.out.println(x);
		}

	}

