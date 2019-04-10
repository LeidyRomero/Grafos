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

		//Se inicializan los valores de los costos hacia todos los vertices en infinito
		for(int i = 0; i<pNumeroVertices ; i++)
		{
			costo[i] = (int) Double.POSITIVE_INFINITY;
		}
		//El costo para llegar al primer vertice es 0
		costo[0] = 0;

		pq = new ColaDePrioridadOrientadaMinimo(pNumeroVertices);
		//inserto el primer nodo a la cola orientada a minimo
		pq.insert(fuente, costo[fuente]);
		//se revisa que la cola no este vacia
		while (!pq.isEmpty()) {
			int actual = pq.delMin();//elijo el elemento menor de la cola
			for(int i = 0; i<grafo[actual].length;i++)
			{
				//Revisa si existe un eje entre el vertice actual(fila) y el vertice i (columna) (diferente de -1)
				//Revisa que el vertice actual no sea el mismo vertice i (diferente de 0)
				if(grafo[actual][i]>0) 
					actualizar(grafo, actual, i);//actualiza el costo en la cola 
			}
		}
	}

	private void actualizar(int[][] grafo, int origen, int destino) {
		//Si el costo para llegar al destino es mayor que el costo para llegar al origen más el costo "actual", actualizo el costo y el camino
		if (costo[destino] > costo[origen] + grafo[origen][destino]) {
			costo[destino] = costo[origen] + grafo[origen][destino];
			camino[destino] = grafo[origen][destino];
			if (pq.contains(destino)) pq.decreaseV(destino, costo[destino]);
			else                pq.insert(destino, costo[destino]);
		}
	}
}
