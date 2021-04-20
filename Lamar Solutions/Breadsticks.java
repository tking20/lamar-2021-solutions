import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Breadsticks
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String[] info = read.readLine().split(" ");
		int n = Integer.parseInt(info[0]);
		int m = Integer.parseInt(info[1]);
		int[][] log = new int[m][2];
		for(int i = 0; i<m; i++)
		{
			String[] line = read.readLine().split(" ");
			log[i][0] = Integer.parseInt(line[0]);
			log[i][1] = Integer.parseInt(line[1]);
		}
		int k = Integer.parseInt(read.readLine());
		boolean flipped = false;
		for(int i = 0; i<m; i++)
		{
			if(k >= log[i][0] && k <= log[i][1])
			{
				flipped = !flipped;
			}
		}
		System.out.println(k+" "+(flipped ? 1 : 0));
	}
}