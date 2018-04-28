import java.util. * ;
import java.io. * ;

public class icgBool {
	static int no = 100,
	tc = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System. in );
		System.out.println("Enter equation");
		String eq = sc.next();
		tc = genCode(eq);
	}

	public static int genCode(String eq) {
		if (eq.contains("||")) {
			int orIndex = eq.indexOf("||");
			String orLHS = eq.substring(0, orIndex);
			String orRHS = eq.substring(orIndex + 2, eq.length());
			int tcl = genCode(orLHS);
			int tcr = genCode(orRHS);
			System.out.println((no) + ": t" + tcr + " = t" + (tcl - 1) + " or t" + (tcr - 1));
			tc++;
			no++;
		}
		else if (eq.contains("&&")) {
			int andIndex = eq.indexOf("&&");
			String andLHS = eq.substring(0, andIndex);
			String andRHS = eq.substring(andIndex + 2, eq.length());
			int tcl = genCode(andLHS);
			int tcr = genCode(andRHS);
			System.out.println((no) + ": t" + tcr + " = t" + (tcl - 1) + " and t" + (tcr - 1));
			tc++;
			no++;
		}
		else {
			System.out.println(no + ": " + "if " + eq + " goto " + (no + 2));
			System.out.println((no + 1) + ": t" + tc + " = 0; goto " + (no + 3));
			System.out.println((no + 2) + ": t" + tc + " = 1;");
			no = no + 3;
			tc = tc + 1;
		}
		return tc;
	}
}

/*
OUTPUT
C:\Users\Niti123\Desktop\coding\spcc>javac icgBool.java

C:\Users\Niti123\Desktop\coding\spcc>java icgBool
Enter equation
a>b&&c>d&&e<f
100: if a>b goto 102
101: t0 = 0; goto 103
102: t0 = 1;
103: if c>d goto 105
104: t1 = 0; goto 106
105: t1 = 1;
106: if e<f goto 108
107: t2 = 0; goto 109
108: t2 = 1;
109: t3 = t1 and t2
110: t4 = t0 and t3

C:\Users\Niti123\Desktop\coding\spcc>java icgBool
Enter equation
a<b&&f<t||e>h
100: if a<b goto 102
101: t0 = 0; goto 103
102: t0 = 1;
103: if f<t goto 105
104: t1 = 0; goto 106
105: t1 = 1;
106: t2 = t0 and t1
107: if e>h goto 109
108: t3 = 0; goto 110
109: t3 = 1;
110: t4 = t2 or t3
*/
