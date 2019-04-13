package TercerPunto;

public class tercerPunto {

	private Iterable<Integer> order; // topological order
	public tercerPunto(int[][] matriz, int numeroVertices)
	{
		DirectedCycle cyclefinder = new DirectedCycle(matriz, numeroVertices);
		if (!cyclefinder.hasCycle())
		{
			DepthFirstOrder dfs = new DepthFirstOrder(matriz, numeroVertices);
			order = dfs.reversePost();
		}
	}
	public Iterable<Integer> order()
	{ return order; }
	
	public boolean isDAG()
	{ return order == null; }
}
