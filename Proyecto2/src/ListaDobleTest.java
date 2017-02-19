import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

public class ListaDobleTest {
    public static void main(String[] args) throws IOException, ListaVaciaException {
    	ListaDoble list = new ListaDoble();
    	ListaDoble auxx = new ListaDoble();	

    	list.cargarContenido("archivo.txt");
    	
    	list.refresh();
    	
    	list.determinarMayor();
    	
    	list.mostrarDatos(1);

    	list.mostrarDatos(2);
    	
    	list.suma();

    	list.mostrarDatos(3);

    	list.resta();

    	list.mostrarDatos(4);
    	
    	
    }

}
