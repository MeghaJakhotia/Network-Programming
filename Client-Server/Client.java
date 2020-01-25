import java.util.*;
import java.net.*;
import java.io.*;
public class Client{
	public static void main(String[] args) throws IOException{
		Scanner sci=new Scanner(System.in);
		String input,output;
		Socket s=new Socket("localhost",4444);
		int i=0;
		DataOutputStream dos=new DataOutputStream(s.getOutputStream());
		DataInputStream dis=new DataInputStream(s.getInputStream());
		do {
			System.out.print("Enter anything : ");
			output=sci.nextLine();
			dos.writeUTF(output);
			if (output.equalsIgnoreCase("BYE")) {
				break;
			}
			input=dis.readUTF();
			System.out.println("Server sended :"+input);
		}while(!input.equalsIgnoreCase("BYE"));
		s.close();
	}
}