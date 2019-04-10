package Estructuras;

import java.util.NoSuchElementException;

public class ColaDePrioridadOrientadaMinimo {

	private int maxN;  		 //Tamanio maximo     
	private int n;           //Tamanio actual
	private int[] pq;        //heap binario
	private int[] qp;        //inverso
	private int[] vertices;  

	public ColaDePrioridadOrientadaMinimo(int nMax)
	{
		maxN = nMax;
		n = 0;
		pq = new int[nMax+1];
		qp = new int[nMax+1];
		vertices = new int[nMax+1];

		for (int i = 0; i <= maxN; i++)
		{
			qp[i] = -1;
		}
	}
	public boolean isEmpty() {
		return n == 0;
	}
	public int size() {
		return n;
	}
	public void insert(int i, int vertice) {
		if (i < 0 || i >= maxN) throw new IllegalArgumentException();
		//if (contains(i)) throw new IllegalArgumentException("index is already in the priority queue");
		n++;
		qp[i] = n;
		pq[n] = i;
		vertices[i] = vertice;
		swim(n);
	}
	private void swim(int k) {
		while (k > 1 && greater(k/2, k)) {
			exch(k, k/2);
			k = k/2;
		}
	}
	private boolean greater(int i, int j) {
		return vertices[pq[i]]>(vertices[pq[j]]);
	}

	private void exch(int i, int j) {
		int swap = pq[i];
		pq[i] = pq[j];
		pq[j] = swap;
		qp[pq[i]] = i;
		qp[pq[j]] = j;
	}
	public int delMin() {
		int min = pq[1];
		exch(1, n--);
		sink(1);
		assert min == pq[n+1];
		qp[min] = -1;        // delete
		vertices[min] = 0;    // to help with garbage collection TODO revisar
		pq[n+1] = -1;        // not needed
		return min;
	}
	private void sink(int k) {
		while (2*k <= n) {
			int j = 2*k;
			if (j < n && greater(j, j+1)) j++;
			if (!greater(k, j)) break;
			exch(k, j);
			k = j;
		}
	}
	public boolean contains(int i) {
        if (i < 0 || i >= maxN) throw new IllegalArgumentException();
        return qp[i] != -1;
    }
	public void decreaseKey(int i, int vertice) {
        if (i < 0 || i >= maxN) throw new IllegalArgumentException();
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        if (vertices[i]<=vertice)
            throw new IllegalArgumentException("Calling decreaseKey() with given argument would not strictly decrease the key");
        vertices[i] = vertice;
        swim(qp[i]);
    }
}
