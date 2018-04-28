#include<stdio.h>
int main()
{
	int fragment[20],block[20],job[20],i,j,bno,jno,temp,top=0;
	static int barray[20],parray[20];
	
	printf("\nEnter no of blocks: ");
	scanf("%d",&bno);

	printf("\nEnter size of blocks: \n");
	for (i=1; i<=bno; i++)
	{
		printf("Block no.%d: ",i);
		scanf("%d",&block[i]);
	}


	printf("\nEnter no of jobs: ");
	scanf("%d",&jno);

	printf("\nEnter size of jobs: \n");
	for(i=1; i<=jno; i++)
	{
		printf("Job no.%d: ",i);
		scanf("%d",&job[i]);
	}

	for(i=1; i<=jno; i++)
	{
		for(j=1; j<=bno; j++)
		{
			if(barray[j]!=1)
			{
				temp=block[j]-job[i];
				if(temp>=0)
				{
					if(top<temp)
					{
						parray[i]=j;
						top=temp;
					}
				}
			}
			fragment[i]=top;
			barray[parray[i]]=1;
			top=0;
		}
	}

	printf("\nJob no\t\tJob size\tBlock_no\tBlock_size\tFragment");
	for(i=1;i<=jno;i++)
		printf("\n%d\t\t%d\t\t%d\t\t%d\t\t%d",i,job[i],parray[i],block[parray[i]],fragment[i]);
	printf("\n");
	return 0;
}

/*
Output:

.

Enter no of blocks: 5

Enter size of blocks:
Block no.1: 5
Block no.2: 4
Block no.3: 3
Block no.4: 6
Block no.5: 7

Enter no of jobs: 4

Enter size of jobs:
Job no.1: 1
Job no.2: 3
Job no.3: 5
Job no.4: 3

Job no          Job size        Block_no        Block_size      Fragment
1               1               5               7               6
2               3               0               0               0
3               5               0               0               0
4               3               0               0               0

*/