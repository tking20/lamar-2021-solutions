import java.util.ArrayList;
import java.util.Scanner;

public class ShareTracker 
{

	public static void main(String[] args) 
	{
		Scanner kb = new Scanner(System.in);	
		int P = kb.nextInt();
		int N = kb.nextInt();
		int width = 1;
		int high = P;
		int low = P;
		ArrayList<String> UI = new ArrayList<String>();
		UI.add("*");
		
		int pos = 0;
		for(int i = 0; i < N; i++)
		{
			int mod = kb.nextInt();
			if(pos-mod == UI.size())
			{
				String s = "";
				for(int j = 0; j < width; j++)
				{
					s += " ";
				}
				UI.add(s);
				low--;
			}
			else if(pos-mod < 0)
			{
				String s = "";
				for(int j = 0; j < width; j++)
				{
					s += " ";
				}
				UI.add(0,s);
				pos++;
				high++;
			}
			width += 1;
			for(int j = 0; j < UI.size(); j++)
			{
				if(j == pos-mod)
				{
					UI.set(j,UI.get(j)+"*");
				}
				else
				{
					UI.set(j, UI.get(j)+" ");
				}
			}
			pos = pos-mod;
		}
		
		print(UI, width, high, low);
		kb.close();
	}
	
	public static void print(ArrayList<String> UI, int width, int high, int low)
	{
		int numPadding = Math.max((high+"").length(), (low+"").length())+1;
		int totalPadding = numPadding+width+3;
		for(int i = 0; i < totalPadding; i++)
		{
			System.out.print("X");
		}
		System.out.println();
		
		for(int i = 0; i < UI.size(); i++)
		{
			System.out.printf("X%"+numPadding+"d:%sX%n",(high-i),UI.get(i));
		}
		
		for(int i = 0; i < totalPadding; i++)
		{
			System.out.print("X");
		}
		System.out.println();
		
	}

}
/*
5
0

5
3
-1
1
1

0
9
-1
-1
-1
1
1
1
1
1
1

*/