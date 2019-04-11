package PrimerPunto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class primerPunto {

	public primerPunto(int[][] matriz, int numeroVertices) throws IOException {
		//algoritmos:
		imprimirDijkstra(matriz, numeroVertices);
		imprimirBellmanFord(matriz, numeroVertices);
		imprimirFloyd(matriz, numeroVertices);
	}
	/**
	 * 
	 */
	public static void imprimirDijkstra(int[][] matriz, int numeroVertices)
	{
		//TODO calcular caminos desde todos los vertices fuente, a todos los vertices destino
		long tiempoInicial = System.currentTimeMillis();
		Dijkstra d = new Dijkstra(matriz, numeroVertices, matriz[0][0]);
		long tiempoFinal = System.currentTimeMillis();
		long tiempo  = tiempoFinal-tiempoInicial;
		int[] camino = d.getCamino();
		int[] costos = d.getCosto();

		System.out.println("Caminos: ");
		for(int k = 0;k<camino.length;k++)
		{
			System.out.println(k+": "+camino[k]);
		}
		System.out.println("Costos: ");
		for(int h = 0;h<costos.length;h++)
		{
			System.out.println(h+": "+costos[h]);
		}
		System.out.println("Tiempo Dijkstra: "+ tiempo);
	}
	/**
	 * 
	 */
	public static void imprimirBellmanFord(int[][] matriz, int numeroVertices)
	{
		//TODO calcular caminos desde todos los vertices fuente, a todos los vertices destino
		long tiempoInicial = System.currentTimeMillis();
		BellmanFord bf = new BellmanFord(matriz, numeroVertices, matriz[0][0]);
		long tiempoFinal = System.currentTimeMillis();
		long tiempo  = tiempoFinal-tiempoInicial;
		int[] camino = bf.getCamino();
		int[] costos = bf.getCosto();

		System.out.println("Caminos: ");
		for(int k = 0;k<camino.length;k++)
		{
			System.out.println(k+": "+camino[k]);
		}
		System.out.println("Costos: ");
		for(int h = 0;h<costos.length;h++)
		{
			System.out.println(h+": "+costos[h]);
		}
		System.out.println("Tiempo Bellman Ford: "+ tiempo);
	}
	/**
	 * 
	 */
	public static void imprimirFloyd(int[][] matriz, int numeroVertices)
	{
		//TODO calcular caminos desde todos los vertices fuente, a todos los vertices destino
//		long tiempoInicial = System.currentTimeMillis();
//		FloydWarschall fw = new FloydWarshall(matriz, numeroVertices, matriz[0][0]);
//		long tiempoFinal = System.currentTimeMillis();
//		long tiempo  = tiempoFinal-tiempoInicial;
//		int[] camino = fw.getCamino();
//		int[] costos = fw.getCosto();
//
//		System.out.println("Caminos: ");
//		for(int k = 0;k<camino.length;k++)
//		{
//			System.out.println(k+": "+camino[k]);
//		}
//		System.out.println("Costos: ");
//		for(int h = 0;h<costos.length;h++)
//		{
//			System.out.println(h+": "+costos[h]);
//		}
//		System.out.println("Tiempo Floyd Warschall: "+ tiempo);
	}
}
