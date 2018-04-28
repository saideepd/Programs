import java.util.* ;
import java.io.* ;

public class codeGen {
	public static void main(String[] args) {
		int i,
		j,
		n;
		System.out.println("Enter no of statements");
		Scanner sc = new Scanner(System. in );
		n = sc.nextInt();
		String[] eq = new String[n];
		int regno = 0;
		System.out.println("Enter the equations");
		for (i = 0; i < n; i++) {
			eq[i] = sc.next();
		}
		for (i = 0; i < n; i++) {
			regno = genCode(eq[i], regno);
		}

	}
	private static int genCode(String eq, int regno) {
		int flag = checkType(eq);
		String op = "";
		int opIndex = 0,
		eqIndex;
		int len = eq.length();
		if (flag == 0) {
			eqIndex = eq.indexOf("=");
			//eqn type = 3ac
			if (eq.contains("*")) {
				op = "MUL";
				opIndex = eq.indexOf("*");
			}
			else if (eq.contains("/")) {
				op = "DIV";
				opIndex = eq.indexOf("/");
			}
			else if (eq.contains("+")) {
				op = "ADD";
				opIndex = eq.indexOf("+");
			}
			else if (eq.contains("-")) {
				op = "SUB";
				opIndex = eq.indexOf("-");
			}
			System.out.println("MOV R" + regno + " , " + eq.substring(opIndex + 1, len - 1));
			System.out.println("MOV R" + (regno + 1) + " , " + eq.substring(eqIndex + 1, opIndex));
			System.out.println(op + " R" + regno + " , R" + (regno + 1));
			System.out.println("MOV " + eq.substring(0, eqIndex) + " , R" + regno);
			regno = regno + 2;
			return regno;
		}
		else {
			eqIndex = eq.indexOf("=");
			System.out.println("MOV R" + regno + " , " + eq.substring(eqIndex + 1, len - 1));
			System.out.println("MOV " + eq.substring(0, eqIndex) + " , R" + regno);
			regno = regno + 1;
			return regno;
		}
	}

	private static int checkType(String line) {
		if (line.contains("*") || line.contains("/") || line.contains("+") || line.contains("-")) {
			return 0; //implies eqn type is 3ac
		}
		return 1; //implies eqn type is direct assignment
	}
}

/*
OUTPUT:
Enter no of statements
2
Enter the equations
a=b+c;
d=gh;
MOV R0 , c
MOV R1 , b
ADD R0 , R1
MOV a , R0
MOV R2 , gh
MOV d , R2
*/
