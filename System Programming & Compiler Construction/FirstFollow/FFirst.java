import java.util.*;
import java.io.*;
class FFirst {
	static char ntermnl[], termnl[];
	static int ntlen, tlen;
	static String grmr[][], fst[];
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
		System.out.println("Specify the grammar");
		grmr = new String[ntlen][];
		for (i=0; i<ntlen; i++) {
			System.out.print("Enter the number of productions for " + ntermnl[i]+" : ");
			n = Integer.parseInt(br.readLine());
			grmr[i] = new String[n];
			System.out.print("Enter the productions: ");
			for (j=0; j<n; j++)
				grmr[i][j] = br.readLine();
		}
		fst = new String[ntlen];
		for (i=0; i<ntlen; i++)
			fst[i] = first(i);
		System.out.println("First Set");
		for (i=0; i<ntlen; i++)
			System.out.println(ntermnl[i]+"\t"+removeDuplicates(fst[i]));
	}
	static String first(int i) {
		int j, k, l = 0, found = 0;
		String temp = "", str = "";
		for (j = 0; j < grmr[i].length; j++) { 
			for (k = 0; k < grmr[i][j].length(); k++, found = 0) {
				for (l = 0; l < ntlen; l++) {
					if (grmr[i][j].charAt(k) == ntermnl[l]) { 
						str = first(l);
						if (!(str.length() == 1 && str.charAt(0) == '9'))
							temp = temp + str;
						found = 1;
						break;
					}
				}
				if (found == 1) {
					if (str.contains("9"))
						continue;
				} else
					temp = temp + grmr[i][j].charAt(k);
				break;
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
First Set
S       a
A       a*/