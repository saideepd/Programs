import java.util.*;
import java.io.*;

class codeMove{

	public static void main(String args[]) {
		beforeOpt();
		afterOpt();
	}

	static void beforeOpt() {
		long start = System.nanoTime();
		int i=0;
		int a,b=2,c=3,z;
		while(i<1000)
		{
			a = b*c;
			z = a+24;
			i++;
		}
		long end = System.nanoTime();
		System.out.println((end-start)*1000);
		return;
	}
	
	static void afterOpt() {
		long start = System.nanoTime();
		int i=0;
		int a,b=2,c=3,z;
		a = b*c;
		z = a+24;
		while(i<1000)
		{		
			i++;
		}		
		long end = System.nanoTime();
		System.out.println((end-start)*1000);
		return;
	}
}

/*
OUTPUT
36391000
16542000
*/