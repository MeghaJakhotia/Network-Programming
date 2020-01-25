import java.util.*;

public class BitStuffing{

	static String encode(String input){
		String flag="01111110";
		int count=0;
		StringBuilder output=new StringBuilder(flag);
		for (char text:input.toCharArray() ) {
			switch(text){
				case '1':{
					output.append(text);
					++count;
					if (count==5) {
						output.append(0);
						count=0;	
					}
					break;
				}
				case '0':{
					output.append(text);
					count=0;
					break;
				}
			}
		}
		output.append(flag);
		return output.toString();
	}

	static String decode(String encodedInput){
		int count=0;
		StringBuilder output=new StringBuilder();
		StringBuilder en=new StringBuilder(encodedInput);
		en.delete(0,8);
		while(en.length()!=8){
			switch(en.charAt(0)){
				case '1':{
					output.append(1);
					en.deleteCharAt(0);
					++count;
					if (count==5) {
						en.deleteCharAt(0);
						count=0;
					}
					break;
				}
				case '0':{
					output.append(0);
					en.deleteCharAt(0);
					count=0;
					break;
				} 
			}
		}
		return output.toString();
	}

	public static void main(String[] args) {
		String inputMsg="1111101111111110111",outputEncode,outputDecode;
		Scanner stdin=new Scanner(System.in);
		System.out.println();

		System.out.print("Enter the message : ");
		inputMsg=stdin.next();

		outputEncode=encode(inputMsg);
		System.out.println();
		System.out.println("Encoded output : "+outputEncode);

		outputDecode=decode(outputEncode);
		System.out.println();
		System.out.println("Decoded output : "+outputDecode);
	}
}