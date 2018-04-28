import java.net.*;
import java.io.*;
 
public class server
{
	public static void main(String args[]) throws Exception
	{
		ServerSocket ss = new ServerSocket(8888);
		Socket sk=ss.accept();
		BufferedReader cin = new BufferedReader(new InputStreamReader(sk.getInputStream()));
		PrintStream cout = new PrintStream(sk.getOutputStream());
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String s;
		System.out.println("Server Started");
		while(true)
		{
			s = cin.readLine();
  			if(s.equalsIgnoreCase("Bye"))
  			{
				cout.println("Thank You");
    				break;
  			}
			System. out.print("Client : "+s+"\n");
			System.out.print("Server : ");
			s=stdin.readLine();
			cout.println(s);
		}
		ss.close();
 		sk.close();
 		cin.close();
		cout.close();
 		stdin.close();
	}
}
/*
Output:
Server Started
Client : hi
Server : hello
*/
