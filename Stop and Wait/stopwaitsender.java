import java.util.*;
import java.net.*;
import java.io.*;
public class stopwaitsender {

	public static void main(String[] args) {
		stopwaitsender sws=new stopwaitsender();
		sws.run();
	}
	public void run()
	{
		try
		{
			Socket s=new Socket("localhost",6666);
			Scanner sc = new Scanner(System.in);
			PrintStream myps= new PrintStream(s.getOutputStream());
			System.out.println("Enter the number of frames:");
			int n=sc.nextInt();
			for(int i=0;i<=n;)
			{
				if(i==n)
				{
					myps.println("Exit");
					break;
				}
				else
				{
					System.out.println("Frame no "+i+" is sent.");
					myps.println(i);
					BufferedReader bf=new BufferedReader(new InputStreamReader(s.getInputStream()));
					String ack=bf.readLine();
					if(ack!=null)
					{
						System.out.println("Acknowledged");
						i++;
						Thread.sleep(4000);
					}
					else
						myps.println(i);
				}
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
}
