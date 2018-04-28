import java.util.*;
class SJF
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n,BT[],WT[],TAT[];
		System.out.println("Enter no of process: ");
		n=sc.nextInt();
		BT=new int[n+1];
		WT=new int[n+1];
		TAT=new int[n+1];
		float AWT=0;
		System.out.println("Enter Burst time for each process: ");
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter BT for process "+(i+1));
			BT[i]=sc.nextInt();
		}
		for(int i=0;i<n;i++)
		{
			WT[i]=0;
			TAT[i]=0;
		}
		int temp;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n-1;j++)
			{
				if(BT[j]>BT[j+1])
				{
					temp=BT[j];
					BT[j]=BT[j+1];
					BT[j+1]=temp;
				}
			}
		}
		for(int i=0;i<n;i++)
		{
			TAT[i]=BT[i]+WT[i];
			WT[i+1]=TAT[i];
		}
		System.out.println("\nPROCESS\tBT\tWT\tTAT ");
		for(int i=0;i<n;i++)
			System.out.println(i+"\t"+BT[i]+"\t"+WT[i]+"\t"+TAT[i]);
		for(int j=0;j<n;j++)
			AWT+=WT[j];
		AWT=AWT/n;
		System.out.println();
		System.out.println("Avg waiting time = "+AWT+" ms");
	}
}

/*
Output:
Enter no of process:
4
Enter Burst time for each process:
Enter BT for process 1
1
Enter BT for process 2
5
Enter BT for process 3
2
Enter BT for process 4
4

PROCESS BT      WT      TAT
0       1       0       1
1       2       1       3
2       4       3       7
3       5       7       12

Avg waiting time = 2.75 ms
*/