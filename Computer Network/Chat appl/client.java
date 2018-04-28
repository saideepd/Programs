import java.net.*;
import java.io.*;

public class client
{
	public static void main(String args[]) throws Exception
	{
		Socket sk=new Socket("192.168.0.104",8888);
		BufferedReader sin=new BufferedReader(new InputStreamReader(sk.getInputStream()));
		PrintStream sout=new PrintStream(sk.getOutputStream());
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		String s;
		System.out.println("Enter bye to close connection");
		while(true)
		{
			System.out.print("Client : ");
			s=stdin.readLine();
			sout.println(s);
			s=sin.readLine();
			System.out.print("Server : "+s+"\n");
  			if(s.equalsIgnoreCase("Bye"))
 			   break;
		}
		 sk.close();
		 sin.close();
		 sout.close();
 		 stdin.close();
	}
}
/*
Output:
Enter bye to close connection
Client : hi
Server : hello
Client : bye
Server : Thank You
Client : bye
*/