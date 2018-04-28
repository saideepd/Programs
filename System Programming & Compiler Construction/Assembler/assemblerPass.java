import java.util. * ;
import java.io. * ;
import java.io.FileReader;
import java.io.IOException;

public class assemblerPass {
	static String temp = "";
	static int i,
	j,
	relAddr = 0,
	count = 0;
	static String[] keywords;
	static int m = 0,
	p = 0,
	s = 0,
	l = 0;
	static String[] mot = new String[30];
	static String[] pot = new String[30];
	static String[] st = new String[30];
	static String[] lt = new String[30];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("inputAssembler.txt"));
		BufferedWriter motFile = new BufferedWriter(new FileWriter("mot.txt", true));
		BufferedWriter potFile = new BufferedWriter(new FileWriter("pot.txt", true));
		BufferedWriter stFile = new BufferedWriter(new FileWriter("st.txt", true));
		BufferedWriter ltFile = new BufferedWriter(new FileWriter("lt.txt", true));

		while ((temp = br.readLine()) != null) {
			if (count > 2) relAddr += 4;
			count++;
			keywords = temp.split(" ");
			for (i = 0; i < keywords.length; i++) {
				if (isMachine(keywords[i])) printMachineOp(keywords[i], motFile);
				else if (isPseudo(keywords[i])) printPseudoOp(keywords[i], potFile);
				else if (isSymbol(keywords[i])) printSymbol(keywords[i], relAddr, stFile);
				else if (isLiteral(keywords[i])) printLiteral(keywords[i], relAddr, ltFile);
			}

		}

		System.out.println("\nMOT TABLE:");
		System.out.println("machineop\tbinaryop\tlength\tformat\n");
		for (i = 0; i < m; i++)
		System.out.println(mot[i]);
		System.out.println("\nPOT TABLE:");
		System.out.println("pseudoop\taddress\n");
		for (i = 0; i < p; i++)
		System.out.println(pot[i]);
		System.out.println("\nST TABLE:");
		System.out.println("symbol\treladdr\tlength\trelocation\n");
		for (i = 0; i < s; i++)
		System.out.println(st[i]);
		System.out.println("\nLT TABLE:");
		System.out.println("literal\treladdr\tlength\trelocation\n");
		for (i = 0; i < l; i++)
		System.out.println(lt[i]);

		br.close();
		motFile.close();
		potFile.close();
		stFile.close();
		ltFile.close();

	}

	static Boolean isMachine(String word) {
		if (word.equals("L") || word.equals("A") || word.equals("ST")) return true;
		return false;
	}

	static Boolean isSymbol(String word) {
		if (word.equals("FOUR") || word.equals("FIVE") || word.equals("TEMP") || word.equals("PRG")) return true;
		return false;
	}

	static Boolean isPseudo(String word) {
		if (word.equals("START") || word.equals("USING") || word.equals("DC") || word.equals("DS") || word.equals("END")) return true;
		return false;
	}

	static Boolean isLiteral(String word) {
		if (word.contains("=F'2'")) return true;
		return false;
	}

	static void printMachineOp(String op, BufferedWriter motFile) throws IOException {
		String result = op + "\t\t-\t\t04\tRX";
		mot[m] = result;
		motFile.write(result);
		motFile.newLine();
		m++;
	}

	static void printPseudoOp(String op, BufferedWriter potFile) throws IOException {
		String result = op + "\t\tPL_" + op;
		pot[p] = result;
		potFile.write(result);
		potFile.newLine();
		p++;
	}

	static void printSymbol(String op, int relAddr, BufferedWriter stFile) throws IOException {
		String result;
		if (op.equals("PRG")) result = (op + "\t" + relAddr + "\t01\tR");
		else result = (op + "\t" + relAddr + "\t04\tR");
		st[s] = result;
		stFile.write(result);
		stFile.newLine();
		s++;
	}

	static void printLiteral(String op, int relAddr, BufferedWriter ltFile) throws IOException {
		String result = "F'2'\t" + relAddr + "\t04\tR";
		lt[l] = result;
		ltFile.write(result);
		ltFile.newLine();
		l++;
	}

}

/*
MOT TABLE:
machineop       binaryop        length  format

L               -               04      RX
A               -               04      RX
A               -               04      RX
ST              -               04      RX

POT TABLE:
pseudoop        address

START           PL_START
USING           PL_USING
DC              PL_DC
DC              PL_DC
DS              PL_DS
END             PL_END

ST TABLE:
symbol  reladdr length  relocation

PRG     0       01      R
FOUR    16      04      R
FIVE    20      04      R
TEMP    24      04      R

LT TABLE:
literal reladdr length  relocation

F'2'    8       04      R
*/
