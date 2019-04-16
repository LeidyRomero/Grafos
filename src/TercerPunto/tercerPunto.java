package TercerPunto;

import java.util.ArrayList;
import java.util.Iterator;

public class tercerPunto {

	private ArrayList<Integer> order; // topological order

	public tercerPunto(int[][] matriz, int numeroVertices)
	{
		System.out.println("-------------------DFS-------------------");
		DirectedCycle cyclefinder = new DirectedCycle(matriz, numeroVertices);

		System.out.println("hay ciclo?");
		if (!cyclefinder.hasCycle())
		{

			System.out.println("no hay ciclo, entonces hace dfs");
			DepthFirstOrder dfs = new DepthFirstOrder(matriz, numeroVertices);
			order = dfs.reversePost();
			for (int i = 0; i < order.size(); i++) 
			{
				System.out.println("imprime orden topologico");
				System.out.println(order.get(i));
			}
		}
		else
		{
			for(int vertice: cyclefinder.cycle())
			{
				System.out.println("imprime ciclo, porque si hay ciclo");
				System.out.println(vertice+",");
			}
		}
	}
	public Iterable<Integer> order()
	{ return order; }

	public boolean isDAG()
	{ return order == null; }
}
