package PrimerPunto;
/**
 * Clase que implementa el algoritmo de Bellman Ford para encontrar los caminos de costos minimos
 * pre: 
 * @author Leidy Romero y David Saavedra
 */
public class BellmanFord {
	/**
	 * Vertice sucesor del vertice en la posicion i, la construcción de vertices sucesores conforman el camino
	 */
	private int[] camino;
	/**
	 * Costo de llegar al vertice de la posicion i, es decir cada posicion del arreglo representa un vertice 
	 * y el valor del arreglo en esa posicion es el costo de llegar a el
	 */
	private int[] costo;
	
	public BellmanFord(int[][] matriz, int pNumeroVertices, int fuente)
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

		int j = 0;
		int k = fuente;//TODO revisar que pasa cuando el vertice fuente no es 0
		int i = 1;
		
		while( i<pNumeroVertices-1 && k<pNumeroVertices )
		{
			if(matriz[k][j]>0)
			{
				
				if(costo[j]> costo[k]+matriz[k][j])
				{
					costo[j] = costo[k]+matriz[k][j];
					camino[j] = k;
				}
				// Si el costo de llegar a j es mayor que el arco de k a j 
//				if(costo[j]>matriz[k][j]&&costo[j]!=Double.POSITIVE_INFINITY)
//				{
//					costo[j] = costo[j] + matriz[k][j];
//					camino[j] = k;//TODO revisar orden de j y k
//				}
//				else
//				{
//					costo[j] = matriz[k][j];
//					camino[j] = k;
//				}
				if(j<pNumeroVertices-1) j++;
				else
				{
					k++;
					j = 0;
				}
			}
			else if(j<pNumeroVertices-1)
			{
				j++;
			}
			else if(j==pNumeroVertices-1)
			{
				i++;
				k++;
				j=0;
			}
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
