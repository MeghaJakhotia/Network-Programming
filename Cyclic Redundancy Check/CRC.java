import java.util.*;

public class CRC{
	static int[] gen,msg,cwd,amsg,rem;

	/*returns the remainder i.e. CRC obtainded after division*/
	static int[] genCRC(){
		int[] temp=new int[amsg.length];
		int[] remainder=new int[gen.length-1];
		int flag=0,step=0,stepFlag=0;
		for (int i=0 ;i<amsg.length;++i ) {
			temp[i]=amsg[i];
		}
		for(int i=0,j;i+gen.length<=temp.length;i+=step){
			for (j=step=stepFlag=0;j<gen.length;++j ) {
				if (stepFlag==0) {
					if((temp[i+j]^=gen[j])==0){
						++step;
					}
					else {
						stepFlag=1;
					}
				}
				else temp[i+j]^=gen[j];
			}
			//System.out.println(i +" : "+Arrays.toString(temp));
		}

		for (int i=msg.length;i<temp.length ;++i ) {
			remainder[i-msg.length]=temp[i];
		}
		return remainder;
	}

	/*returns true if there exists an error*/
	static boolean checkCRC(){
		int[] temp=new int[cwd.length];
		int flag=0,step=0,stepFlag=0;
		boolean error=false;
		for (int i=0 ;i<cwd.length;++i ) {
			temp[i]=cwd[i];
		}
		for(int i=0,j;i+gen.length<=temp.length;i+=step){
			for (j=step=stepFlag=0;j<gen.length;++j ) {
				if (stepFlag==0) {
					if((temp[i+j]^=gen[j])==0){
						++step;
					}
					else {
						stepFlag=1;
					}
				}
				else temp[i+j]^=gen[j];
			}
			//System.out.println(i +" : "+Arrays.toString(temp));
		}
		for (int i=msg.length;i<temp.length ;++i ) {
			if((rem[i-msg.length]=temp[i])==1){
				error=true;
			}
		}
		return error;
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		char[] generator,message;
		System.out.println();
		System.out.print("Enter the generator: ");
		generator=sc.next().toCharArray();
		gen=new int[generator.length];
		for (int i=0;i<generator.length ; ++i) {
			gen[i]=Character.digit(generator[i],10);
		}
		System.out.print("Enter option 1.Generate CRC\t2.Check CRC\t");
		switch (sc.nextInt()) {
			case 1:{
				System.out.println();
				System.out.print("Enter the message to be transmitted: ");
				message=sc.next().toCharArray();
				msg=new int[message.length];
				amsg=new int[message.length+generator.length-1];
				cwd=new int[message.length+generator.length-1];
				rem=new int[gen.length-1];
				for (int i=0;i<message.length ; ++i) {
					cwd[i]=amsg[i]=msg[i]=Character.digit(message[i],10);
				}
				System.out.println();
				System.out.println("Dividend : \t"+amsg.length+" \t"+Arrays.toString(amsg));
				System.out.println("Divisor : \t"+gen.length+" \t"+Arrays.toString(gen));
				rem=genCRC();
				System.out.println("Remainder : \t"+rem.length+" \t"+Arrays.toString(rem));
				for (int i=0;i<rem.length ;++i ) {
					cwd[i+msg.length]=rem[i];
				}
				System.out.println("CodeWord : \t"+cwd.length+" \t"+Arrays.toString(cwd));
				break;
			}
			case 2:{
				System.out.println();
				System.out.print("Enter the received message: ");
				message=sc.next().toCharArray();
				cwd=new int[message.length];
				for (int i=0;i<message.length ; ++i) {
					cwd[i]=Character.digit(message[i],10);
				}
				msg=new int[message.length-gen.length+1];
				rem=new int[gen.length-1];
				for (int i=0;i<msg.length ;++i ) {
					msg[i]=cwd[i];
				}
				if(checkCRC()){
					System.out.println();
					System.out.println("Error in received code");
					System.out.println("Remainder : \t"+rem.length+" \t"+Arrays.toString(rem));
				}
				else {
					System.out.println();
					System.out.println("No error");
					System.out.println("Original message : \t"+msg.length+" \t"+Arrays.toString(msg));
				}

				break;
			}
			default:{
				System.out.println("WRONG OPTION");
				break;
			}
		}
	}
}