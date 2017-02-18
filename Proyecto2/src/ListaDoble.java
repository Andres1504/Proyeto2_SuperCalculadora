import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ListaDoble {
	private static NodoDoble inicio;
	private static NodoDoble inicio2;
	private static NodoDoble suma;
	private static NodoDoble resta;
	private static NodoDoble multi;
	static ListaDoble l1 = new ListaDoble();
	static ListaDoble l2 = new ListaDoble();
	
	public static void cargarContenido(String archivo) throws FileNotFoundException, IOException {
	    int numero=0;
	    int numero2=0;
		try
		{
		    FileReader fr = new FileReader(archivo);
		    Scanner Sc = new Scanner(fr);
		    
		    Sc.useDelimiter("");
		    while(Sc.hasNextInt()) {
		    	numero=Sc.nextInt();
		    	l1.insertarDato(numero);
		    }
		    Sc.nextLine();
		    while(Sc.hasNextInt()) {
		    	numero2=Sc.nextInt();
		    	l2.insertarDato2(numero2);
		    }

		}
		catch(Exception e)
		{
		   System.out.println("Error de lectura del fichero");
		}
		  
    }

	public static void insertarDato(long dato) {
		NodoDoble nuevo = new NodoDoble();
		NodoDoble aux=null;
		nuevo.setDato(dato);
		
		if(inicio == null) {
			inicio = nuevo;
		}
		else {
			aux=inicio;
			while(aux.getSiguiente()!=null) {
				aux=aux.getSiguiente();
			}
			aux.setSiguiente(nuevo);
			nuevo.setAnterior(aux);
		}
	}
	
	public static void insertarDato2(long dato) {
		NodoDoble nuevo = new NodoDoble();
		NodoDoble aux2=null;
		nuevo.setDato(dato);
		if(inicio2 == null) {
			inicio2 = nuevo;
		}
		else {
			aux2=inicio2;
			while(aux2.getSiguiente()!=null) {
				aux2=aux2.getSiguiente();
			}
			aux2.setSiguiente(nuevo);
			nuevo.setAnterior(aux2);
		}
	}
	
	
}	
