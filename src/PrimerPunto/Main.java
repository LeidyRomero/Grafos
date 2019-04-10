package PrimerPunto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	public final static String PEQUENIO = "";
	public final static String MEDIO = "";
	public final static String GRANDE = "";

	private static int[][] grafo;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try {

			BufferedReader bf = new BufferedReader(new FileReader(PEQUENIO));
			String linea = bf.readLine();
			int cont = 0;
			int j = 0;
			String[] datos = null;
			grafo = null;
			
			if(linea != null)
			{
				datos = linea.split("	");
				grafo = new int[datos.length][datos.length];
			}
			
			while(linea != null)
			{
				grafo[cont][j] = Integer.parseInt(datos[j]);
				if(j<datos.length) 
				{ j++; }
				else
				{
					linea = bf.readLine();
					j = 0;
					datos = linea.split("	");
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("Errores leyendo la matriz");
		}

		
		Dijkstra d = new Dijkstra(grafo,grafo[0].length, grafo[0][0]);
	}

}
