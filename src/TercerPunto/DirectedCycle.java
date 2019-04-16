package TercerPunto;

import java.util.ArrayList;

public class DirectedCycle {

	private boolean[] marcados;
	private int[] edgeTo;
	private ArrayList<Integer> cycle; // vertices on a cycle (if one exists)
	private boolean[] enStack; // vertices on recursive call stack

	public DirectedCycle(int[][] matriz, int numeroVertices)
	{
		enStack = new boolean[numeroVertices];
		edgeTo = new int[numeroVertices];
		marcados = new boolean[numeroVertices];

		for (int v = 0; v < numeroVertices; v++)
			if (!marcados[v]) dfs(matriz, v, matriz[0].length);
	}

	private void dfs(int[][] matriz, int fuente, int numeroVertices)
	{
		System.out.println("empieza dfs, fuente: "+ fuente);
		enStack[fuente] = true;
		marcados[fuente] = true;
		for (int w = 0;w<numeroVertices ;w++)
		{
			if(matriz[fuente][w]>0)
			{ 	
				System.out.println("revisa adyacentes: fuente:"+fuente+"w: "+w);
				if (this.hasCycle()) 
				{ 
					System.out.println("retorno null");
					return;
				}
				else if (!marcados[w])
				{ 
					System.out.println("origen: "+fuente+", destino:"+w);
					edgeTo[w] = fuente; 
					dfs(matriz, w, numeroVertices); 
				}
				else if (enStack[w])
				{
					System.out.println("encontro ciclo");
					cycle = new ArrayList<>();
					for (int x = fuente; x != w; x = edgeTo[x])
						cycle.add(0, x);
					cycle.add(0, w);
					cycle.add(0, fuente);
				}
				else
				{
					System.out.println("entra al else");	
				}
			}
		}
		enStack[fuente] = false;
	}

	public boolean hasCycle()
	{ return cycle != null; }

	public Iterable<Integer> cycle()
	{ return cycle; } 

}
