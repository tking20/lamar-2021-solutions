import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cups
{
	public static long method(long l, int[] nums)
	{
		long ans = 0;
		for(int x : nums)
		{
			ans += (long)Math.ceil(1.0*x/l);
		}
		return ans;
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String[] info = read.readLine().split(" ");
		int n = Integer.parseInt(info[0]);
		int k = Integer.parseInt(info[1]);
		String[] line = read.readLine().split(" ");
		int[] nums = new int[n];
		for(int i = 0; i<n; i++)
		{
			nums[i] = Integer.parseInt(line[i]);
		}
		long min = 1;
		long max = 1L * Integer.MAX_VALUE * n;
		long mid = (max+min)/2;
		while(max > min)
		{
			if(method(mid, nums) <= k)
			{
				max = mid;
			}
			else
			{
				min = mid+1;
			}
			mid = (max+min)/2;
		}
		System.out.println(mid);
	}
}