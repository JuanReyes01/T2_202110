package model.data_structures;

<<<<<<< HEAD
import java.util.ArrayList;
=======
import com.sun.xml.internal.bind.v2.model.util.ArrayInfoUtil;
>>>>>>> 5ef74d7c32f7e9dd2a3bd55c288fadaae32f6734

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
 /**Implementacion original       
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
*/
		//Dejo sin comentar el metodo invertir porque sigue implementado en la interfaz
		//Este metodo no es parte de este lab porque no es parte del TAD (por eso no esta en el UML)
		//es parte del pasado
		public void invertir() {
			T[] invertida = ( T[]) new Comparable[elementos.length];
			for(int i=tamanoAct; i>0;i--){
				invertida[tamanoAct-i] = elementos[i-1]; 
			}
			elementos = invertida;
		}

<<<<<<< HEAD
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
=======

public void addFirst(T element) {
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
   elementos[0] = element;
   int j = 1;
   for(T i:elementos){
	   elementos[j] = i;
	   j++;
   }
   tamanoAct++;
	
}


public void addLast(T element) {
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
   elementos[tamanoAct] = element;
   tamanoAct++;
	
}


public void insertElement(T element, int pos) {
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
	tamanoAct++;
	T[] nuevo = (T[]) new Comparable[tamanoAct];
	int j=0;
	for(int i=0; i<tamanoAct; i++){
	    if(pos==i){
	    	nuevo[i] = element;
	    }
	    else{
		nuevo[i] = elementos[j];
		j++;
	    }
	}
	
}

public T removeFirst() {
	T eliminado=elementos[0];
	T[] nuevo = (T[]) new Comparable[elementos.length]; 							
	for(int i=0; i<tamanoAct;i++){
		elementos[i] = elementos[i+1]; 
	}
	tamanoAct = tamanoAct-1;
	
	return eliminado;
}

@Override
public T removeLast() {
	T eliminado = null;
	elementos[tamanoAct-1]=null;
	tamanoAct--;
	return eliminado;
}

@Override
public T deleteElement(int pos) {
	T eliminado = null;
	//Le resto 1 a la posicion para compensar por la diferencia 
	//entre la maquina y el usuario (donde el para el usuario quiere borrar
	//el elemento en pos=2 pero digita la posicion 3)
	int posReal = pos-1;
	boolean elimina = false;
	for(int i=0;i<tamanoAct;i++){
		if(i==posReal){
			elimina = true;
			eliminado = elementos[posReal];
		}
		else if(elimina){
			elementos[i-1] = elementos[i];
		}
	}
	tamanoAct--;
	return eliminado;
}

>>>>>>> 5ef74d7c32f7e9dd2a3bd55c288fadaae32f6734
public T firstElement() {
	
	return elementos[0];
}

<<<<<<< HEAD
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
=======
public T lastElement() {
	//Como tamaño actual actua como .size() tengo que restar -1 
	//para que me de la respuesta correcta
	return elementos[tamanoAct-1];
}

public T getElement(int pos) {
	T buscado = null;
	int posReal = pos-1;
	if(posReal<=tamanoMax){
		return elementos[posReal];
	}
	return buscado;
}

public int size() {

	return tamanoAct;
}

public boolean isEmpty() {
	return (tamanoAct==0)?false:true;
}

public int isPresent(T element) {
	int pos = -1;
	for(int i=0; i<elementos.length;i++){
		if(elementos[i]==element){
			//Sumo 1 para devolver la posicion aparente al usuario
			return i+1;
		}
	}
	return pos;
}

public void exchange(int pos1, int pos2) {
	int posReal1 = pos1-1;
	int posReal2 = pos2-1;
	T temp = elementos[posReal1];
	elementos[posReal1] = elementos[posReal2];
	elementos[posReal2] = temp;
}

public void changeInfo(int pos, T elem) {
	int posReal = pos-1;
	elementos[posReal] = elem;
>>>>>>> 5ef74d7c32f7e9dd2a3bd55c288fadaae32f6734
}
			
		}
