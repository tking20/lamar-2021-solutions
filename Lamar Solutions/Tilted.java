import java.util.Scanner;

public class Tilted
{
    public static void main(String[] args)
    {
        Scanner read = new Scanner(System.in);
        double m = read.nextDouble();
        double k = read.nextDouble();
        read.close();
        if(2*m > k)
        {
            System.out.println("spin me");
            System.exit(0);
        }
        double a2 = m*m;
        double c2 = k*k/4;
        double b = Math.sqrt(c2-a2);
        System.out.printf("%.7f%n", 90 - Math.toDegrees(Math.asin(b/(k/2))));
    }
}