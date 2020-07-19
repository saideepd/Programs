import java.net.*;  
import java.io.*;  
class MyServer{  
    public static void main(String args[])throws Exception{  
        ServerSocket ss=new ServerSocket(3333);  
        Socket s=ss.accept();  
        DataInputStream din=new DataInputStream(s.getInputStream());  
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  

        String str="",str2="";  
        while(!str.equals("stop")){  
            str=din.readUTF(); 
            String reverse = new StringBuffer(str).reverse().toString();
            System.out.println("Client: "+str+"\nReverse: "+reverse);  
            //str2=br.readLine();  
            dout.writeUTF(reverse);  
            dout.flush();  
        }  
        din.close();  
        s.close();  
        ss.close();  
    }
} 
/*
Output:
Client: 12
Reverse: 21
Client: 02
Reverse: 20
Client: 15697
Reverse: 79651
*/