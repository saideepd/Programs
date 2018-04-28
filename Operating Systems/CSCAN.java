import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Arrays;


/* Name of the class has to be "Main" only if the class is public. */
class CSCAN
{

	final static int INF = 1 << 10;
	public static void main(String[] args)
	{
		int i, op,start;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of tracks:");
		int n = sc.nextInt();
		int tracks[] = new int [n];
		System.out.println("Enter tracks:");
		for(i = 0; i < n; i++)
			tracks[i] = sc.nextInt();
		System.out.println("Enter starting track:");
		start = sc.nextInt();
		System.out.println("Enter option:");
		System.out.println("1. C-SCAN UP\n2. C-SCAN DOWN");
		op = sc.nextInt();
		switch(op){
			case 1: cscan_up(tracks,start,n);break;
			case 2: cscan_down(tracks,start,n);break;
		}
	}

	static void cscan_up(int[] tracks,int start, int n) {
		Arrays.sort(tracks);
		int i, j, previous = start, min, diff, pos = -1;
		boolean visited[] = new boolean[n];
		float sum = 0, avg;
		for(i = 0; i < n; i++)
			if(tracks[i] > start)	
				break;
		pos = i;
		System.out.println("Track\tNo of tracks traversed");
		for(;i < n; i++)
		{
			diff = tracks[i] - previous;
			diff = diff > 0?diff: - diff;
			System.out.println(tracks[i]+"\t"+diff);
			sum += diff;
			previous = tracks[i];
		}
		for(i = 0; i < pos; i++ )
		{
			diff = tracks[i] - previous;
			diff = diff > 0?diff: - diff;
			System.out.println(tracks[i]+"\t"+diff);
			sum += diff;
			previous = tracks[i];
		}
		
		avg = sum/n;
		System.out.println("Total number of tracks traversed: "+sum+
				"\nAverage: number of tracks traversed: "+avg);		
	}
	static void cscan_down(int[] tracks,int start, int n) {
		Arrays.sort(tracks);
		int i, j, previous = start, min, diff, pos = -1;
		boolean visited[] = new boolean[n];
		float sum = 0, avg;
		for(i = n-1; i >= 0; i--)
			if(tracks[i] < start)	
				break;
		pos = i;
		System.out.println("Track\tNo of tracks traversed");
		for(;i >=0 ; i--)
		{
			diff = tracks[i] - previous;
			diff = diff > 0?diff: - diff;
			System.out.println(tracks[i]+"\t"+diff);
			sum += diff;
			previous = tracks[i];
		}
		for(i = n-1; i >= pos + 1; i--)
		{
				diff = tracks[i] - previous;
			diff = diff > 0?diff: - diff;
			System.out.println(tracks[i]+"\t"+diff);
			sum += diff;
			previous = tracks[i];
		}
		
		avg = sum/n;
		System.out.println("Total number of tracks traversed: "+sum+
				"\nAverage: number of tracks traversed: "+avg);
		
	}
	 
}

/*
Output:
CSCAN UP:
	Enter number of tracks:
	9
	Enter tracks:
	129
	110
	186
	147
	41
	10
	64
	120
	27
	Enter starting track:
	100
	Enter option:
	1. C-SCAN UP
	2. C-SCAN DOWN
	1
	Track   No of tracks traversed
	110     10
	120     10
	129     9
	147     18
	186     39
	10      176
	27      17
	41      14
	64      23
	Total number of tracks traversed: 316.0
	Average: number of tracks traversed: 35.11111

CSCAN DOWN:
	Enter number of tracks:
	9
	Enter tracks:
	129
	110
	186
	147
	41
	10
	64
	120
	27
	Enter starting track:
	100
	Enter option:
	1. C-SCAN UP
	2. C-SCAN DOWN
	2
	Track   No of tracks traversed
	64      36
	41      23
	27      14
	10      17
	186     176
	147     39
	129     18
	120     9
	110     10
	Total number of tracks traversed: 342.0
	Average: number of tracks traversed: 38.0
*/