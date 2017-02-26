import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Ventana extends JFrame  {
	
	private JMenuBar barraMenu;
	private JMenu menuArchivo;
	private JMenuItem itmBuscar;
	private JMenuItem buscarA;
	private FileNameExtensionFilter filter;
	

	File archivo;
	Archivos file = new Archivos();
	
	public static final int ANCHO = 1000;
	public static final int ALTO = 600;
	
	public Ventana() {
		
		this.setTitle("ENCRIPTADOR DE ARCHIVOS");
		
		this.barraMenu= new JMenuBar();
		this.menuArchivo=new JMenu("Archivo");
		this.itmBuscar=new JMenu("Buscar");
		this.buscarA=new JMenuItem("Buscar Arcvhivo");
		this.barraMenu.add(this.menuArchivo);
		this.menuArchivo.add(this.itmBuscar);
		this.itmBuscar.add(this.buscarA);

		PanelPrincipal panelP = new PanelPrincipal();
		this.add(panelP);
		this.setJMenuBar(barraMenu);
		
		
		
		
		filter = new FileNameExtensionFilter("Archivos de texto (.txt)","txt");
		buscarA.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent evt) {
				
				JFileChooser filec = new JFileChooser();
				filec.setFileFilter(filter);
				int opcion = filec.showOpenDialog(buscarA);
				
				if(opcion==JFileChooser.APPROVE_OPTION) {
					String nombreAr=filec.getSelectedFile().getName();
					String ruta=filec.getSelectedFile().getPath();
					panelP.caja1.setText(nombreAr);
					panelP.caja2.setText(ruta);
				
					
					
					archivo=filec.getSelectedFile();
					if(archivo.canRead()) {
						if(archivo.getName().endsWith("txt")) {
							String contenido = file.AbrirArchivo(archivo);
							panelP.texto.setText(contenido);
							
						}
					}
				}
			}	
		});
		
        Dimension tamFrame = this.getSize();//para obtener las dimensiones del frame
        Dimension tamPantalla = Toolkit.getDefaultToolkit().getScreenSize();      //para obtener el tamanio de la pantalla
        setLocation((tamPantalla.width-tamFrame.width)/5, (tamPantalla.height-tamFrame.height)/9);  //para posicionar*/
        
		this.setSize(ANCHO, ALTO);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
