import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mint
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String[] info = read.readLine().split(" ");
		int k = Integer.parseInt(info[0]);
		int n = Integer.parseInt(info[1]);
		
		String[] line = read.readLine().split(" ");
		int[] nums = new int[n];
		long[] dp = new long[n+1];
		
		for(int i = 0; i<n; i++)
		{
			nums[i] = Integer.parseInt(line[i]);
			dp[i+1] = dp[i] + nums[i];
		}
		
		for(int i = 1; i<=n; i++)
		{
			for(int j = i; j<=n; j++)
			{
				if(dp[j] - dp[j-i] == k)
				{
					System.out.println((j-i)+" "+(j-1));
					System.exit(0);
				}
			}
		}
	}
}