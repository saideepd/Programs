import java.util.*;
class IP
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your IP Adress:");
		String ipadd=sc.nextLine();
		int i=0;
		char div='D';
		do
		{
			
		}while(ipadd.charAt(i++)!='.');
		int class_add=Integer.parseInt(ipadd.substring(0,i-1));
		if(class_add>=0 && class_add<128)
			div='a';
		else if(class_add>127 && class_add<192)
			div='b';
		else if(class_add>191 && class_add<224)
			div='c';
		switch(div)
		{
			case 'a': System.out.println("Class: A\nSubnet Mask: 255.0.0.0\nStart IP address: 0.0.0.0\nEnd IP address: 127.255.255.255");
				break;
			case 'b': System.out.println("Class: B\nSubnet Mask: 255.255.0.0\nStart IP address: 128.0.0.0\nEnd IP address: 191.255.255.255");
				break;
			case 'c': System.out.println("Class: C\nSubnet Mask: 255.255.255.0\nStart IP address: 192.0.0.0\nEnd IP address: 223.255.255.255");
				break;
			default: System.out.println("Out of Range");
				break;
		}
	}
}

/*
OUTPUT:
Enter your IP Adress:
192.168.0.100
Class: C
Subnet Mask: 255.255.255.0
Start IP address: 192.0.0.0
End IP address: 223.255.255.255
*/

