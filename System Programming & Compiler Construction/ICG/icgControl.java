import java.util. * ;
import java.io. * ;

public class icgControl {
	static int tc = 0,
	no = 100,
	n;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System. in );
		System.out.println("Enter no of statements");
		n = sc.nextInt();
		int i,
		j,
		k;
		String[] loop = new String[n];
		BufferedReader br = new BufferedReader(new InputStreamReader(System. in ));
		for (i = 0; i < n; i++) {
			loop[i] = br.readLine();
		}

		genCode(loop);
	}
	static void genCode(String[] loop) {
		int controlType = getType(loop[0]);
		if (controlType == 0) {
			int closeBracket = loop[0].indexOf(")");
			System.out.println(no + ": if " + loop[0].substring(6, closeBracket) + " goto " + (no + 2));
			System.out.println((no + 1) + ": goto " + (no + n));
			no = no + 2;
			for (int i = 2; i < n - 1; i++) {
				System.out.println(no + ": " + loop[i]);
				no++;
			}
			System.out.println(no + ": goto 100");
		}
		else if (controlType == 1) {
			String[] forCondition = loop[0].split(";");
			System.out.println(no + ": " + forCondition[0].substring(4, forCondition[0].length()));
			no++;
			System.out.println(no + ": if " + forCondition[1] + " goto " + (no + 2));
			no++;
			System.out.println(no + ": goto " + (no + n - 1));
			no++;
			for (int i = 2; i < n - 1; i++) {
				System.out.println(no + ": " + loop[i]);
				no++;
			}
			System.out.println(no + ": " + forCondition[2].substring(0, forCondition[2].length() - 1) + " goto 101");
		}
		else {
			//execute switch if lots of time in life.
		}
	}

	static int getType(String loop) {
		if (loop.contains("while")) return 0; //for while control loop
		else if (loop.contains("for")) return 1; //for for control loop
		else return 2; //for switch control loop
	}
}

/*
OUTPUT

Enter no of statements
5
while(i<0)
{
x=1;
y=x+1;
}
100: if i<0 goto 102
101: goto 105
102: x=1;
103: y=x+1;
104: goto 100


Enter no of statements
4
for(i=0;i<n;i++)
{
x=x+1;
}
100: i=0
101: if i<n goto 103
102: goto 105
103: x=x+1;
104: i++ goto 101
*/
