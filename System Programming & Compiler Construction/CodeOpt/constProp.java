import java.util.*;
import java.io.*;

class constProp {

	public static void main(String args[]) {
		beforeOpt();
		afterOpt();
	}

	static void beforeOpt() {
		long start = System.nanoTime();
		int x=14;
		int y=x-5+3/2;
		long end = System.nanoTime();
		System.out.println((end-start)*1000);
		return;
	}

	static void afterOpt() {
		long start = System.nanoTime();
		int y=14-5+3/2;
		long end = System.nanoTime();
		System.out.println((end-start)*1000);
		return;
	}
}
/*378000
0*/