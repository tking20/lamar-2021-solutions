import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Lasagna
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String[] info = read.readLine().split(" ");
		int n = Integer.parseInt(info[0]);
		int m = Integer.parseInt(info[1]);
		HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<Integer, HashMap<Integer, Integer>>();
		for(int i = 0; i<m; i++)
		{
			String[] line = read.readLine().split(" ");
			int u = Integer.parseInt(line[0]);
			int v = Integer.parseInt(line[1]);
			int w = Integer.parseInt(line[2]);
			
			map.putIfAbsent(u, new HashMap<Integer, Integer>());
			map.get(u).put(v, w);
			
			map.putIfAbsent(v, new HashMap<Integer, Integer>());
			map.get(v).put(u, w);
		}
		read.close();
		
		int[] dis = new int[n];
		for(int i = 1; i<n; i++)
		{
			dis[i] = 1_000_000_000;
		}
		
		PriorityQueue<Node> q = new PriorityQueue<Node>();
		q.add(new Node(0, 0));
		
		while(!q.isEmpty())
		{
			Node node = q.poll();
			int u = node.vertex;
			if(map.containsKey(u))
			{
				HashMap<Integer, Integer> neighbors = map.get(u);
				for(int v : neighbors.keySet())
				{
					int temp = dis[u] + neighbors.get(v);
					if(temp < dis[v])
					{
						dis[v] = temp;
						q.add(new Node(v, temp));
					}
				}
			}
		}
		int ans = dis[1];
		for(int i = 2; i<n; i++)
		{
			ans ^= dis[i];
		}
		System.out.println(ans);
	}
	
	static class Node implements Comparable<Node>
	{
		int vertex;
		int distance;
		
		public Node(int v, int d)
		{
			vertex = v;
			distance = d;
		}
		
		@Override
		public int compareTo(Node o)
		{
			if(distance < o.distance)
			{
				return -1;
			}
			if(distance > o.distance)
			{
				return 1;
			}
			if(vertex < o.vertex)
			{
				return -1;
			}
			return 1;
		}
	}
}