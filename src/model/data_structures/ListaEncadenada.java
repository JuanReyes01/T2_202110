package model.data_structures;

public class ListaEncadenada<T extends Comparable<T>> implements ILista<T>{

	private NodoLista<T> first;
	private int tamano;
	
	public ListaEncadenada() {
		first = null;
		tamano = 0;
	}
	
	public void addFirst(T element) {
		NodoLista<T> nuevo = new NodoLista<T>(element);
		if(first != null){
			nuevo.setNext(first);
		}
		first = nuevo;
		tamano++;
	}

	public void addLast(T element) {
		NodoLista<T> nuevo = new NodoLista<T>(element);
		if(first!=null){
			lastNode().setNext(nuevo);
		}
		else{
			first = nuevo;
		}
		tamano++;
	}

	public void insertElement(T element, int pos) {
		//PosReal compensa por el error de 1 entre el TAD y la lista enlazada
		NodoLista<T> nuevo = new NodoLista<T>(element);
		int posReal = pos-1;
		if(posReal<tamano){
			NodoLista<T> actual = first;
			int i = 1;
			if(first!=null){
					while(i<=posReal){
						i++;
						actual = actual.getNext();
					}
				NodoLista<T> aux = actual.getNext();
				actual.setNext(nuevo);
				nuevo.setNext(aux);
			}
			else{
				first = nuevo;
			}
			tamano++;
		}
	}
	
	public T removeFirst() {
		NodoLista<T> aux = first;
		first = aux.getNext();
		tamano--;
		return aux.getInfo();
	}
	
	public T removeLast() {
		NodoLista<T> actual = first;
		while(actual.getNext().getNext()!=null){
			actual = actual.getNext();
		}
		NodoLista<T> eliminado = actual.getNext();
		actual.setNext(null);
		tamano--;
		return eliminado.getInfo();
	}
	
	public T deleteElement(int pos) {
		//PosReal compensa por el error de 1 entre el TAD y la lista enlazada
		int posReal = pos-1;
		NodoLista<T> actual = first;
		if(posReal==0){
			first = actual.getNext();
			actual.setNext(null);
			tamano--;
			return actual.getInfo();
		}
		for(int i=0; i<tamano; i++){
			if(i+1==posReal){
				NodoLista<T> aux = actual.getNext();
				actual.setNext(aux.getNext());
				tamano--;
				return aux.getInfo();
			}
			actual = actual.getNext();
		}
		return null;
	}

	public T firstElement() {
		return first.getInfo();
	}
	
	public T lastElement() {
		return lastNode().getInfo();
	}

	public T getElement(int pos) {
		int posReal = pos-1;
		T retorno = null;
		NodoLista<T> actual = first;
		boolean stop = false;
		int i = 0;
		while(!stop){
			if(i == posReal){
				retorno = actual.getInfo();
				stop = true;
			}
			actual = actual.getNext();
			i++;
		}
		return retorno;
	}
	
	public int size() {
		return tamano;
	}
	
	public boolean isEmpty() {
		return (tamano==0)?false:true;
	}
	
	public int isPresent(T element) {
		NodoLista<T> actual = first;
		for(int i=0; i<tamano;i++){
			if(actual.getInfo().compareTo(element)==0)
				return (i+1);
			actual = actual.getNext();
		}
		return -1;
	}
	
	public void exchange(int pos1, int pos2) {
		int posReal1 = pos1-1;
		int posReal2 = pos2-1;
		NodoLista<T> buscado1 = null;
		NodoLista<T> buscado2 = null;
		NodoLista<T> actual = first;
		int i=0;
		if(posReal1<tamano&&posReal2<tamano){
		//compareTo no funciona en nodos
		while(i<=posReal1||i<=posReal2){
			if(posReal1==i)
				buscado1 = actual;
			else if(posReal2==i)
				buscado2 = actual;
			i++;
			actual = actual.getNext();
		}
		T aux = buscado1.getInfo();
		buscado1.setInfo(buscado2.getInfo());
		buscado2.setInfo(aux);
		}
		
	}

	public void changeInfo(int pos, T elem) {
		int posReal = pos-1;
		NodoLista<T> actual = first;
		boolean stop = false;
		for(int i=0; i<tamano&&!stop; i++){
			if(i==(posReal)){
				actual.setInfo(elem);
				stop = true;
			}
			actual = actual.getNext();
		}		
	}
	
	public NodoLista<T> firstNode(){
		return first;
	}
	
	public NodoLista<T> lastNode(){
		NodoLista<T> actual = first;
		if(first!=null){
			while(actual.getNext()!=null){
				actual = actual.getNext();				
			}
			return actual;
		}
		return null;
	}
	
}
