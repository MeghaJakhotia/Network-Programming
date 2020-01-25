import java.util.*;

public class IP{
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String input;
		System.out.println();
		System.out.print("Enter ip address : ");
		input=sc.next();
		String[] ipS=input.split(",");
		int[] ip=new int[4];
		for (int i=0;i<4 ;++i ) {
			ip[i]=Integer.parseInt(ipS[i]);
		}
		// System.out.println("Ip address : "+Arrays.toString(ip));
		if (ip[0]==0) {
			boolean flag=true;
			for (int x :ip ) {
				if (x!=0) {
					flag=false;
					break;
				}
			}
			if (flag) {
				System.out.println("This ip Belongs to host on this network");
			}
			else{
				System.out.println("This ip Belongs to remote host");
			}
		}
		else if (ip[0]>=1&&ip[0]<=127) {
			System.out.println("Belongs to Class A (ranges from 1.0.0.0 to 127.255.255.255)");
			System.out.println("Subnet mask : 255.0.0.0");
			if (ip[0]==127) {
				System.out.println("Loopback");
			}
		}
		else if (ip[0]>=128&&ip[0]<=191) {
			System.out.println("Belongs to Class B (ranges from 128.0.0.0 to 191.255.255.255)");
			System.out.println("Subnet mask : 255.255.0.0");
		}
		else if (ip[0]>=192&&ip[0]<=223) {
			System.out.println("Belongs to Class C (ranges from 192.0.0.0 to 223.255.255.255)");
			System.out.println("Subnet mask : 255.255.255.0");
		}
		else if (ip[0]>=224&&ip[0]<=239) {
			System.out.println("Belongs to Class D (ranges from 224.0.0.0 to 239.255.255.255)");
		}
		else if (ip[0]>=240&&ip[0]<=255) {
			System.out.println("Belongs to Class E (ranges from 240.0.0.0 to 255.255.255.255)");
			boolean flag=true;
			for (int x :ip ) {
				if (x!=255) {
					flag=false;
					break;
				}
			}
			if(flag){
				System.out.println("Broadcast");
			}
		}
		if (ip[0]!=255&&ip[1]==255&&ip[2]==255&&ip[3]==255) {
			System.out.println("Broadcast on remote network");
		}
	}
}