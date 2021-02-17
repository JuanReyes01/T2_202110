package model.logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;
import model.data_structures.ILista;
import model.data_structures.ListaEncadenada;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private ListaEncadenada<YoutubeVideo> datos;
	
	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo()
	{
		datos = new ListaEncadenada<YoutubeVideo>();
	}
	
	/**
	 * Constructor del modelo del mundo con capacidad dada
	 * @param tamano
	 */
//	public Modelo(int capacidad)
//	{
//		datos = new ArregloDinamico<String>(capacidad);
//	}
	
	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano()
	{
		return datos.size();
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregar(YoutubeVideo dato)
	{	
		datos.addLast(dato);
	}
	
	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 */
	public Object buscar(YoutubeVideo dato)
	{
		return datos.getElement(datos.isPresent(dato));
	}
	
	/**
	 * Requerimiento eliminar dato
	 * @param <T>
	 * @param dato Dato a eliminar
	 * @return dato eliminado
	 */
	public YoutubeVideo eliminar(YoutubeVideo dato)
	{
		return datos.deleteElement(datos.isPresent(dato));
	}
	
	
	/**
	 * Requerimiento invierte los datos
	 */
	//public void invertir(){
	//	datos.exchange(1, 3);
	//}
	
	public ListaEncadenada<YoutubeVideo> darArreglo(){
		return datos;
	}
	
	public String cargarDatos() throws IOException, ParseException{
		long miliI = System.currentTimeMillis();
		Reader in = new FileReader("./data/videos-small.csv");
		
		Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);	
		for (CSVRecord record : records) {
		    String id = record.get(0);
		    String trending = record.get(1);
		    String titulo = record.get(2);
		    String canal = record.get(3);
		    String categoria = record.get(4);
		    String fechaP = record.get(5);
		    String tags = record.get(6);
		    String vistas = record.get(7);
		    String likes  = record.get(8);
		    String dislikes = record.get(9);
		    String coment = record.get(10);
		    String foto = record.get(11);
		    String nComent = record.get(12);
		    String rating = record.get(13);
		    String vidErr = record.get(14);
		    String descripcion = record.get(15);
		    String pais = record.get(16);
		    //--------------------------------------------------------------------
		    if(!id.equals("video_id")){
		    SimpleDateFormat formato = new SimpleDateFormat("yyy/MM/dd");
		    String[] aux = trending.split("\\.");
		    Date fechaT = formato.parse(aux[0]+"/"+aux[2]+"/"+aux[1]);
		    SimpleDateFormat formato2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");		   
		    Date fechaPu = formato2.parse(fechaP);
		    YoutubeVideo nuevo = new YoutubeVideo(id, fechaT, titulo, canal, Integer.parseInt(categoria), fechaPu, tags, Integer.parseInt(vistas), Integer.parseInt(likes), Integer.parseInt(dislikes), Integer.parseInt(coment), foto, (nComent.equals("FALSE")?false:true), (rating.equals("FALSE")?false:true), (vidErr.equals("FALSE")?false:true), descripcion, pais);
		    datos.addLast(nuevo);
		    }
		}
		
		long miliF = System.currentTimeMillis();
		return "Tiempo de ejecución total: "+((miliF-miliI))+" milisegundos, \nTotal datos cargados: "+ datos.size();
	}	
}
