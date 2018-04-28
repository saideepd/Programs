#include<stdio.h>

int main()
{
    int i,j,r,p,k,deadlock,finishall,count=0;
    int alloc[10][10],need[10][10],max[10][10],finish[10]={0},avail[10];

    printf("Enter total processes\n");
    scanf("%d",&p);
    printf("Enter total resources\n");
    scanf("%d",&r);
    printf("Enter alloc matrix\n");
    for(i=0;i<p;i++)
    {
        for(j=0;j<r;j++)
        {
            scanf("%d",&alloc[i][j]);
        }
    }
    printf("Enter max matrix\n");
    for(i=0;i<p;i++)
    {
        for(j=0;j<r;j++)
        {
            scanf("%d",&max[i][j]);
        }
    }
    printf("Enter avail array\n");
    for(i=0;i<r;i++)
        scanf("%d",&avail[i]);
    for(i=0;i<p;i++)
    {
        for(j=0;j<r;j++)
        {
            need[i][j]=max[i][j]-alloc[i][j];
        }
    }
    do{
        for(i=0;i<p;i++)
        {
            count=0;
            if(finish[i]==0)
            {
                for(j=0;j<r;j++)
                {
                    if(need[i][j]>avail[j])
                        break;
                }
                if(j==r)
                {
                    for(k=0;k<r;k++)
                    {
                        avail[k] = avail[k] + alloc[i][k];
                        finish[i]=1;
                    }
                    printf("Process P%d --> ",i+1);

                }
                else
                {
                    count++;
                }
            }
            else
            {
                count++;
            }
            for(j=0;j<p;j++)
            {
                if(finish[j]==0)
                    break;
            }
            if(j==p)
                finishall=1;
            if(count==p)
                deadlock=1;
        }
    }while(finishall!=1 && deadlock!=1);
    if(deadlock==1) printf("System in Deadlock state\n");
    else printf("System in Safe mode");
    printf("\nDisplay time\n");
    printf("Allocation matrix\n");
    for(i=0;i<p;i++)
    {
        for(j=0;j<r;j++)
        {
            printf("%d ",alloc[i][j]);
        }
        printf("\n");
    }
    printf("Max matrix\n");
    for(i=0;i<p;i++)
    {
        for(j=0;j<r;j++)
        {
            printf("%d ",max[i][j]);
        }
        printf("\n");
    }
    printf("Need matrix\n");
    for(i=0;i<p;i++)
    {
        for(j=0;j<r;j++)
        {
            printf("%d ",need[i][j]);
        }
        printf("\n");
    }
    printf("Available matrix\n");
    for(i=0;i<r;i++)
        printf("%d ",avail[i]);
    printf("\n");
    return 0;;
}

/*
Output:
Enter total processes
3
Enter total resources
4
Enter alloc matrix
1 2 2 1
1 0 3 3
1 2 1 0
Enter max matrix
3 3 2 2
1 1 3 4
1 3 5 0
Enter avail array
3 1 1 2
Process P1 --> Process P2 --> Process P3 --> System in Safe mode
Display time
Allocation matrix
1 2 2 1
1 0 3 3
1 2 1 0
Max matrix
3 3 2 2
1 1 3 4
1 3 5 0
Need matrix
2 1 0 1
0 1 0 1
0 1 4 0
Available matrix
6 5 7 6
*/