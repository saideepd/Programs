import java.util.*;
class DiskSchedule
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("\nEnter the number of requests:  ");
		int n=sc.nextInt();
		int a[]=new int[n];
		int i,min,min_index=0,j,temp,direction;
		System.out.print("\nEnter the request numbers:  ");
		for(i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
		}
		System.out.print("\nEnter start head:  ");
		int head=sc.nextInt();
		int seek_sum=0;
		double seek_avg;
		System.out.print("\n1.SSTF\t2.SCAN\nEnter your choice: ");
		int choice=sc.nextInt();
		switch(choice)
		{
			case 1://SSTF
				int visited[]=new int[n];
				int dist[]=new int[n];
				for(i=0;i<n;i++)
					visited[i]=0;
				for(i=0;i<n;i++)
				{
					min=999;//assume max value=999
					for(j=0;j<n;j++)
					{
						dist[j]=Math.abs(a[j]-head);
						if((dist[j]<min)&&(visited[j]==0))
						{
							min=dist[j];
							min_index=j;
						}
					}
					head=a[min_index];
					visited[min_index]=1;
					seek_sum+=dist[min_index];
				}
				break;
			case 2://SCAN
				for(i=0;i<n-1;i++)
				{
					for(j=0;j<n-1;j++)
					{
						if(a[j]>a[j+1])
						{
							temp=a[j];
							a[j]=a[j+1];
							a[j+1]=temp;
						}
					}
				}
				System.out.print("\n1.Left\t2.Right\nEnter your direction choice :  ");
				direction=sc.nextInt();
				switch(direction)
				{
					case 1:	i=0;
						while(head>a[i])
						i++;
						j=i-1;
						while(i<n)
						{
							seek_sum+=a[i]-head;
							head=a[i];
							i++;
						}
						while(j>-1)
						{
							seek_sum+=head-a[j];
							head=a[j];
							j--;
						}
						break;
					case 2:	i=n-1;
						while(head<a[i])
							i--;
						j=i+1;
						while(i>-1)
						{
							seek_sum+=head-a[i];
							head=a[i];
							i--;
						}
						while(j<n)
						{
							seek_sum+=a[j]-head;
							head=a[j];
							j++;	
						}
						break;
					default:System.out.println("Invalid direction choice");
				}
				break;
			default:System.out.println("Invalid choice");
		}
		seek_avg=seek_sum*1.0/n;
		System.out.printf("\nAverage seek time = %.2f",seek_avg);
	}
}

/* Output:


//SSTF
Enter the number of requests:  9

Enter the request numbers:  27 129 110 186 147 41 10 64 120

Enter start head:  100

1.SSTF  2.SCAN
Enter your choice: 1

Average seek time = 29.11


//SCAN

	//Left

	Enter the number of requests:  9

	Enter the request numbers:  27 129 110 186 147 41 10 64 120

	Enter start head:  100

	1.SSTF  2.SCAN
	Enter your choice: 2

	1.Left  2.Right
	Enter your direction choice :  1

	Average seek time = 29.11


	//Right

	Enter the number of requests:  9

	Enter the request numbers:  27 129 110 186 147 41 10 64 120

	Enter start head:  100

	1.SSTF  2.SCAN
	Enter your choice: 2

	1.Left  2.Right
	Enter your direction choice :  2

	Average seek time = 29.56

*/