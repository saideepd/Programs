import java.util. * ;
import java.io. * ;

class tryLeftRec {
	public static void main(String[] args) throws IOException {
		System.out.println("Enter production:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System. in ));
		String input = br.readLine();
		String[] pr = input.split("->");
		String[] prods = pr[1].split("/");
		String root = pr[0];
		int[] flags = new int[prods.length];
		System.out.print(root + "->");
		String rootdash = root + "'";
		for (int i = 0; i < prods.length; i++) {
			if (prods[i].indexOf(root) == 0) flags[i] = 1;
			else {
				if (i == (prods.length - 1)) System.out.print(prods[i] + rootdash);
				else System.out.print(prods[i] + rootdash + "/");
			}
		}
		System.out.println();
		System.out.print(rootdash + "->");
		for (int i = 0; i < prods.length; i++) {
			if (flags[i] == 1) System.out.print(prods[i].substring(1) + rootdash);
		}
		System.out.print("/" + (char) 238);
	}
}

/*
Enter production:
E->E+T/T
E->TE'
E'->+TE'/e

Enter production:
A->Aa/b
A->bA'
A'->aA'/e
*/
