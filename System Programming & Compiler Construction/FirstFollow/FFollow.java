import java.util.*;
import java.io.*;
class FFolllow {
	static char ntermnl[], termnl[];
	static int ntlen, tlen;
	static String grmr[][], flw[];
	public static void main(String args[]) throws IOException {
		String nt, t;
		int i, j, n;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the non-terminals: ");
		nt = br.readLine();
		ntlen = nt.length();
		ntermnl = new char[ntlen];
		ntermnl = nt.toCharArray();
		System.out.print("Enter the terminals: ");
		t = br.readLine();
		tlen = t.length();
		termnl = new char[tlen];
		termnl = t.toCharArray();
		System.out.println("Specify the grammar(Enter 9 for epsilon production)");
		grmr = new String[ntlen][];
		for (i = 0; i < ntlen; i++) {
			System.out.print("Enter the number of productions for " + ntermnl[i]+" : ");
			n = Integer.parseInt(br.readLine());
			grmr[i] = new String[n];
			System.out.print("Enter the productions: ");
			for (j = 0; j < n; j++)
				grmr[i][j] = br.readLine();
		}
		flw = new String[ntlen];
		for (i = 0; i < ntlen; i++)
			flw[i] = follow(i);
		System.out.println("Follow Set");
		for (i = 0; i < ntlen; i++)
			System.out.println(ntermnl[i]+"\t"+removeDuplicates(flw[i]));
	}
	static String follow(int i) {
		int flag=0;
		char pro[], chr[];
		String temp = "";
		int j, k, l, m, n, found = 0;
		if (i == 0)
			temp = "$";
		for (j = 0; j < ntlen; j++) {
			for (k = 0; k < grmr[j].length; k++) { 
				pro = new char[grmr[j][k].length()];
				pro = grmr[j][k].toCharArray();
				for (l = 0; l < pro.length; l++) { 
					if (pro[l] == ntermnl[i]) { 
						if (l == pro.length - 1) { 
							if (j < i)
								temp = temp + flw[j];
						} 
					}
				}
			}
		}
		return temp;
	}
	static String removeDuplicates(String str) {
		int i;
		char ch;
		boolean seen[] = new boolean[256];
		StringBuilder sb = new StringBuilder(seen.length);
		for (i = 0; i < str.length(); i++) {
			ch = str.charAt(i);
			if (!seen[ch]) {
				seen[ch] = true;
				sb.append(ch);
			}
		}
		return sb.toString();
	}
	static int checkterminal(char ch) {
		int flag=0;
		for(int i=0;i<termnl.length;i++){
			if(termnl[i]==ch)
				flag=1;
		}	
		return flag;
	}
}
/*OUTPUT:

Enter the non-terminals: SA
Enter the terminals: ab
Specify the grammar(Enter 9 for epsilon production)
Enter the number of productions for S : 1
Enter the productions: AA
Enter the number of productions for A : 1
Enter the productions: aA
Follow Set
S       $
A       a$*/

