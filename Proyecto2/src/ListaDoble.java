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
	
	
	public static void listaSuma(long dato) {
		NodoDoble nuevo = new NodoDoble();
		nuevo.setDato(dato);
		
		if(suma == null) {
			suma = nuevo;
		}
		else {
			nuevo.setSiguiente(suma);
			suma.setAnterior(nuevo);
			suma = nuevo;
		}
	}
	
	public static void listaResta(long res) {
		NodoDoble nuevo = new NodoDoble();
		nuevo.setDato(res);
		
		if(resta == null) {
			resta = nuevo;
		}
		else {
			nuevo.setSiguiente(resta);
			resta.setAnterior(nuevo);
			resta = nuevo;
		}
	}
	
	public void listaMulti(long dato) {
		NodoDoble nuevo = new NodoDoble();
		nuevo.setDato(dato);
		
		if(multi == null) {
			multi = nuevo;
		}
		else {
			nuevo.setSiguiente(multi);
			multi.setAnterior(nuevo);
			multi = nuevo;
		}
	}

	public static void mostrarDatos(Integer elemen) throws ListaVaciaException, IOException {
		
		NodoDoble aux = null;
		long numero;
		if(elemen == 1) aux=inicio;
		if(elemen == 2) aux=inicio2;
		if(elemen == 3) aux=suma;
		if(elemen == 4) aux=resta;
		if(elemen == 5) aux=multi;
		if(aux==null) throw new ListaVaciaException();
		

		File file;
		file = new File("OUTPUT.txt");


		try {
			FileWriter fileWriter = new FileWriter(file,true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			PrintWriter printWriter = new PrintWriter(bufferedWriter);
			
			if(elemen == 1) printWriter.print(" \nLista1: ");
			if(elemen == 2) printWriter.print(" \nLista2: ");
			if(elemen == 3) printWriter.print(" \nSUMA: ");
			if(elemen == 4) printWriter.print(" \nRESTA: ");

			
			while (aux != null) {
				String a = "" + aux.getDato();
				printWriter.print(a);
				aux = aux.getSiguiente();
			}

			printWriter.write("\n");
			printWriter.close();
			bufferedWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

			
	}
	
	public static void mostrarDatosMulti(ListaDoble elem) throws ListaVaciaException {
		NodoDoble aux = null;
		aux=ListaDoble.getMulti();
		if(aux==null) throw new ListaVaciaException();
			while(aux != null){			
				System.out.printf("%d, ", aux.getDato());
				aux=aux.getSiguiente();
				
			}
	}

	public void multiplicar() throws FileNotFoundException, IOException, ListaVaciaException {
		inicio=null;
		inicio2=null;
		cargarContenido("archivo.txt");
		ListaDoble laux = new ListaDoble();
		ListaDoble laux2=new ListaDoble();
		long res=0;
		NodoDoble aux = inicio;
		NodoDoble aux2 = inicio2;
		
		int cont=0;
		long dato=0;
		long prestado=0;
		boolean bandera=false;
		
		insertarDatoFinal(0);
		insertarDato2Final(0);
		
		while(aux.getSiguiente() != null){
			
			aux=aux.getSiguiente();
		}
		while(aux2.getSiguiente() != null){	
			
			aux2=aux2.getSiguiente();
		}
		
		while(aux2!=null) {

			aux=inicio;
			while(aux!=null) {
				res=aux.getDato()*aux2.getDato();
				res=res+prestado;
				if(res>=10) {
					dato=res%10;
					prestado=res/10;
					bandera=true;
					if(cont==0)laux.listaMulti(dato);
					else laux2.listaMulti(dato);
				}
				else {
					if(cont==0)laux.listaMulti(res);
					else laux2.listaMulti(res);
				}
					
				
				
				aux=aux.getAnterior();
			}
			cont++;
			aux2=aux2.getAnterior();
		}
		
	}
	
	public void suma() throws FileNotFoundException, IOException {
		inicio=null;
		inicio2=null;
		cargarContenido("archivo.txt");
		NodoDoble aux = inicio;
		NodoDoble aux2 = inicio2;
		long res = 0;
		int prestado=0;
		long dato=0;
		boolean bandera=false;
		
		completar();
		insertarDatoFinal(0);
		insertarDato2Final(0);

		
		
		while(aux.getSiguiente() != null){
			
			aux=aux.getSiguiente();
		}
		while(aux2.getSiguiente() != null){	
			
			aux2=aux2.getSiguiente();
		}
		
		while((aux!=null) && (aux2!=null)) {
			bandera=false;
			res=aux.getDato()+aux2.getDato();
			if(res>=10) {
				dato=res%10;
				bandera=true;
			}
			if(bandera==true) {
				listaSuma(dato);
				
			}
			else {
				listaSuma(res);
		
			}
			aux=aux.getAnterior();
			if(bandera==true)aux.setDato(aux.getDato()+1);
			aux2=aux2.getAnterior();
		}
	
	}

	public void resta() throws FileNotFoundException, IOException, ListaVaciaException {
		inicio=null;
		inicio2=null;
		cargarContenido("archivo.txt");
		NodoDoble aux = inicio;
		NodoDoble aux2 = inicio2;
		ListaDoble resta = new ListaDoble();
		long res = 0;
		long dato=0;
		long prestado=0;
		long suma1=0;
		long suma2=0;
		boolean bandera=false;
		boolean bandera2=false;
		
		completar();
		

		
		while(aux!=null) {
			aux=aux.getSiguiente();
			suma1++;
		}
		
		while(aux2!=null) {
			aux2=aux2.getSiguiente();
			suma2++;
		}
		
		if(suma1==suma2) {
			suma1=0;
			suma2=0;
			aux=inicio;
			aux2=inicio2;
			
			while(aux!=null) {
				suma1=suma1+aux.getDato();
				aux=aux.getSiguiente();
			}
			
			while(aux2!=null) {
				suma2=suma2+aux2.getDato();
				aux2=aux2.getSiguiente();
			}
			
		}
		
		if(suma1>=suma2) {
			aux=inicio;
			aux2=inicio2;
		} else {
			aux=inicio2;
			aux2=inicio;
			bandera2=true;
		}
		
		completar();
		
		while(aux.getSiguiente() != null){			
			aux=aux.getSiguiente();
		}
		while(aux2.getSiguiente() != null){			
			aux2=aux2.getSiguiente();
		}

		while((aux!=null) && (aux2!=null)) {
			bandera=false;
			if(aux.getDato()<aux2.getDato()) {
				
				aux.setDato(aux.getDato()+10);
				dato=aux.getDato()-aux2.getDato();
				aux=aux.getAnterior();
				if(aux.getDato()!=0) {
					prestado=(aux.getDato()-1);
					aux.setDato(prestado);
				}
				aux=aux.getSiguiente();
				bandera=true;
				
			}
			else {
				res=aux.getDato()-aux2.getDato();
			}
			
			if(bandera==false)listaResta(res);
			else if(bandera==true)listaResta(dato);
			aux=aux.getAnterior();
			
			if((bandera==true)&&(aux.getDato()==0)&&(aux.getAnterior()!=null) &&(aux.getAnterior().getDato()!=0)) {
				aux.setDato(9);
				aux=aux.getAnterior();
				aux.setDato(aux.getDato()-1);
	
				aux=aux.getSiguiente();
			}
			aux2=aux2.getAnterior();
		}
		if(bandera2==true){

			File file;
			file = new File("OUTPUT.txt");
			try {
				FileWriter fileWriter = new FileWriter(file,true);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				PrintWriter printWriter = new PrintWriter(bufferedWriter);
				
				printWriter.write("\n");
				printWriter.write("\n\n--Resultado de la resta Negativo--");
				printWriter.close();
				bufferedWriter.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

	public void completar() {
		NodoDoble aux = inicio;
		NodoDoble aux2 = inicio2;
		int conta=0;
		int contb=0;
		int completa;
		
		while(aux != null){			
			conta++;
			aux=aux.getSiguiente();
		}
		while(aux2 != null){			
			contb++;
			aux2=aux2.getSiguiente();
		}
		
		if(conta>contb) {
			completa = conta-contb;
			for(int y=0;y<completa;y++) {
				insertarDato2Final(0);
			}
		}
		else {
			completa=contb-conta;
			for(int y=0;y<completa;y++) {
				insertarDatoFinal(0);
			}
		}
		
	}
	
	private void insertarDatoFinal(long dato) {
		NodoDoble nuevo = new NodoDoble();
		NodoDoble aux2=null;
		nuevo.setDato(dato);
		if(inicio == null) {
			inicio = nuevo;
		}
		else {
			nuevo.setSiguiente(inicio);
			inicio.setAnterior(nuevo);
			inicio = nuevo;
		}
		
		
	}

	private void insertarDato2Final(long dato) {
		NodoDoble nuevo = new NodoDoble();
		NodoDoble aux2=null;
		nuevo.setDato(dato);
		if(inicio2 == null) {
			inicio2 = nuevo;
		}
		else {
			nuevo.setSiguiente(inicio2);
			inicio2.setAnterior(nuevo);
			inicio2 = nuevo;
		}
		
		
	}

	public void determinarMayor() throws FileNotFoundException, IOException {
		inicio=null;
		inicio2=null;
		cargarContenido("archivo.txt");
		NodoDoble aux = inicio;
		NodoDoble aux2 = inicio2;
		long suma1=0;
		long suma2=0;
		
		while(aux!=null) {
			aux=aux.getSiguiente();
			suma1++;
		}
		
		while(aux2!=null) {
			aux2=aux2.getSiguiente();
			suma2++;
		}
		
		if(suma1==suma2) {
			suma1=0;
			suma2=0;
			aux=inicio;
			aux2=inicio2;
			
			while(aux!=null) {
				suma1=suma1+aux.getDato();
				aux=aux.getSiguiente();
			}
			
			while(aux2!=null) {
				suma2=suma2+aux2.getDato();
				aux2=aux2.getSiguiente();
			}
			
		}
		
		if(suma1>suma2) {
			File file;
			file = new File("OUTPUT.txt");
			try {
				FileWriter fileWriter = new FileWriter(file,true);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				PrintWriter printWriter = new PrintWriter(bufferedWriter);
				
				printWriter.write("\n");
				printWriter.write("Lista 1 mayor\n");
				printWriter.close();
				bufferedWriter.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if(suma2>suma1) {
			File file;
			file = new File("OUTPUT.txt");
			try {
				FileWriter fileWriter = new FileWriter(file,true);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				PrintWriter printWriter = new PrintWriter(bufferedWriter);
				
				printWriter.write("\n");
				printWriter.write("Lista 2 mayor\n");
				printWriter.close();
				bufferedWriter.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			File file;
			file = new File("OUTPUT.txt");
			try {
				FileWriter fileWriter = new FileWriter(file,true);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				PrintWriter printWriter = new PrintWriter(bufferedWriter);
				
				printWriter.write("\n");
				printWriter.write("Son iguales\n");
				printWriter.close();
				bufferedWriter.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void refresh() {

		File file;
		file = new File("OUTPUT.txt");

		try {
			FileWriter fileWriter = new FileWriter(file, false);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			PrintWriter printWriter = new PrintWriter(bufferedWriter);

			printWriter.write("");
			printWriter.close();
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	

	public void printFile(long dato) throws IOException {

		File file;
		file = new File("OUTPUT.txt");
		

		try {
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			PrintWriter printWriter = new PrintWriter(bufferedWriter);

			printWriter.write(dato + ",");
			printWriter.close();
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public NodoDoble getInicio() {
		return inicio;
	}

	public static void setInicio(NodoDoble inicio) {
		ListaDoble.inicio = inicio;
	}

	public static NodoDoble getInicio2() {
		return inicio2;
	}

	public static void setInicio2(NodoDoble inicio2) {
		ListaDoble.inicio2 = inicio2;
	}

	public static NodoDoble getSuma() {
		return suma;
	}

	public static void setSuma(NodoDoble suma) {
		ListaDoble.suma = suma;
	}

	public static NodoDoble getResta() {
		return resta;
	}

	public static void setResta(NodoDoble resta) {
		ListaDoble.resta = resta;
	}
	
	public static NodoDoble getMulti() {
		return multi;
	}

	public static void setMulti(NodoDoble multi) {
		ListaDoble.multi = multi;
	}

	
}	
