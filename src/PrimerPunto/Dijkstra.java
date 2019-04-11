package PrimerPunto;

import Estructuras.ColaDePrioridadOrientadaMinimo;

/**
 * Clase que implementa el algoritmo de Dijkstra para encontrar los caminos de costos minimos
 * pre: El grafo es dirigido y los costos de los ejes no es negativo.
 * @author Leidy Romero y David Saavedra
 */
public class Dijkstra {
	/**
	 * Vertice sucesor del vertice en la posicion i, la construcción de vertices sucesores conforman el camino
	 */
	private int[] camino;
	/**
	 * Costo de llegar al vertice de la posicion i, es decir cada posicion del arreglo representa un vertice 
	 * y el valor del arreglo en esa posicion es el costo de llegar a el
	 */
	private int[] costo;
	/**
	 * Cola de prioridad para sacar el minimo en cada iteracion
	 */
	private ColaDePrioridadOrientadaMinimo pq;
	/**
	 * Constructor
	 * @param matriz matriz que representa al grafo, es una matriz cuadrada, elumero de filas y/o columnas es el numero de vertices
	 * @param pNumeroVertices numero total de vertices
	 * @param fuente nodo inicial
	 */
	public Dijkstra(int[][] matriz, int pNumeroVertices, int fuente)
	{
		camino = new int[pNumeroVertices];
		costo = new int[pNumeroVertices];

		//Se inicializan los valores de los costos hacia todos los vertices en infinito
		for(int i = 0; i<pNumeroVertices ; i++)
		{
			costo[i] = (int) Double.POSITIVE_INFINITY;
		}
		//El costo para llegar al primer vertice es 0
		costo[fuente] = 0;

		pq = new ColaDePrioridadOrientadaMinimo(pNumeroVertices);
		//inserto el primer nodo a la cola orientada a minimo
		pq.insert(fuente, costo[fuente]);
		//se revisa que la cola no este vacia
		while (!pq.isEmpty()) {
			int actual = pq.delMin();//elijo el elemento menor de la cola
			for(int i = 0; i<matriz[actual].length;i++)
			{
				//Revisa si existe un eje entre el vertice actual(fila) y el vertice i (columna) (diferente de -1)
				//Revisa que el vertice actual no sea el mismo vertice i (diferente de 0)
				if(matriz[actual][i]>0) 
					actualizar(matriz, actual, i);//actualiza el costo en la cola 
			}
		}
	}
	/**
	 * Actualiza el costo en las estructuras auxiliares
	 * @param matriz matriz que representa al grafo
	 * @param origen vertice origen
	 * @param destino vertice destino
	 */
	private void actualizar(int[][] matriz, int origen, int destino) {
		//Si el costo para llegar al destino es mayor que el costo para llegar al origen más el costo "actual", actualizo el costo y el camino
		if (costo[destino] > costo[origen] + matriz[origen][destino]) {
			costo[destino] = costo[origen] + matriz[origen][destino];
			camino[destino] = origen;
			if (pq.contains(destino)) pq.decreaseV(destino, costo[destino]);
			else pq.insert(destino, costo[destino]);
		}
	}
	/**
	 * Retorna el arreglo camino
	 * @return el arreglo que contiene los sucesores para llegar a todos los vertices
	 */
	public int[] getCamino() {
		return camino;
	}
	/**
	 * Retorna el arreglo costo
	 * @return el arreglo que contiene los costos minimos para llegar a todos los vertices
	 */
	public int[] getCosto() {
		return costo;
	}
	
}
