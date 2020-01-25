import java.util.*;
import java.net.*;
import java.io.*;
public class Client{
	public static void main(String[] args) throws IOException{
		Scanner sci=new Scanner(System.in);
		String input,output="";
		Socket s=new Socket("localhost",8844);
		s.setSoTimeout(10000);
		int i=0,retry=0;
		boolean flag=true;
		DataOutputStream dos=new DataOutputStream(s.getOutputStream());
		DataInputStream dis=new DataInputStream(s.getInputStream());
		System.out.println("For client acknowledgment max waiting time = 10s");
		do {
			try{
				System.out.print("Enter anything : ");
				output=sci.nextLine();
				dos.writeUTF(output);
				if (output.equalsIgnoreCase("BYE")) {
					System.out.println("Connection ended by client");
					flag=false;
					break;
				}
				input=dis.readUTF();
				System.out.println("Server received acknowledgment : "+input);
				if (input.equalsIgnoreCase("BYE")) {
					System.out.println("Connection ended by Server");
					dos.writeUTF("BYE");
					flag=false;
				}
			}
			catch(Exception e){
				//System.out.println(e.toString());
				while(retry++<5) {
					System.out.println("Timeout ack hence resending frame "+output);
					dos.writeUTF(output);
					DataInputStream dis1=new DataInputStream(s.getInputStream());
					input=dis1.readUTF();
					System.out.println("Server received acknowledgment : "+input);
				}
				if (retry<5) {
					continue;
				}
				System.out.println("resending stopped");
				flag=false;
				dos.writeUTF("BYE");
			}
		}while(flag);
		s.close();
	}
}