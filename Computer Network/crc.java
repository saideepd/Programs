import java.util.*;
class crc {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int data_bits,divisor_bits,total,i,j;

//Input Data
		System.out.println("Enter number of Data bits: ");
		data_bits = sc.nextInt();
		int data[] = new int[data_bits];

		System.out.println("Enter Data bits: ");
		for(i=0; i<data_bits; i++)
			data[i] = sc.nextInt();

		System.out.println("Enter number of Divisor bits: ");
		divisor_bits = sc.nextInt();
		int divisor[] = new int[divisor_bits];

		System.out.println("Enter Divisor bits: ");
		for(i=0; i<divisor_bits; i++)
			divisor[i] = sc.nextInt();

// Print Data
		System.out.println();
		System.out.print("Data Bits: ");
		for(i=0; i<data_bits; i++)
			System.out.print(data[i]);
		System.out.println();

		System.out.print("Divisor Bits: ");
		for(i=0; i<divisor_bits; i++)
			System.out.print(divisor[i]);
		System.out.println();

		total = data_bits + divisor_bits - 1;
		int div[] = new int[total];
		int rem[] = new int[total];
		int crc[] = new int[total];

// CRC Generate
		for(i=0; i<data.length; i++)
			div[i] = data[i];

		System.out.print("Dividend after appending 0's: ");
		for(i=0; i<div.length; i++)
			System.out.print(div[i]);
		System.out.println();

		for(j=0; j<div.length; j++) {
			rem[j] = div[j];
		}

		rem = divide(div, divisor, rem);

		for(i=0; i<div.length; i++) {
			crc[i]=(div[i]^rem[i]);		//appending zeroes
		}

		System.out.println();
		System.out.print("CRC Code:");
		for(i=0; i<crc.length; i++)
			System.out.print(crc[i]);
		System.out.println();

// Error Detection
		System.out.println();
		System.out.println("Enter CRC code of "+total+" bits: ");
		for(i=0; i<crc.length; i++)
			crc[i] = sc.nextInt();
		System.out.println();

		for(j=0; j<crc.length; j++) {
			rem[j]=crc[j];
		}

		rem = divide(crc, divisor, rem);

		for(i=0; i<rem.length; i++) {
			if(rem[i]!=0) {
				System.out.println("Error");
				break;
			}
			if(i==rem.length-1)
				System.out.println("No Error");
		}
	}	

	static int[] divide(int div[], int divisor[], int rem[])
	{
		int cur=0,i;
		while(true) {
			for(i=0; i<divisor.length; i++)
				rem[cur+i] = (rem[cur+i] ^ divisor[i]);

			while(rem[cur]==0 && cur!=rem.length-1)
				cur++;

			if((rem.length-cur)<divisor.length)
				break;
		}
		return rem;
	}
}

/*
Output:
Enter number of Data bits:
10
Enter Data bits:
1
1
0
1
0
1
1
0
1
1
Enter number of Divisor bits:
5
Enter Divisor bits:
1
0
0
1
1

Data Bits: 1101011011
Divisor Bits: 10011
Dividend after appending 0's: 11010110110000

CRC Code:11010110111110

Enter CRC code of 14 bits:
1
1
0
1
0
1
1
0
1
1
1
1
1
0

No Error
*/