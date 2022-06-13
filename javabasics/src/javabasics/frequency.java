package javabasics;

public class frequency {

	public static void main(String[] args) {
		int count,x=-1;
		int ar[]= {1,3,4,5,6,3,2,4,6,7,9,4,12,3,4,6,8,9,7,6,43,2,4,7,7,5,2,1,3,4,6,311,1};
		int fr[]= new int[ar.length];
		for(int i=0;i<ar.length;i++) {
			count=1;
			for(int j=i+1;j<ar.length;j++) {
				if(ar[i]==ar[j]) {
					count++;
					fr[j]=x;
				}
			}
			
				if(fr[i]!=x)
					fr[i]=count;
			}
		for(int i=0;i<fr.length;i++) {
			if(fr[i]!=x)
			System.out.println(ar[i]+":"+fr[i]);
			
		
		
		}
	}
}





