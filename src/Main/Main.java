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
		menuPrincipal();
	}
	public static void selector(int option, Scanner sc) throws IOException
	{
		switch(option)
		{
		case 0:
			elegirArchivo(sc);
			break;
		case 1:
			primerPunto uno = new primerPunto(matriz, matriz[0].length);
			break;
		case 2:
			segundoPunto dos = new segundoPunto(matriz, matriz[0].length);
			break;
		case 3:
			tercerPunto tres = new tercerPunto(matriz, matriz[0].length);
			break;
		}
	}
	public static void menuPrincipal() throws IOException
	{
		System.out.println("-------------ISIS 1105 - Disenio y analisis de algoritmos----------");
		System.out.println("-----------------------------Tarea 6-------------------------------");
		System.out.println("0. Cargar datos a una matriz");
		System.out.println("1. Primer punto");
		System.out.println("2. Segundo punto");
		System.out.println("3. Tercer punto");
		
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		selector(option, sc);
	}
	public static void elegirArchivo(Scanner sc) throws IOException
	{
		System.out.println("0. Archivo pequeño (distances5)");
		System.out.println("1. Archivo mediano (distances100)");
		System.out.println("2. Archivo grande (distances1000)");
		int archivo = sc.nextInt();
		if(archivo == 0 || archivo == 1 || archivo == 2)
			cargarMatriz(archivo);

		menuPrincipal();
	}
	public static void cargarMatriz(int archivo) throws IOException
	{
		String cargar = "";
		if (archivo == 0) cargar = PEQUENIO;
		else if(archivo == 1) cargar = MEDIO;
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
