import java.util.Scanner;

public class Calculator
{
	public static long pow(int a, long b)
	{
		if(b == 0)
		{
			return 1;
		}
		if(b == 1)
		{
			return a;
		}
		
		long recursion = pow(a, b/2);
		recursion *= recursion;
		
		recursion %= 1_000_000_007;
		
		if(b % 2 == 1)
		{
			return (recursion * a) % 1_000_000_007;
		}
		else
		{
			return recursion;
		}
	}
	
	public static void main(String[] args)
	{
		Scanner read = new Scanner(System.in);
		int a = read.nextInt();
		long b = read.nextLong();
		System.out.println(pow(a, b));
		read.close();
	}
}