import java.net.*;  
import java.io.*;  
class MyClient{  
    public static void main(String args[])throws Exception{  
        Socket s=new Socket("localhost",3333);  
        DataInputStream din=new DataInputStream(s.getInputStream());  
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  

        String str="",str2="";  
        System.out.println("Enter the number to reverse:\n");
        while(!str.equals("stop")){  
            System.out.print("Client: ");
            str=br.readLine();  
            dout.writeUTF(str);  
            dout.flush();  
            str2=din.readUTF();  
            System.out.println("Reverse number: "+str2);  
        }  

        dout.close();  
	s.close();
    }
} 
/*
Output:
Enter the number to reverse:

Client: 12
Reverse number: 21
Client: 02
Reverse number: 20
Client: 15697
Reverse number: 79651
*/