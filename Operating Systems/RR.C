#include<stdio.h>
int main()
{
	int at[5],et[5],st[5],wt=0,temp[10],n,i,f=0,q,total=0,x;
	float avg;
	printf("\nEnter no. of processes: ");
	scanf("%d",&n);
	printf("\nEnter quantum time: ");
	scanf("%d",&q);
	x=n;
	//Input for Access & Execution Time
	for(i=0;i<n;i++)
	{
		printf("\nEnter Arrival Time for P%d: ",i);
		scanf("%d",&at[i]);
		printf("Enter Execution Time for P%d: ",i);
		scanf("%d",&et[i]);
		temp[i]=et[i];
	}

	//Printing AT, ET, ST, WT in tabular form
	printf("\nProcess\t Arrival Time\t Execution Time\t Service Time\t Waiting Time");
	for(total=0,i=0;x!=0;)
	{
		if(temp[i] <= q && temp[i]>0)
		{
			total=total+temp[i];
			temp[i]=0;
			f=1;
		}
		else if(temp[i]>0)
		{
			temp[i]=temp[i]-q;
			total=total+q;
		}
		if(temp[i]==0 && f==1)
		{
			x--;
			printf("\nP%d\t %d\t\t %d\t\t %d\t\t %d\t\t",i,at[i],et[i],total-at[i],total-at[i]-et[i]);
			wt=wt+total-at[i]-et[i];
			f=0;
		}
		if(i==n-1)
			i=0;
		else if(at[i+1]<=total)
			i++;
		else
			i=0;
	}
	avg=wt*1.0/n;
	printf("\n\nAverage Waiting Time:\t%.2f ms\n",avg);
	return 0;
}

/*
Output:

Enter no. of processes: 4

Enter quantum time: 3

Enter Arrival Time for P0: 0
Enter Execution Time for P0: 5

Enter Arrival Time for P1: 1
Enter Execution Time for P1: 3

Enter Arrival Time for P2: 2
Enter Execution Time for P2: 8

Enter Arrival Time for P3: 3
Enter Execution Time for P3: 6

Process  Arrival Time    Execution Time  Service Time    Waiting Time
P1       1               3               5               2
P0       0               5               14              9
P3       3               6               17              11
P2       2               8               20              12

Average Waiting Time:   8.50 ms
*/