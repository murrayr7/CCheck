import java.util.Scanner;
import java.lang.Math;

public class CheckDigit {
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter the credit card number to be tested:  ");
		long number = input.nextLong();
		long sum1 = (long) 0;
		for(int i=1; i<=(int)Math.log10(number);i=i+2){
			long num=isolateNumber(number,i);
			num=2*num;
			if(num>=10)
				num=isolateNumber(num,0)+isolateNumber(num,1);
			sum1+=num;
		}
		long sum2 = (long)0;
		for(int i=0; i<=(int)Math.log10(number);i=i+2){
			sum2+=isolateNumber(number,i);
		}
		long sum=sum1+sum2;
		if(sum%10==0)
			System.out.println("this card number is valid");
		else 
			System.out.println("this card number is not valid");
		
	}
	
	public static long isolateNumber(long input, int factorOfTen){
		long shortened = (long) (input%Math.pow(10,factorOfTen+1));
		long limiter = (long) (input%Math.pow(10,factorOfTen-1));
		long divisor = (long) (Math.pow(10, factorOfTen));
		long ret = (shortened-limiter)/divisor;
		return ret;
		
		
		
		//return (long)a;
		
		
		
		
		
		//return (long) ((long) ((input%Math.pow(10,factorOfTen+1))-input%Math.pow(10,factorOfTen-1))/Math.pow(10, factorOfTen));
	}
}
