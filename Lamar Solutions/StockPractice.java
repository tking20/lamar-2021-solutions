import java.util.Scanner;

public class StockPractice 
{

	public static void main(String[] args) 
	{
		Scanner kb = new Scanner(System.in);
		int N = kb.nextInt();
		int current, currentBuy, currentSell, currentMin, currentProfit, currentBuyDay, currentSellDay, currentMinDay;
		current = currentBuy = currentSell = currentMin = (N >= 1)? kb.nextInt(): 0;
		currentProfit = 0;
		currentBuyDay = currentSellDay = currentMinDay = 0;
		for(int i = 1; i < N; i++)
		{
			current = kb.nextInt();
			if(current < currentMin)
			{
				currentMin = current;
				currentMinDay = i;
			}
			else if(current - currentMin > currentProfit)
			{
				currentBuy = currentMin;
				currentSell = current;
				currentBuyDay = currentMinDay;
				currentSellDay = i;
				currentProfit = currentSell - currentBuy;
			}
		}
		if(currentProfit == 0)
		{
			System.out.println("Bad Investment.");
		}
		else
		{
			System.out.println("Buy on day " + (currentBuyDay+1) + " and sell on day " + (currentSellDay+1) + " for a profit of $" + currentProfit + " per share.");
		}
		kb.close();
	}
	
}
