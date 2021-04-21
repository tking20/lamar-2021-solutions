import java.util.Scanner;

public class ToTheMoon 
{

	public static void main(String[] args) 
	{
		Scanner kb = new Scanner(System.in);
		int N = kb.nextInt();
		double mx = kb.nextDouble();
		double my = kb.nextDouble();
		double ymin = kb.nextDouble();
		double x = 0;
		double y = 0;
		for(int i = 0; i < N; i++)
		{
			double l = kb.nextDouble();
			double d = kb.nextDouble();
			d %= 360;
			double theta = d;
			int xSign = 1;
			int ySign = 1;
			if(d > 90 && d < 180)
			{
				theta = 180-d;
				ySign = -1;
			}
			else if(d > 180 && d < 270)
			{
				theta = d-180;
				ySign = -1;
				xSign = -1;
			}
			else if(d > 270 && d < 360)
			{
				theta = 360-d;
				xSign = -1;
			}
			
			if(d == 0)
			{
				y += l;
			}
			else if(d == 90)
			{
				x += l;
			}
			else if(d == 180)
			{
				y -= l;
			}
			else if(d == 270)
			{
				x -= l;
			}
			else
			{
				x += xSign * l * Math.sin(Math.toRadians(theta));
				y += ySign * l * Math.cos(Math.toRadians(theta));
			}
		}
		
		//System.out.println(x + " " + y + " -----------------------------");
		
		if(y > ymin)
		{
			double distance = dist(x,y,mx,my);
			double finalBearing = getBearing(x,y,mx,my,distance);
			System.out.println("To the moon!");
			System.out.printf("%.2fm at %.2f degrees", distance, finalBearing);
		}
		else
		{
			double distance = dist(x,y,0,0);
			double finalBearing = getBearing(x,y,0,0,distance);
			System.out.println("Abort mission; back to base");
			System.out.printf("%.2fm at %.2f degrees", distance, finalBearing);
		}
		kb.close();
	}
	
	public static double getBearing(double x1, double y1, double x2, double y2, double l)
	{
		double theta = 0;
		double add = 0;
		if(x2 > x1 && y2 > y1)
		{
			theta = Math.toDegrees(Math.asin((x2-x1)/l));
		}
		else if(x2 > x1 && y2 < y1)
		{
			theta = Math.toDegrees(Math.asin((y1-y2)/l));
			add = 90;
		}
		else if(x2 < x1 && y2 < y1)
		{
			theta = Math.toDegrees(Math.asin((x1-x2)/l));
			add = 180;
		}
		else if(x2 < x1 && y2 > y1)
		{
			theta = Math.toDegrees(Math.asin((y2-y1)/l));
			add = 270;
		}
		else if(x2 == x1 && y2 > y1)
		{
			theta = 0;
		}
		else if(x2 > x1 && y2 == y1)
		{
			theta = 90;
		}
		else if(x2 == x1 && y2 < y1)
		{
			theta = 180;
		}
		else if(x2 < x1 && y2 == y1)
		{
			theta = 270;
		}
		
		return theta + add;
	}
	
	public static double dist(double x1, double y1, double x2, double y2)
	{
		return Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
	}

}
/*
3
15 15
12
3 0
5 30
4 315

3
15 15
10
3 0
5 30
4 315

1
0 10
5
9 0

1
0 10
5
10 0

1
0 10
7
3 45

1
0 10
1
3 45

*/