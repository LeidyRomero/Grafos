package SegundoPunto;

import java.util.ArrayList;

public class BFS {
	/**
	 * Lista que se comportara como cola
	 */
	private ArrayList<Integer> cola;

	private boolean[] marcados;

	public BFS(int[][] matriz,int fuente, int numeroVertices)
	{
		marcados = new boolean[numeroVertices];
		cola = new ArrayList<>();

		cola.add(fuente);//agregar la fuente
		marcados[fuente] = true;
		int j = 0;
		//TODO revisar
		while(!cola.isEmpty() && j<numeroVertices)
		{
			int i = cola.remove(0);//eliminiar al primero de la cola
			
			if(matriz[i][j]>0)//adyacentes
			{
				marcados[j] = true;
				cola.add(matriz[i][j]);
			}
			if(j<numeroVertices)
			{
				j++;
			}
			else
			{
				j=0;
				i = cola.remove(0);
			}
		}
	}
}
