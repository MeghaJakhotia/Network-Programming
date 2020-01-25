import java.util.*;

public class CharCount{

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

		String outputEncode="";
		String[] outputDecode;
		int i,n;
		Scanner stdin=new Scanner(System.in);
		System.out.println();
		System.out.print("Enter the no. of frames : ");
		n=stdin.nextInt();
		String[] array=new String[n];

		for (i=0; i<array.length;++i ) {
			System.out.print("Enter data for frame "+(i+1)+" : ");
			array[i]=stdin.next();
		}

		outputEncode=encode(array);
		System.out.println();
		System.out.println("Encoded output : "+outputEncode);
		
		outputDecode=decode(outputEncode);
		System.out.println();
		System.out.println("Decoded output : ");
		i=0;
		for (String frames:outputDecode ) {
			System.out.println("Frame "+(++i)+" : "+frames);
		}
	}
}