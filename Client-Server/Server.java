import java.util.*;
import java.net.*;
import java.io.*;
public class Server{
	public static void main(String[] args) throws IOException{
		Scanner sci=new Scanner(System.in);
		String input,output;
		ServerSocket ss=new ServerSocket(4444);
		Socket s=ss.accept();
		DataOutputStream dos=new DataOutputStream(s.getOutputStream());
		DataInputStream dis=new DataInputStream(s.getInputStream());
		do {
			input=dis.readUTF();
			System.out.println("Client sended :"+input);
			if (input.equalsIgnoreCase("BYE")) {
				break;
			}
			System.out.print("Enter anything : ");
			output=sci.nextLine();
			dos.writeUTF(output);
		}while(!output.equalsIgnoreCase("BYE"));
		s.close();
	}
}