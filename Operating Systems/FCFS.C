#include<stdio.h>
int main()
{
	int at[5],et[5],st[5],wt[5],n,i,sum=0;
	float avg;

	printf("\nEnter no. of processes: ");
	scanf("%d",&n);

	//Input for Access & Execution Time
	for(i=0;i<n;i++)
	{
		printf("\nEnter Arrival Time for P%d: ",i);
		scanf("%d",&at[i]);
		printf("Enter Execution Time for P%d: ",i);
		scanf("%d",&et[i]);
	}

	//Calculating Service & Waiting Time
	for(i=0;i<n;i++)
	{
		if(i==0)
			st[i]=at[i];
		else
			st[i]=st[i-1]+et[i-1];
		wt[i]=st[i]-at[i];
	}

	//Printing AT, ET, ST, WT in tabular form
	printf("\nProcess\t Arrival Time\t Execution Time\t Service Time\t Waiting Time");
	for(i=0;i<n;i++)
	{
		printf("\nP%d\t %d\t\t %d\t\t %d\t\t %d\t\t",i,at[i],et[i],st[i],wt[i]);
	}

	//Calculating Sum, Average & printing it
	for(i=0;i<n;i++)
	{
		sum=sum+wt[i];
	}
	printf("\n\nSum: %d ms",sum);
	avg=(float)sum/n;
	printf("\nAverage: %.2f ms\n",avg);

	return 0;
}

/*
Output:

Enter no. of processes: 4

Enter Arrival Time for P0: 0
Enter Execution Time for P0: 5

Enter Arrival Time for P1: 1
Enter Execution Time for P1: 3

Enter Arrival Time for P2: 2
Enter Execution Time for P2: 8

Enter Arrival Time for P3: 3
Enter Execution Time for P3: 6

Process  Arrival Time    Execution Time  Service Time    Waiting Time
P0       0               5               0               0
P1       1               3               5               4
P2       2               8               8               6
P3       3               6               16              13

Sum: 23 ms
Average: 5.75 ms
*/