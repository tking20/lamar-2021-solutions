import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Irony
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String s = read.readLine().toLowerCase();
		int pos1 = s.indexOf("irony");
		int pos2 = s.indexOf("ironic");
		if(pos1 == -1)
		{
			if(pos2 == -1)
			{
				System.out.println("Remarkable, Allison! Marvelous!");
			}
			else
			{
				System.out.println("ironic "+pos2);
			}
		}
		else
		{
			if(pos2 == -1 || pos1 < pos2)
			{
				System.out.println("irony "+pos1);
			}
			else
			{
				System.out.println("ironic "+pos2);
			}
		}
	}
}