import java.util.*;

class bytstuff
{
	String res=new String();
	String out=new String();
	Scanner sc = new Scanner(System.in);
	public static void main(String args[])
	{
		bytstuff b = new bytstuff();
		b.sender();
		b.receiver();
	}
	
	void sender()
	{
		int i,count=0;
		System.out.println("Enter string:");
		String str=sc.nextLine();
		for(i=0;i<str.length();i++)
		{
			if(str.charAt(i)=='$')
			{
				count++;
				res+="@";
				res+=str.charAt(i);
			}
			else
			{
				res+=str.charAt(i);
				count=0;
			}
			if(count==1)
			{
				count=0;
			}
		}
		System.out.println("\nByte stuffed from sender: "+res);
	}
	
	void receiver()
	{
		int i,count=0;
		for(i=0;i<res.length();i++)
		{
			if(res.charAt(i)=='@')
			{
				count++;
				if((i+1)!=res.length())
					out+=res.charAt(i+1);
				else
					out+='$';
				i=i+2;
				out+=res.charAt(i);
			}
			else
			{
				out+=res.charAt(i);
				count=0;
			}
			if(count==1)
			{
				count=1;
			}
		}
		System.out.println("\nByte destuffed at receiver: "+out);
	}
}

/*

Output:

Enter string:
A$B$AB

Byte stuffed from sender: A@$B@$AB

Byte destuffed at receiver: A$B$AB

*/