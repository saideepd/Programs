#include<stdio.h>

int main() {
	int block[10],job[10],flag[10],allocation[10],bno,jno,i,j;
	for(i=0;i<10;i++) {
		flag[i]=0;
		allocation[i]=-1;
	}

	printf("Enter no of Blocks: ");
	scanf("%d",&bno);
	printf("Enter size of each Block:\n");
	for(i=0;i<bno;i++) {
		scanf("%d",&block[i]);
	}

	printf("Enter no of Jobs: ");
	scanf("%d",&jno);
	printf("Enter size of each Job:\n");
	for(i=0;i<jno;i++) {
		scanf("%d",&job[i]);
	}

	for(i=0;i<jno;i++) {
		for(j=0;j<bno;j++) {
			if(flag[j]==0 && block[j]>=job[i]) {
				allocation[j]=i;
				flag[j]=1;
				break;
			}
		}
	}

	printf("\nBlock No\tBlock Size\tJob no\t\tJob Size");
	for(i=0;i<bno;i++) {
		printf("\nBlock %d\t\t%d\t\t",i+1,block[i]);
		if(flag[i]==1)
			printf("Job %d\t\t%d",allocation[i]+1,job[allocation[i]]);
		else
			printf("Not allocated");
	}
	printf("\n");
	return 0;
}

/*
Output:

DICHOLKAR@DICHOLKAR:/mnt/d/DJ DOCUMENTS/5th Sem/OS$ gcc firstf.c -o firstf
DICHOLKAR@DICHOLKAR:/mnt/d/DJ DOCUMENTS/5th Sem/OS$ ./firstf
Enter no of Blocks: 5
Enter size of each Block:
50
200
70
115
15
Enter no of Jobs: 10
Enter size of each Job:
100
10
35
15
23
6
25
55
88
100

Block No        Block Size      Job no          Job Size
Block 1         50              Job 2           10
Block 2         200             Job 1           100
Block 3         70              Job 3           35
Block 4         115             Job 4           15
Block 5         15              Job 6           6
*/