package PrimerPunto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class primerPunto {

	public primerPunto(int[][] matriz, int numeroVertices) throws IOException {
		//algoritmos:
		System.out.println("--------------------Dijkstra----------------------");
		imprimirDijkstra(matriz, numeroVertices);
		System.out.println("\n--------------------Bellman Ford----------------------");
		imprimirBellmanFord(matriz, numeroVertices);
		System.out.println("\n--------------------Floyd Warschall----------------------");
		imprimirFloyd(matriz, numeroVertices);
	}
	/**
	 * 
	 */
	public static void imprimirDijkstra(int[][] matriz, int numeroVertices)
	{
		long tiempoInicial = 0;
		long tiempoFinal = 0;
		long tiempo = 0;
		for(int i = 0;i<numeroVertices;i++)
		{//TODO revisar que i si sea fuente
			tiempoInicial = System.currentTimeMillis();
			Dijkstra d = new Dijkstra(matriz, numeroVertices, i);
			tiempoFinal = System.currentTimeMillis();
			tiempo  = tiempoFinal-tiempoInicial;
			if(i == 0)
				System.out.println("Tiempo Dijkstra: "+ tiempo);
			else
				System.out.println("\nTiempo Dijkstra: "+ tiempo);

			int[] camino = d.getCamino();
			int[] costos = d.getCosto();

			System.out.println("Caminos iniciando en el vertice: "+ i);
			for(int k = 0;k<camino.length;k++)
			{
				if(k==camino.length-1)
				{
					System.out.print(k+":"+camino[k]);
				}
				else
				{
					System.out.print(k+":"+camino[k]+", ");
				}
			}
			System.out.println("\nCostos iniciando en el vertice: "+i);
			for(int h = 0;h<costos.length;h++)
			{
				if(h!=camino.length-1)
				{
					System.out.print(h+":"+costos[h]+", ");
				}
				else
				{
					System.out.print(h+":"+costos[h]);
				}

			}
		}
	}
	/**
	 * 
	 */
	public static void imprimirBellmanFord(int[][] matriz, int numeroVertices)
	{
		long tiempoInicial = 0;
		long tiempoFinal = 0;
		long tiempo = 0;
		for(int i = 0;i<numeroVertices;i++)
		{//TODO revisar que i si sea fuente
			tiempoInicial = System.currentTimeMillis();
			BellmanFord d = new BellmanFord(matriz, numeroVertices, i);
			tiempoFinal = System.currentTimeMillis();
			tiempo  = tiempoFinal-tiempoInicial;
			if(i == 0)
				System.out.println("Tiempo Bellman Ford: "+ tiempo);
			else
				System.out.println("\nTiempo Bellman Ford: "+ tiempo);

			int[] camino = d.getCamino();
			int[] costos = d.getCosto();

			System.out.println("Caminos iniciando en el vertice: "+ i);
			for(int k = 0;k<camino.length;k++)
			{
				if(k==camino.length-1)
				{
					System.out.print(k+":"+camino[k]);
				}
				else
				{
					System.out.print(k+":"+camino[k]+", ");
				}
			}
			System.out.println("\nCostos iniciando en el vertice: "+i);
			for(int h = 0;h<costos.length;h++)
			{
				if(h!=camino.length-1)
				{
					System.out.print(h+":"+costos[h]+", ");
				}
				else
				{
					System.out.print(h+":"+costos[h]);
				}

			}
		}
	}
	/**
	 * 
	 */
	public static void imprimirFloyd(int[][] matriz, int numeroVertices)
	{
		long tiempoInicial = 0;
		long tiempoFinal = 0;
		long tiempo = 0;
		tiempoInicial = System.currentTimeMillis();
		FloydWarschall d = new FloydWarschall(matriz, numeroVertices);
		tiempoFinal = System.currentTimeMillis();
		tiempo  = tiempoFinal-tiempoInicial;

		System.out.println("Tiempo Floyd Warschall: "+ tiempo);


		int[][] camino = d.getCaminos();
		int[][] costos = d.getCostos();

		System.out.println("Caminos: ");
		int i = 0;
		int k = 0;
		while(k<camino.length)
		{
			if(k==camino.length-1)
			{

				System.out.print(k+":"+camino[k][i]+", ");
			}
			else
			{

				System.out.print(k+":"+camino[k][i]+", ");
			}
			if(i+1<camino[0].length)
			{
				i++;
			}
			else
			{
				i = 0;
				k++;
			}
		}

		for(int h = 0;h<costos.length;h++)
		{
			System.out.println("\nCostos iniciando en el vertice: "+h);
			for(int q = 0; q< numeroVertices; q++)
			{
				System.out.print(costos[h][q]+ " ");
			}

		}
	}
}
