package model.data_structures;

import java.util.ArrayList;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 * @param <T>
 *
 */
public class ArregloDinamico<T extends Comparable<T>> implements ILista<T> { 
		/**
		 * Capacidad maxima del arreglo
		 */
        private int tamanoMax;
		/**
		 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
		 */
        private int tamanoAct;
        /**
         * Arreglo de elementos de tamaNo maximo
         */
        private T elementos[ ];
      

        /**
         * Construir un arreglo con la capacidad maxima inicial.
         * @param max Capacidad maxima inicial
         */
		public ArregloDinamico( int max )
        {
               elementos = (T[]) new Comparable[max];
               tamanoMax = max;
               tamanoAct = 0;
        }
        
		public void agregar( T dato )
        {
               if ( tamanoAct == tamanoMax )
               {  // caso de arreglo lleno (aumentar tamaNo)
                    tamanoMax = 2 * tamanoMax;
                    T[ ] copia = elementos;
                    elementos = (T[]) new Comparable[tamanoMax];
                    for ( int i = 0; i < tamanoAct; i++)
                    {
                     	 elementos[i] = copia[i];
                    } 
            	    System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
               }	
               elementos[tamanoAct] = dato;
               tamanoAct++;
       }

		public int darCapacidad() {
			return tamanoMax;
		}

		public int darTamano() {
			return tamanoAct;
		}

		public T darElemento(int i) {
			return elementos[i];			
			// TODO implementar
		}

		public T buscar(T dato) {
			// TODO implementar
			// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
			T retorno=null;
			boolean stop=false;
			for(int i=0; i<elementos.length&&!stop; i++)
				if(elementos[i].equals(dato)){
					retorno = elementos[i];
					stop=true;
				}
				else{
					retorno = null;
				}
			return retorno;
		}

		public T eliminar(T dato) {
			// TODO implementar
			// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
			T eliminado=null;
			T[] nuevo = (T[]) new Comparable[elementos.length]; 			
			int j = 0;
			for(int i=0; i<elementos.length; i++){
				if(elementos[i]!=null&&elementos[i].equals(dato)){
					eliminado = elementos[i];					
				}
				else if(elementos[i]!=null){
					nuevo[j] = elementos[i];
					j++;
				}
				}
			
				tamanoAct = tamanoAct-1;
				elementos = nuevo;
			
			return eliminado;
		}

/**
 * Implementación original de Tales
 */
//		public void invertir() {
//		    T temporal = null; 
//		   
//		    for (int i = 0; i < elementos.length / 2; i++) {
//		           temporal = arreglo[i];
//		               int j = elementos.length - i - 1;
//		      
//		    	arreglo[i] = arreglo[j];
//		      arreglo[j] = temporal;
//		    }
//		    elementos = temporal;
//		  }


		public void invertir() {
			T[] invertida = ( T[]) new Comparable[elementos.length];
			for(int i=tamanoAct; i>0;i--){
				invertida[tamanoAct-i] = elementos[i-1]; 
			}
			elementos = invertida;
		}

@Override
public void addFirst(T element) {
	
	agregar(element);
}

/**
 * Agrega un elemento al final del arreglo.
 */
public void addLast(T element) {
	elementos[tamanoAct-1] = element;
	
}

/**
 * Agrega un elemento que llega por parametro a la posicion deseada.
 */
public void insertElement(T element, int pos) {
	elementos[pos] = element;
}

/**
 * Elimina el primer elemento de la lista.
 * @return Retorna el elemento eliminado.
 */
public T removeFirst() {
	eliminar(elementos[0]);
	return elementos[0];
}

/**
 * Elimina el ultimo elemento de la lista.
 * @return Retorna el elemento eliminado.
 */
public T removeLast() {
	eliminar(elementos[tamanoAct-1]);
	return elementos[tamanoAct-1];
}

/**
 * Elimina el elemento en la posicion que llega por parametro.
 * @return Retorna el elemento eliminado.
 */
public T deleteElement(int pos) {
	eliminar(elementos[pos]);
	return elementos[pos];
}

/**
 * Devuelve el primer elemento del arreglo.
 * @return Retorna el primer elemento del arreglo.
 */
public T firstElement() {
	
	return elementos[0];
}

/**
 * Devuelve el ultimo elemento del arreglo.
 * @return Retorna el ultimo elemento del arreglo.
 */
public T lastElement() {
	
	return elementos[tamanoAct-1];
}

/**
 * Busca el elemento en la posicion que entra por parametro.
 * @return el elemento en la posicion requerida.
 */
public T getElement(int pos) {

	return elementos[pos];
}

/**
 * Retorna el tamanio del arreglo.
 * @return un int con el tamnio del arreglo
 */
public int size() {
	return elementos.length;
}

/**
 * Verifica si el arreglo esta vacio o no.
 * @return True si el arreglo esta vacio, false de lo contrario.
 */
public boolean isEmpty() {
	boolean x = true;
	if(getElement(0)!= null ){
		x =false;
	}
	return x;
}

/**
* Retorna la posición de un elemento en la lista. 
* @return Retorna 0 si encuntra el elemento, -1 si no lo encuentra.
*/
public int isPresent(T element) {
	int x = -1;
	if(buscar(element)!= null){
		x =0;
	}
	return x;
}

/**	
 * Intercambia la información de los elementos en dos posiciones válidas.
 */
public void exchange(int pos1, int pos2) {
	
	elementos[pos1] = elementos[pos2];
}

/**
 * Actualiza el elemento en una posición válida de la lista.
 */
public void changeInfo(int pos, T elem) {
	
    elementos[pos] = elem;
}
			
		}
