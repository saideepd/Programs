#include<stdio.h>
int main()
{
	int a[20],n,s,i,t=0;
	printf("Enter head pointer position: ");
	scanf("%d",&a[0]);
	printf("\nEnter number of cylinders: ");
	scanf("%d",&n);
	printf("\nEnter cylinders in request order:\n");
	for(i=1;i<=n;i++)
	{
		scanf("%d",&a[i]);
	}
	for(i=0;i<n;i++)
	{
		if(a[i]<a[i+1])
			t+=(a[i+1]-a[i]);
		else
			t+=(a[i]-a[i+1]);
	}
	printf("\nEnter time to cross one cylinder: ");
	scanf("%d",&s);
	printf("\nProcessing order:");
	for(i=0;i<=n;i++)
		printf("\t%d",a[i]);
	printf("\nTotal Head Movement (given as %d * %d) : %d ms\n",t,s,t*s);
	printf("Average Seek time: %.2f ms\n", t*s*1.0/n);
	return 0;
}

/*
Output:
Enter head pointer position: 53

Enter number of cylinders: 8

Enter cylinders in request order:
98
183
37
122
14
124
65
67

Enter time to cross one cylinder: 1

Processing order:       53      98      183     37      122     14      124     65      67
Total Head Movement (given as 640 * 1) : 640 ms
Average Seek time: 80.00 ms
*/