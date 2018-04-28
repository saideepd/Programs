#include<stdio.h>
int main() {
	int burst_time[20], process[20], wait_time[20], turnaround[20], priority[20];
	int i, j, n, sum=0, pos, temp;
	float avg_wt, avg_tt;
	printf("Enter No. of Processes:\t");
	scanf("%d",&n);
	printf("\nEnter Burst Time and Priority of %d Processes\n",n);
	for( i=0; i<n; i++ ) {
		printf("\nProcess %d\n",i+1);
		printf("Burst Time:\t");
		scanf("%d",&burst_time[i]);
		printf("Priority:\t");
		scanf("%d",&priority[i]);
		process[i] = i+1;
	}
	for( i=0; i<n; i++ ) {
		pos = i;
		for( j=i+1; j<n; j++ ) {
			if(priority[j] < priority[pos]) {
				pos = j;
			}
		}
		temp = priority[i];
		priority[i] = priority[pos];
		priority[pos] = temp;
		temp = burst_time[i];
		burst_time[i] = burst_time[pos];
		burst_time[pos] = temp;
		temp = process[i];
		process[i] = process[pos];
		process[pos] = temp;
	}
	wait_time[0] = 0;
	for( i=1; i<n; i++ ) {
	wait_time[i] = 0;
		for( j=0; j<i; j++ ) {
			wait_time[i] = wait_time[i] + burst_time[j];
		}
		sum = sum + wait_time[i];
	}
	avg_wt = (float)sum / n;
	sum = 0;
	printf("\nProcess ID\tPriority\tBurst Time\tWaiting Time\tTurnaround Time\n");
	for( i=0; i<n; i++ ) {
		turnaround[i] = burst_time[i] + wait_time[i];
		sum = sum + turnaround[i];
		printf("P%d\t\t%d\t\t%d\t\t%d\t\t%d\n", process[i], priority[i], burst_time[i],wait_time[i], turnaround[i]);
	}
	avg_tt = (float)sum / n;
	printf("\nAverage Waiting Time:\t\t%.2f", avg_wt);
	printf("\nAverage Turnaround Time:\t%.2f", avg_tt);
	printf("\n");
	return 0;
}

/*
Output:
Enter No. of Processes: 3

Enter Burst Time and Priority of 3 Processes

Process 1
Burst Time:     15
Priority:       3

Process 2
Burst Time:     10
Priority:       2

Process 3
Burst Time:     90
Priority:       1

Process ID      Priority        Burst Time      Waiting Time    Turnaround Time
P3              1               90              0               90
P2              2               10              90              100
P1              3               15              100             115

Average Waiting Time:           63.33
Average Turnaround Time:        101.67
*/