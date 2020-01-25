import java.util.*;
import java.net.*;
import java.io.*;
public class stopwaitreceiver {
	public static void main(String[] args) {
		stopwaitreceiver swr=new stopwaitreceiver();
		swr.run();
	}
	public void run()
	{
		try
		{
			ServerSocket ss=new ServerSocket(6666);
			Socket s=ss.accept();
			PrintStream myps= new PrintStream(s.getOutputStream());
			String temp="anymessage",str="Exit";
			while(temp.compareTo(str)!=0)
			{
				Thread.sleep(1000);
				BufferedReader bf=new BufferedReader(new InputStreamReader(s.getInputStream()));
				temp=bf.readLine();
				if(temp.compareTo(str)==0)
				{
					System.out.println("Khatam");
					break;
				}
				else
				{
					System.out.println("Frame "+temp+" is received.");
					Thread.sleep(500);
					myps.println("Received");
				}
			}
			System.out.println("All Frames wer received.");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
