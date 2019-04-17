package TercerPunto;

import java.util.ArrayList;
import java.util.Iterator;

public class tercerPunto {

	private ArrayList<Integer> order; // topological order

	public tercerPunto(int[][] matriz, int numeroVertices)
	{
		System.out.println("-------------------DFS-------------------");
		DirectedCycle cyclefinder = new DirectedCycle(matriz, numeroVertices);

		if (!cyclefinder.hasCycle())
		{
			DepthFirstOrder dfs = new DepthFirstOrder(matriz, numeroVertices);
			order = dfs.reversePost();
			for (int i = 0; i < order.size(); i++) 
			{
				System.out.println(order.get(i));
			}
		}
		else
		{
			System.out.println("Se encontro el siguiente ciclo: ");
			for(int vertice: cyclefinder.cycle())
			{
				System.out.print(vertice+" ");
			}
		}
	}
	public Iterable<Integer> order()
	{ return order; }

	public boolean isDAG()
	{ return order == null; }
}
