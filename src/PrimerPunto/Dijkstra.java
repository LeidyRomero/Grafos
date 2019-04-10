package PrimerPunto;

import Estructuras.ColaDePrioridadOrientadaMinimo;

/**
 * Clase que implementa el algoritmo de Dijkstra para encontrar los caminos de costos minimos
 * pre: El grafo es dirigido y los costos de los ejes no es negativo.
 * @author Leidy Romero y David Saavedra
 */
public class Dijkstra {

	private int[] camino;
	private int[] costo;
	private ColaDePrioridadOrientadaMinimo pq;

	public Dijkstra(int[][] grafo, int pNumeroVertices, int fuente)
	{
		camino = new int[pNumeroVertices];
		costo = new int[pNumeroVertices];


		for(int i = 0; i<pNumeroVertices ; i++)
		{
			costo[i] = (int) Double.POSITIVE_INFINITY;
		}
		costo[0] = 0;



		pq = new ColaDePrioridadOrientadaMinimo(pNumeroVertices);
		pq.insert(fuente, costo[fuente]);
		while (!pq.isEmpty()) {
			int actual = pq.delMin();
			for(int i = 0; i<grafo[actual].length;i++)
			{
				if(grafo[actual][i]>0) 
					actualizar(grafo, actual, i);
			}
		}
	}

	private void actualizar(int[][] grafo, int origen, int destino) {
		int v = origen, w = destino;
		if (costo[w] > costo[v] + grafo[v][w]) {
			costo[w] = costo[v] + grafo[v][w];
			camino[w] = grafo[v][w];
			if (pq.contains(w)) pq.decreaseKey(w, costo[w]);
			else                pq.insert(w, costo[w]);
		}
	}
}
