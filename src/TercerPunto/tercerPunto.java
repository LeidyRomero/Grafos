package TercerPunto;

import java.util.Iterator;

public class tercerPunto {

	private Iterable<Integer> order; // topological order
	public tercerPunto(int[][] matriz, int numeroVertices)
	{
		DirectedCycle cyclefinder = new DirectedCycle(matriz, numeroVertices);
		if (!cyclefinder.hasCycle())
		{
			DepthFirstOrder dfs = new DepthFirstOrder(matriz, numeroVertices);
			order = dfs.reversePost();
			Iterator<Integer> iterator = order.iterator();
			while(iterator.hasNext())
			{
				Integer i = iterator.next();
				System.out.println(i);
			}
		}
	}
	public Iterable<Integer> order()
	{ return order; }
	
	public boolean isDAG()
	{ return order == null; }
}
