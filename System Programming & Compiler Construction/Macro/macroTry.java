import java.util. * ;
import java.io. * ;

class macroTry {
	public static void main(String[] args) throws IOException {

		int mntc = 0,
		mdtc = 0,
		alac = 0,
		clac = 0;
		String[] mnTable = new String[30];
		String[] mdTable = new String[30];
		String[] alaTable = new String[30];
		String[] claTable = new String[30];
		String[] macroNameTable = new String[30];
		String[] argNames;
		String[] argArray;

		BufferedReader br = new BufferedReader(new FileReader("inputTryMacro.txt"));
		BufferedWriter mntFile = new BufferedWriter(new FileWriter("mnt.txt", true));
		BufferedWriter mdtFile = new BufferedWriter(new FileWriter("mdt.txt", true));
		BufferedWriter claFile = new BufferedWriter(new FileWriter("cla.txt", true));
		BufferedWriter alaFile = new BufferedWriter(new FileWriter("ala.txt", true));

		String temp = "";
		String macroname = "";
		String[] linearArray;
		int i,
		j,
		flag = 0;

		while ((temp = br.readLine()) != null) {

			for (i = 0; i < mntc; i++) {
				if (temp.contains(macroNameTable[i])) {
					argArray = temp.split(" ");
					argNames = argArray[1].split(",");
					for (j = 0; j < argNames.length; j++) {
						claTable[clac] = argNames[j];
						claFile.write(claTable[clac]);
						claFile.newLine();
						clac++;
					}
					break;
				}
			}

			if (flag == 1) {
				mdTable[mdtc] = mdtc + "  " + temp;
				mdtFile.write(mdTable[mdtc]);
				mdtFile.newLine();
				mdtc++;
				if (temp.contains("MEND")) {
					flag = 0;
				}
			}

			if (temp.contains("MACRO")) {
				flag = 1;
				linearArray = temp.split(" ");
				macroname = linearArray[1];
				macroNameTable[mntc] = macroname;
				mnTable[mntc] = mntc + "  " + macroname + "  " + mdtc;
				mntFile.write(mnTable[mntc]);
				mntFile.newLine();
				mntc++;
				for (i = 2; i < linearArray.length; i++) {
					//assuming only arguments present now.
					if (i == linearArray.length - 1) alaTable[alac] = alac + "  " + linearArray[i];
					else alaTable[alac] = alac + "  " + linearArray[i].substring(0, (linearArray[i].length()) - 1);
					alaFile.write(alaTable[alac]);
					alaFile.newLine();
					alac++;
				}
			}

		}

		System.out.println("ALL TABLES:  ");
		System.out.println("\nMNT TABLE");
		for (i = 0; i < mntc; i++)
		System.out.println(mnTable[i]);
		System.out.println("\nMDT TABLE");
		for (i = 0; i < mdtc; i++)
		System.out.println(mdTable[i]);
		System.out.println("\nALA TABLE");
		for (i = 0; i < alac; i++)
		System.out.println(alaTable[i]);
		System.out.println("\nCLA TABLE");
		for (i = 0; i < clac; i++)
		System.out.println(claTable[i]);

		br.close();
		mntFile.close();
		mdtFile.close();
		alaFile.close();
		claFile.close();
	}
}

/*
OUTPUT
C:\Users\Niti123\Desktop\coding\spcc>javac macroTry.java

C:\Users\Niti123\Desktop\coding\spcc>java macroTry
ALL TABLES:

MNT TABLE
0  MAC1  0
1  MAC2  4

MDT TABLE
0  LOAD A,&ARG1
1  ADD B,&ARG2
2  STORE C,&ARG3
3  MEND
4  ADD A,&ARG2
5  MEND

ALA TABLE
0  &ARG
1  &ARG
2  &ARG3
3  &AR
4  &ARG2

CLA TABLE
3
4
5
1
2
*/
