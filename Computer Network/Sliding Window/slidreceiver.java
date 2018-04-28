//Sliding Window Protocol - Selective Repeat
//RECEIVER PROGRAM
import java.net.*;
import java.io.*;
class slidreceiver {
	public static void main(String args[]) throws Exception {
		Socket s = new Socket(InetAddress.getLocalHost(), 10);
		DataInputStream in = new DataInputStream(s.getInputStream());
		PrintStream p = new PrintStream(s.getOutputStream());
		int i = 0, rptr = -1, nf, rws = 8;
		String rbuf[] = new String[8];
		String ch;
		System.out.println();
		do {
			nf = Integer.parseInt(in.readLine());
			if (nf <= rws - 1) {
				for (i = 1; i <= nf; i++) {
					rptr = ++rptr % 8;
					rbuf[rptr] = in.readLine();
					System.out.println("The received Frame " + rptr + " is : " + rbuf[rptr]);
				}
				rws -= nf;
				System.out.println("\nAcknowledgment sent\n");
				p.println(rptr + 1);
				rws += nf;
			} else break;
			ch = in.readLine();
		}
		while (ch.equals("yes"));
	}
}

/*OUTPUT:
//SENDER OUTPUT
Enter the no. of frames : 4
Enter 4 Messages to be send

hiii
how r u
i am fine
how is evryone
Acknowledgment received for 4 frames

Do you want to send some more frames : no

//RECEIVER OUTPUT
The received Frame 0 is : hiii
The received Frame 1 is : how r u
The received Frame 2 is : i am fine
The received Frame 3 is : how is evryone

Acknowledgment sent
*/