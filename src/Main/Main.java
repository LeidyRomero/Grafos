package Main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import PrimerPunto.primerPunto;
import SegundoPunto.segundoPunto;
import TercerPunto.tercerPunto;

public class Main {
	public final static String PEQUENIO = "./data/distances5.txt";
	public final static String MEDIO = "./data/distances100.txt";
	public final static String GRANDE = "./data/distances1000.txt";

	private static int[][] matriz;

	public static void main(String[] args) throws IOException {

		System.out.println(args[0]);
		cargarMatriz(args[0]);
		primerPunto uno = new primerPunto(matriz, matriz[0].length);
		segundoPunto dos = new segundoPunto(matriz, matriz[0].length);
		tercerPunto tres = new tercerPunto(matriz, matriz[0].length);
	}
	public static void cargarMatriz(String archivo) throws IOException
	{
		String cargar = "";
		if (archivo.equals("PEQUENIO")) cargar = PEQUENIO;
		else if(archivo.equals("MEDIANO")) cargar = MEDIO;
		else cargar = GRANDE;

		try {
			//crear la matriz a partir del archivo:
			
			BufferedReader bf = new BufferedReader(new FileReader(cargar));
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
	}
}
