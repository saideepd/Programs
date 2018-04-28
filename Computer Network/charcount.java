import java.util.*;
class charcount
{
	int str[] = new int[20];
	public static void main(String args[])
	{
		charcount c = new charcount();
		c.sender();
		c.receiver();
	}
	
	void sender()
	{
		Scanner sc = new Scanner(System.in);
		int frame,len,i,j=0,count=0,x;
		System.out.print("Enter the no of frames: ");
		frame=sc.nextInt();
		for(i=0;i<frame;i++)
		{
			System.out.print("Enter the length of frame: ");
			len=sc.nextInt();
			str[j]=len+1;
			j++;
			count=j;
			System.out.println("Enter the string data: ");
			for(;j<(count+len);j++)
			{
				str[j]=sc.nextInt();			
			}
			for(x=0;x<str.length;x++)
			{
				System.out.print(""+str[x]);
			}
			System.out.println();
		}
	}
	
	void receiver()
	{
		int remove=str[0];
		int loop=remove-1;
		int i=1;
		int count=i;
		System.out.println("\nAt receiver:\n");
		for(int j=0;j<3;j++)
		{
			for(;i<(count+loop);i++)
			{
				System.out.print(""+str[i]);
			}
			remove=str[i];
			i++;
			count=i;
			loop=remove-1;
		}
	}
}

/*
Ouptut:

Enter the no of frames: 3
Enter the length of frame: 3
Enter the string data:
1
2
3
41230000000000000000
Enter the length of frame: 2
Enter the string data:
5
6
41233560000000000000
Enter the length of frame: 1
Enter the string data:
7
41233562700000000000

At receiver:

123567
*/