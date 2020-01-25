import java.util.*;
import java.net.*;
import java.io.*;
public class Server{
	public static void main(String[] args) throws IOException{
		Scanner sci=new Scanner(System.in);
		String input;
		boolean flag=true;
		ServerSocket ss=new ServerSocket(8844);
		Socket s=ss.accept();
		int ack=0;
		do {
			DataOutputStream dos=new DataOutputStream(s.getOutputStream());
			DataInputStream dis=new DataInputStream(s.getInputStream());
			input=dis.readUTF();	
			System.out.println("Client sended :"+input);
			if (input.equalsIgnoreCase("BYE")) {
				System.out.println("connection ended by Client");
				flag=false;
				break;
			}
			if (ack!=3) {
				System.out.println("Acknowledgment sended : "+ack);
				dos.writeUTF(""+ack);	
			}
			else {
				++ack;
				continue;
			}
			++ack;
			if (ack>7) {
				System.out.print("Connection terminated by server : BYE");
				dos.writeUTF("BYE");
				flag=false;
				break;
			}
		}while(flag);
		s.close();
	}
}