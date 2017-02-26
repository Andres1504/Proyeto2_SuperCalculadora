import java.io.*;

public class Archivos {
	
	FileInputStream entrada;
	FileOutputStream salida;
	File archivo;
	
	public Archivos() {	}
	
	public void AbrirCualquiera(String ruta) throws IOException {
		try (
			FileInputStream in = new FileInputStream(ruta);
			FileOutputStream out = new FileOutputStream(ruta);
			) {
			int c;
			while((c=in.read())!=-1) {
				
				out.write(c);
			}
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public void GuardarCualquiera(String ruta) {
		
		try {
			FileOutputStream out = new FileOutputStream(ruta);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		
	}
	
	public String AbrirArchivo(File archivo) {
		String contenido="";
		
		try {
			
			entrada=new FileInputStream(archivo);
			int ascii;
			while((ascii=entrada.read()) !=-1) {
				char caracter = (char) ascii;
				contenido+=caracter;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return contenido;
	}

	public String GuardarTexto(File archivo, String contenido) {
		String respuesta=null;
		
		try {
			
			salida= new FileOutputStream(archivo);
			byte[] bytesTxt=contenido.getBytes();
			salida.write(bytesTxt);
			respuesta = "Se guardo con exito el archivo";
			
		}catch(Exception e) {
			
		}
		
		return respuesta;
	}
	
	

}
