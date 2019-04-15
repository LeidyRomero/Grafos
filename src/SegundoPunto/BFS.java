package SegundoPunto;

import java.awt.font.NumericShaper;
import java.util.ArrayList;

public class BFS {
	/**
	 * Lista que se comportara como cola
	 */
	private ArrayList<Integer> cola;

	private boolean[] marcados;

	public BFS(int[][] matriz,int fuente, int numeroVertices)
	{
		marcados = new boolean[numeroVertices];
		cola = new ArrayList<>();

		cola.add(fuente);//agregar la fuente
		marcados[fuente] = true;
		int j = 0;
		//TODO revisar
		System.out.println("\n entré a BFS");
		System.out.print("{");
		ArrayList<Integer> grupoActual = new ArrayList<>(numeroVertices);
		while(!cola.isEmpty() )
		{
			int i = cola.remove(0);//eliminiar al primero de la cola
			
			grupoActual.add(i);
			for(int k = 0; k<numeroVertices; k ++)
			{
				if(matriz[i][k]>0 && marcados[k]!=true)//adyacentes
				{
					marcados[k] = true;
					cola.add(k);
					
				}
			}
			
			if(cola.isEmpty())
			{
				imprimirGrupo(grupoActual);
				grupoActual = new ArrayList<>(numeroVertices);
//				System.out.println("Entré a la cola vacia ");
				for(int l = 0; l<numeroVertices; l++)
				{
//					System.out.println(marcados[l]);
					if(marcados[l] == false)
					{
//						System.out.println(l);
						marcados[l]= true;
						cola.add(l);
						l= numeroVertices;
					}
				}
				j++;
			}

		}
		System.out.println("}");
	}
	
	public void imprimirGrupo(ArrayList<Integer> arreglo)
	{
		System.out.print("{");
		for(int i = 0; i<arreglo.size();i++)
		{
			if(i < arreglo.size()-1 )
				System.out.print(arreglo.get(i) +",");
			else
				System.out.print(arreglo.get(i));
		}
		System.out.print("}");
	}
}
