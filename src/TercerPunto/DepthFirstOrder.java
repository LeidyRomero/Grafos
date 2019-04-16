package TercerPunto;

import java.util.ArrayList;

public class DepthFirstOrder {
	private boolean[] marked;
	private ArrayList<Integer> pre; // vertices in preorder
	private ArrayList<Integer> post; // vertices in postorder
	private ArrayList<Integer> reversePost; // vertices in reverse postorder

	public DepthFirstOrder(int[][] matriz, int numeroVertices)
	{
		pre = new ArrayList<Integer>();
		post = new ArrayList<Integer>();
		reversePost = new ArrayList<Integer>();
		marked = new boolean[numeroVertices];
		for (int v = 0; v < numeroVertices; v++)
			if (!marked[v]) dfs(matriz, v, matriz[0].length);
	}
	private void dfs(int[][] matriz, int v, int numeroVertices)
	{
		pre.add(v);
		marked[v] = true;
		for (int w = 0;w<numeroVertices && w>0 ;w++)
		{
			if (!marked[w])
				dfs(matriz, w, numeroVertices);
		}
		post.add(v);
		reversePost.add(0, v);;
	}
	public Iterable<Integer> pre()
	{ return pre; }

	public Iterable<Integer> post()
	{ return post; }

	public ArrayList<Integer> reversePost()
	{ return reversePost; }
}
