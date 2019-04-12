package PrimerPunto;

import java.util.ArrayList;

/**
 * Clase que implementa el algoritmo de Floyd Warschall para encontrar los caminos de costos minimos
 * pre: 
 * @author Leidy Romero y David Saavedra
 */
public class FloydWarschall {
	//TODO importante programacion dinamica con un cubo???? wtf
	private int[][][] matrizCubica;
	private int[][] predecesores;
	
	public FloydWarschall(int numeroVertices, int[][] matriz)
	{
		int  j = 0;
		int i = 0;
		int k = 0;
		//Caso base
		while(i<numeroVertices)
		{
			matrizCubica[0][i][j] = matriz[i][j];

			if(j<numeroVertices)
				j++;
			else
			{
				j = 0;
				i++;
			}
		}

		j = 0;
		i = 0;
		while(k<numeroVertices+1)
		{
			int aux1 = matrizCubica[k-1][i][j];
			int aux2 = matrizCubica[k-1][i][k]+matrizCubica[k-1][k][j];
			if(aux1<aux2)
			{
				//TODO cargar predecesores
				matrizCubica[k][i][j] = aux1;
				//predecesores[i][j] = ;
			}
			else
			{
				matrizCubica[k][i][j] = aux2;
				//predecesores[i][j] = matriz[i][j];
			}

			if(j<numeroVertices && i<numeroVertices)
			{
				//recorro columnas
				if(j<numeroVertices)	
					j++;
				else
				{
					//cambio de fila
					j = 0;
					i++;
				}
			}
			else
			{
				//avanzo pagina, reinicio filas y columnas
				i = 0;
				j = 0;
				k++;
			}
		}
	}
}
