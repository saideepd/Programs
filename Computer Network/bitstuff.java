import java.util.*;

class bitstuff
{
	String res=new String();
	String out=new String();
	Scanner sc = new Scanner(System.in);
	public static void main(String args[])
	{
		bitstuff b = new bitstuff();
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
			if(str.charAt(i)=='1')
			{
				count++;
				res+=str.charAt(i);
			}
			else
			{
				res+=str.charAt(i);
				count=0;
			}
			if(count==5)
			{
				res+='0';
				count=0;
			}
		}
		System.out.println("\nBit stuffed from sender: "+res);
	}
	
	void receiver()
	{
		int i,count=0;
		for(i=0;i<res.length();i++)
		{
			if(res.charAt(i)=='1')
			{
				count++;
				out+=res.charAt(i);
			}
			else
			{
				out+=res.charAt(i);
				count=0;
			}
			if(count==5)
			{
				if((i+2)!=res.length())
					out+=res.charAt(i+2);
				else
					out+='1';
				i=i+2;
				count=1;
			}
		}
		System.out.println("\nBit destuffed at receiver: "+out);
	}
}

/*
Output:

Enter string:
01101111111111111110010

Bit stuffed from sender: 01101111101111101111100010

Bit destuffed at receiver: 01101111111111111110010

*/