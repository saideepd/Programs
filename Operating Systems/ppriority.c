#include<stdio.h>

int main() {
  int i,j,n,time,sum_wait=0,sum_turnaround=0,smallest;
  int at[10],bt[10],pt[10],rt[10],remain;

  printf("Enter no of processes : ");
  scanf("%d",&n);
  remain=n;
  printf("Enter arrival time, burst time and priority for %d processes:\n",n);
  for(i=0;i<n;i++) {
    printf("\nProcess[%d] :",i+1);
    printf("\nArrival Time:\t");
    scanf("%d",&at[i]);
    printf("Burst Time:\t");
    scanf("%d",&bt[i]);
    printf("Priority:\t");
    scanf("%d",&pt[i]);
    rt[i]=bt[i];
  }
  pt[9]=11;
  printf("\n\nProcess\tAT\tBT\tPriority\tTAT\tWT\n");
  for(time=0;remain!=0;time++) {
    smallest=9;
    for(i=0;i<n;i++)
    {
      if(at[i]<=time && pt[i]<pt[smallest] && rt[i]>0)
      {
        smallest=i;
      }
    }
    rt[smallest]--;
    if(rt[smallest]==0) {
      remain--;
      printf("P[%d]\t%d\t%d\t%d\t\t%d\t%d\n",smallest+1,at[smallest],bt[smallest],pt[smallest],time+1-at[smallest],time+1-at[smallest]-bt[smallest]);
      sum_turnaround+=time+1-at[smallest];
      sum_wait+=time+1-at[smallest]-bt[smallest];
    }
  }
  printf("\nAvg turnaround time = %.2f\n",sum_turnaround*1.0/n);
  printf("Avg waiting time = %.2f\n",sum_wait*1.0/n);
  return 0;
}

/*
Output:

Enter no of processes : 3
Enter arrival time, burst time and priority for 3 processes:

Process[1] :
Arrival Time:   0
Burst Time:     15
Priority:       3

Process[2] :
Arrival Time:   1
Burst Time:     10
Priority:       2

Process[3] :
Arrival Time:   2
Burst Time:     90
Priority:       1


Process AT      BT      Priority        TAT     WT
P[3]    2       90      1               90      0
P[2]    1       10      2               100     90
P[1]    0       15      3               115     100

Avg turnaround time = 101.67
Avg waiting time = 63.33

*/