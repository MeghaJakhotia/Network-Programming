import java.io.*;
import java.util.*;

public class IPSubnet
{
	public static void main(String args[])
	{
		String ip;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter an IP address:");
		ip=sc.nextLine();
		int i=0;
		do
		{
			i++;
		}while(ip.charAt(i)!='.');
		int class_add=Integer.parseInt(ip.substring(0,i));
		if(class_add>0 && class_add<127)
		{
			System.out.println("Class A\n");
			
		}
		else if(class_add>=128 && class_add<=191)
		{
			System.out.println("Class B\n");
			
		}
		else if(class_add>=192 && class_add<=223)
		{
			System.out.println("Class C\n");
			
		}
		else if(class_add>=224 && class_add<=255)
		{
			System.out.println("Class D\n");
			
		}
		else
		{
			System.out.println("Class=INVALID\n");
			
		}
	}
}