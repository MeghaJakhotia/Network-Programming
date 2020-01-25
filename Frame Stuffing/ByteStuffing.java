import java.util.*;

public class ByteStuffing{

	static String encode(String input,char flag,char escape){
		StringBuilder output=new StringBuilder(flag+"");
		for (char text:input.toCharArray() ) {
			if (text==flag||text==escape) {
				output.append(escape);
			}
			output.append(text);
		}
		output.append(flag);
		return output.toString();
	}

	static String decode(String encodedInput,char flag,char escape){
		StringBuilder output=new StringBuilder();
		StringBuilder en=new StringBuilder(encodedInput);
		if (en.charAt(0)==flag) {
			en.deleteCharAt(0);
		}
		while(en.length()!=0){
			if (en.charAt(0)==escape) {
				en.deleteCharAt(0);
				output.append(en.charAt(0));
				en.deleteCharAt(0);
			}
			else if (en.charAt(0)==flag) {
				en.deleteCharAt(0);
				break;
			}
			else {
				output.append(en.charAt(0));
				en.deleteCharAt(0);
			}
		}
		return output.toString();
	}

	public static void main(String[] args) {
		String inputMsg="pQ#$x?",outputEncode,outputDecode;
		char flag='$',escape='#';
		Scanner stdin=new Scanner(System.in);
		System.out.println();

		System.out.print("Enter  flag  character : ");
		flag=stdin.next().trim().charAt(0);
		System.out.print("Enter escape character : ");
		escape=stdin.next().trim().charAt(0);

		System.out.print("Enter the message : ");
		inputMsg=stdin.next();

		outputEncode=encode(inputMsg,flag,escape);
		System.out.println();
		System.out.println("Encoded output : "+outputEncode);

		outputDecode=decode(outputEncode,flag,escape);
		System.out.println();
		System.out.println("Decoded output : "+outputDecode);
	}
}