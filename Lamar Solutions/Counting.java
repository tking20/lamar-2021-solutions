import java.util.Scanner;

public class Counting
{
	public static void main(String[] args)
	{
		Scanner read = new Scanner(System.in);
		long l = read.nextLong();
		read.close();
		System.out.println(l/10);
	}
}