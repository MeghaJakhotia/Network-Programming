import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class DVR {
	final static int INF=999;
	static Scanner sc;

	static void srcLinkInput(int[][] a,int src){
		for (int i=0;i<a.length ;++i ) {
			if (a[src][i]!=INF) {
				System.out.print("Enter value of "+((char)src+65)+((char)i+65));
				a[src][i]=sc.nextInt();
				a[i][src]=a[src][i];
			}
		}
	}

	static void srcNeighbourLink(int[][] a,int src){
		for (int i=0;i<a.length ;++i ) {
			if (a[src][i]!=INF) {
				for (int j=0;j<a.length ;++j ) {
					System.out.print(a[i][j]+"\t");
				}
				System.out.println();
			}
		}
	}

	static void graph(int[][] a){
		int src,dest;
		int flag=0;
		String input="";
		for (int i=0;i<a.length ;++i ) {
			for (int j=0;j<a.length ;++j) {
				a[i][j]=INF;
			}
		}
		do{
			flag=0;
			System.out.print("Enter link name : ");
			input=sc.next();
			src=Character.digit(Character.toUpperCase(input.charAt(0))-65,10);
			dest=Character.digit(Character.toUpperCase(input.charAt(1))-65,10);
			a[src][dest]=ThreadLocalRandom.current().nextInt(1, 26);
			a[dest][src]=a[src][dest];
			System.out.print("press 1 to continue else 0 to stop : ");
			flag=sc.nextInt();
		}while(flag==1);
		for (int i=0;i<a.length ;++i ) {
			for (int j=0;j<a.length ;++j) {
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int n,src,dest;
		sc=new Scanner(System.in);
		System.out.println("");
		System.out.print("Enter the no. of nodes : ");
		n=sc.nextInt();
		int[][] nw=new int[n][n]; 
		System.out.println("Enter the links present in network : ");
		graph(nw);
		System.out.print("Enter source : ");
		src=Character.digit(Character.toUpperCase(sc.next().charAt(0))-65,10);
		System.out.print("Enter destination : ");
		dest=Character.digit(Character.toUpperCase(sc.next().charAt(0))-65,10);
		srcLinkInput(nw,src);
		srcNeighbourLink(nw,src);
	}
}