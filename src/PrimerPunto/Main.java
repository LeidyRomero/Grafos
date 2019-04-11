package PrimerPunto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	public final static String PEQUENIO = "./data/distances5.txt";
	public final static String MEDIO = "./data/distances100.txt";
	public final static String GRANDE = "./data/distances1000.txt";

	private static int[][] matriz;


	public static void main(String[] args) throws IOException {
		try {

			BufferedReader bf = new BufferedReader(new FileReader(PEQUENIO));
			String linea = bf.readLine();
			int cont = 0;
			int j = 0;
			String[] datos = null;
			matriz = null;
			
			if(linea != null)
			{
				datos = linea.split("	");
				matriz = new int[datos.length][datos.length];
			}

			while(linea != null)
			{
				matriz[cont][j] = Integer.parseInt(datos[j]);
				if(j<datos.length-1) 
				{ j++; }
				else
				{
					linea = bf.readLine();
					j = 0;
					cont++;
					if(linea!=null)
						datos = linea.split("	");
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("Errores leyendo la matriz");
		}
		//TODO calcular caminos desde todos los vertices fuente, a todos los vertices destino
		long tiempoInicial = System.currentTimeMillis();
		Dijkstra d = new Dijkstra(matriz, matriz[0].length, matriz[0][0]);
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
}
