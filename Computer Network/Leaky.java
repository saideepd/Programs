import java.io.*;
import java.util.*;

class Queue
{
	int q[],r=0,size;
	void insert(int n)
	{
		Scanner sc = new Scanner(System.in);
		q = new int[10];
		for(int i=0;i<n;i++)
		{
			System.out.print("Enter " + i + " element: ");
			  int ele = sc.nextInt();
			if(r+1>10)
			{
				System.out.println("\nQueue is full \nLost Packet: "+ele);
				break;
			}
			else
			{
				r++;
				q[i]=ele;
			}
		}
	}

	void delete()
	{
		Scanner sc = new Scanner(System.in);
		Thread t = new Thread();
		if(r==0)
			System.out.print("\nQueue empty");
		else
		{
			for(int i=0;i<r;i++)
			{
				try
				{
					t.sleep(1000);
				}
				catch(Exception e)
				{}
				System.out.print("\nLeaked Packet: "+q[i]);
			}
		}
		System.out.println();
	}
}

class Leaky extends Thread
{
	public static void main(String args[])throws Exception
	{
		Queue q = new Queue();
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter the packets to be sent: ");
		int size=sc.nextInt();
		q.insert(size);
		q.delete();
	}
}

/*
Output:

Enter the packets to be sent: 11
Enter 0 element: 1
Enter 1 element: 2
Enter 2 element: 3
Enter 3 element: 4
Enter 4 element: 5
Enter 5 element: 6
Enter 6 element: 7
Enter 7 element: 8
Enter 8 element: 9
Enter 9 element: 10
Enter 10 element: 11

Queue is full
Lost Packet: 11

Leaked Packet: 1
Leaked Packet: 2
Leaked Packet: 3
Leaked Packet: 4
Leaked Packet: 5
Leaked Packet: 6
Leaked Packet: 7
Leaked Packet: 8
Leaked Packet: 9
Leaked Packet: 10
*/