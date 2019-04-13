package TercerPunto;

import java.util.ArrayList;

public class DirectedCycle {

	private boolean[] marked;
	private int[] edgeTo;
	private ArrayList<Integer> cycle; // vertices on a cycle (if one exists)
	private boolean[] onStack; // vertices on recursive call stack

	public DirectedCycle(int[][] matriz, int numeroVertices)
	{
		onStack = new boolean[numeroVertices];
		edgeTo = new int[numeroVertices];
		marked = new boolean[numeroVertices];
		for (int v = 0; v < numeroVertices; v++)
			if (!marked[v]) dfs(matriz, v,matriz[0].length);
	}

	private void dfs(int[][] matriz, int v, int numeroVertices)
	{
		onStack[v] = true;
		marked[v] = true;
		for (int w = 0;w<numeroVertices && w>0 ;w++)
		{
			if (this.hasCycle()) return;
			else if (!marked[w])
			{ edgeTo[w] = v; dfs(matriz, w, numeroVertices); }
			else if (onStack[w])
			{
				cycle = new ArrayList<>();
				for (int x = v; x != w; x = edgeTo[x])
					cycle.add(0, x);
				cycle.add(0, w);
				cycle.add(0, v);
			}
		}
		onStack[v] = false;
	}

	public boolean hasCycle()
	{ return cycle != null; }

	public Iterable<Integer> cycle()
	{ return cycle; } 

}
