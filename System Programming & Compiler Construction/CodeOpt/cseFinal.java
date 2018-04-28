import java.util.*;
import java.io.*;

class cseFinal {

	public static void main(String args[]) {
		beforeOpt();
		afterOpt();
	}

	static void beforeOpt() {
		long start = System.nanoTime();
		int r=14;
		double circ = 2*3.14*r;
		double ar = 3.14*r*r;
		long end = System.nanoTime();
		System.out.println((end-start)*1000);
		return;
	}

	static void afterOpt() {
		long start = System.nanoTime();
		int r=14;
		double temp=3.14*r;
		double circ = 2*temp;
		double ar = r*temp;		
		long end = System.nanoTime();
		System.out.println((end-start)*1000);
		return;	
	}
}

/*
755000
378000
*/