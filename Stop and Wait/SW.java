import java.util.*;

public class SW{

	static String encode(String[] array){
		StringBuilder output=new StringBuilder();
		for (String i:array ) {
			output.append((i.length()+1)+i);
		}
		return output.toString();
	}

	static String[] decode(String encoded){
		StringBuilder output=new StringBuilder();
		StringBuilder en=new StringBuilder(encoded);
		int len,i;
		for (i=0,len=0;en.length()!=0;++i,len=0) {
			while(Character.isDigit(en.charAt(0))){
				len=len*10+Integer.parseInt(en.charAt(0)+"");
				en.deleteCharAt(0);
			}
			--len;
			output.append(en.substring(0,len));
			en.delete(0,len);
			output.append(" ");
		}

		int n=i,spaceCount=0;
		i=0;
		String[] outputFrame=new String[n];
		while (output.length()!=0) {
			spaceCount=output.indexOf(" ");
			outputFrame[i++]=output.substring(0,spaceCount);
			output.delete(0,spaceCount+1);
		}
		return outputFrame;
	}

	public static void main(String[] args) {
		int mode;
		Scanner sc=new Scanner(System.in);
		System.out.println();
		System.out.println("1.Data Lost\t2.Data with ERROR|Acknowlegment Lost|Proper Data");
		System.out.print("Enter the mode :");
		mode=sc.nextInt();
		System.out.print("Enter the frame no. for sending : ");
		int y=sc.nextInt();
		System.out.print("Enter data for sending : ");
		String[] x=new String[1];
		x[0]=sc.next();
		switch (mode) {
			case 1:{
				try{
					Thread.sleep(5000);
				}
				catch (Exception e) {
					
				}
				System.out.println("Time out");
				System.out.println("Data Lost for frame "+y);
				System.out.println("Resending Data");
				break;
			}
			case 2:{
				String encodedMsg=encode(x);
				System.out.print("Enter data received : ");
				String receivedMsg=sc.next();
				if (encodedMsg.equals(receivedMsg)) {
					System.out.print("1.Acknowlegment Lost\t2.Proper Data\t:");
					int mode2=sc.nextInt();
					switch(mode2){
						case 1:{
							System.out.println("No ERROR");
							try{
								Thread.sleep(5000);
							}
							catch (Exception e) {
								
							}
							System.out.println("Time out");
							System.out.println("Acknowlegment Lost so Resending data");
							break;
						}
						case 2:{
							System.out.println("Data received Properly");
							break;
						}
					}
				}
				else{
					try{
						Thread.sleep(5000);
					}
					catch (Exception e) {
						
					}
					System.out.println("Time out");
					System.out.println("Data received with ERROR for frame "+y);
					System.out.println("Expected data : "+encodedMsg);
					System.out.println("Resending data");
				}
				break;
			}
		}
	}
}