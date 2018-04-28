import java.io. * ;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
class macro1 {
  public static void main(String args[]) throws IOException {
    int MDTC = 1;
    int MNTC = 1;
    int index = 1;
    int macroindex = 0;
    String arg[] = new String[10];
    String mname[] = new String[10];
    String MNT[][] = new String[10][10];
    String MDT[][] = new String[10][10];
    String output = new Scanner(new File("file1.txt")).useDelimiter("\\Z").next();
    String result[] = output.split("\n");
    String result1[] = output.split("[, \\s\\ ? ]");
    for (int k = 0; k < result1.length; k++) {
      if (result1[k].equals("MACRO") || result1[k].equals("macro")) {
        mname[macroindex] = result1[k + 2];
        macroindex++;
      }
    }
    System.out.println("\nMACRO NAME TABLE\n--------------");
    System.out.println("VALUE OF MDTC\tMNTC\tNAME");
    for (int k = 0; k < macroindex; k++) {
      System.out.println("\t" + MDTC + "\t" + MNTC + "\t" + mname[k]);
      MNTC = MNTC + 1;
    }
    System.out.println("\n\nMACRO DEF TABLE\n--------------");
    System.out.println("INDEX\tCODE");
    for (int i = 1; i < result.length; i++) {
      System.out.println(MDTC + "\t" + result[i]);
      MDTC = MDTC + 1;
    }
    System.out.print("\n\nARGUMENT LIST ARRAY\n-----------");
    for (int k = 3; k < result1.length; k++) {
      if (result1[k].equals(mname[0])) {
        arg[0] = result1[k + 1];
        arg[1] = result1[k + 2];
        arg[2] = result1[k + 3];
      }
    }
    System.out.println("\nINDEX\t ARGUMENTS");
    System.out.println("\n" + index + "\t" + arg[0] + "\t" + arg[1] + "\n" + (index + 2) + "\t" + arg[2] + "\n");
    System.out.print("\n\n OUTPUT PROGRAM AFTER CALL\n-----------");
    for (int k = 6; k < result1.length; k++) {
      for (int i = 3; i < 6; i++) {
        if (result1[k].equals(result1[i])) {
          result1[k] = arg[i - 3];
        }
      }
    }
    for (int k = 6; k < result1.length; k++) {
      if (result1[k].equals("MEND")) {
        System.out.print("END");
        break;
      }
      if (result1[k].equals("")) System.out.println();
      else System.out.print(result1[k] + " ");
    }
  }
}

/*
OUTPUT:
MACRO NAME TABLE
--------------
VALUE OF MDTC   MNTC    NAME
        1       1       INCR
        1       2       DECR


MACRO DEF TABLE
--------------
INDEX   CODE
1       INCR &x, &y, &REG=AREG
2       MOVER &REG, &x
3       ADD &REG, &y
4       MOVEM &REG, &x
5       MEND
6       MACRO
7       DECR &A, &B, &REG=BREG
8       MOVER &REG, &A
9       SUB &REG, &B
10      MOVEM &REG, &A
11      MEND
12      START 100
13      READ N1
14      READ N2
15      INCR N1, N2, REG=CREG
16      DECR N1, N2
17      STOP
18      N1
19      N2
20      END


ARGUMENT LIST ARRAY
-----------
INDEX    ARGUMENTS

1       N1
3       N2



 OUTPUT PROGRAM AFTER CALL
-----------
&REG=AREG
MOVER &REG
N1
ADD &REG
N2
MOVEM &REG
N1
END*/

/*
file1.txt:
MACRO
INCR &x, &y, &REG=AREG
MOVER &REG, &x
ADD &REG, &y
MOVEM &REG, &x
MEND
MACRO
DECR &A, &B, &REG=BREG
MOVER &REG, &A
SUB &REG, &B
MOVEM &REG, &A
MEND
START 100
READ N1
READ N2
INCR N1, N2, REG=CREG
DECR N1, N2
STOP
N1
N2
END
*/
