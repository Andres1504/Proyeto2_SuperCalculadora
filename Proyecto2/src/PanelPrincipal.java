import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;



public class PanelPrincipal extends JPanel {
	
	private JLabel etiqueta5;
	private JLabel etiqueta4;
	private JLabel etiqueta3;
	private JLabel etiqueta1;
	private JLabel etiqueta2;
	private JButton guardar;
	private JButton reiniciarSys;
	private JButton encriptar;
	private JButton desencriptar;
	private JButton guardarCryp;
	private JButton captura;
	public JTextField caja1;
	public JTextField caja2;
	public JTextArea texto;
	public JTextArea texto2;
	public JTextArea texto3;
	private JScrollPane bar1;
	private JScrollPane bar2;
	private JScrollPane bar3;

	
	
	File archivo;
	Archivos file = new Archivos();
	private String pass; 
	ListaC list = new ListaC();
	

	
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public PanelPrincipal() {

		this.setVisible(true);
		this.setLayout(null);
		
		this.etiqueta3 = new JLabel("Vista Previa del archivo:");
		etiqueta3.setBounds(30, 80 , 180, 20);
		
		this.etiqueta4 = new JLabel("Texto Encriptado:");
		etiqueta4.setBounds(600, 300 , 180, 20);
		
		this.etiqueta5 = new JLabel("Texto Des Encriptado:");
		etiqueta5.setBounds(600, 100 , 180, 20);
		
		this.etiqueta1 = new JLabel("Nombre del Archivo:");
		etiqueta1.setBounds(10, 10 , 130, 20);
		
		this.caja1 = new JTextField();
		this.caja1.setBounds(150, 10, 370, 20);
		
		this.etiqueta2 = new JLabel("Ruta del Archivo:");
		etiqueta2.setBounds(10, 40, 150, 20);
		
		this.caja2 = new JTextField();
		this.caja2.setBounds(150, 40, 370, 20);
		
		this.texto = new JTextArea("");
		this.bar1 = new JScrollPane();
		this.bar1.setBounds(30,100,370,300);
		this.bar1.setViewportView(texto);
		//this.texto.setBounds(30, 100, 370, 300);
		
		this.texto2 = new JTextArea("");
		this.bar2 = new JScrollPane();
		this.bar2.setBounds(600, 330, 370, 100);
		this.bar2.setViewportView(texto2);
		
		this.texto3 = new JTextArea("");
		this.bar3 = new JScrollPane();
		this.bar3.setBounds(600, 150, 370, 100);
		this.bar3.setViewportView(texto3);

		this.reiniciarSys = new JButton("Reiniciar Sistema");
		this.reiniciarSys.setBounds(600, 30, 140, 30);
		
		
		this.guardar = new JButton("Guardar Cambios");
		this.guardar.setBounds(30, 450 , 140, 30);
		this.guardar.setToolTipText("Guardar la modificacion del archivo de Texto");  
		
		this.captura = new JButton("Capturar Texto para encriptar");
		this.captura.setBounds(250, 450 , 220, 30);
		this.captura.setToolTipText("Capturar el texto para encriptar"); 
		
		this.encriptar = new JButton("ENCRIPTAR");
		this.encriptar.setBounds(600, 450 , 140, 30);
		this.encriptar.setToolTipText("Ocultar el contenido del archivo"); 
		
		this.desencriptar = new JButton("DESENCRIPTAR");
		this.desencriptar.setBounds(800, 450 , 140, 30);
		this.desencriptar.setToolTipText("Mostrar el contenido Oculto del archivo"); 
		
		this.guardarCryp = new JButton("GUARDAR");
		this.guardarCryp.setBounds(800, 290 , 130, 25);
		this.guardarCryp.setToolTipText("Guardar texto encriptado");
		

		
		this.add(this.bar1);
		this.add(this.bar2);
		this.add(this.bar3);
		this.add(this.caja1);
		this.add(this.caja2);
		this.add(this.etiqueta1);
		this.add(this.etiqueta2);
		this.add(this.etiqueta3);
		this.add(this.etiqueta4);
		this.add(this.etiqueta5);
		this.add(this.guardar);
		this.add(this.encriptar);	
		this.add(this.desencriptar);
		this.add(this.captura);
		this.add(this.guardarCryp);
		this.add(this.reiniciarSys);
		
		

		

		guardar.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent evt) {
				JFileChooser filec = new JFileChooser();

				int opcion = filec.showSaveDialog(guardar);
				if(opcion==JFileChooser.APPROVE_OPTION) {			
					
					archivo=filec.getSelectedFile();
					if(archivo.getName().endsWith("txt")) {
						String contenido = texto.getText();
						String respuesta = file.GuardarTexto(archivo, contenido);
						if(respuesta!=null) {
							JOptionPane.showMessageDialog(null,respuesta);
						} else {
							JOptionPane.showMessageDialog(null,"Error al guardar texto");
						}
					} else {
						JOptionPane.showMessageDialog(null,"Debe guardar con extension TXT");
					}
				}
			}	
		});
		
		guardarCryp.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent evt) {
				JFileChooser filec = new JFileChooser();

				int opcion = filec.showSaveDialog(guardar);
				if(opcion==JFileChooser.APPROVE_OPTION) {			
					
					archivo=filec.getSelectedFile();
					if(archivo.getName().endsWith("txt")) {
						String contenido = texto2.getText();
						String respuesta = file.GuardarTexto(archivo, contenido);
						if(respuesta!=null) {
							JOptionPane.showMessageDialog(null,respuesta);
						} else {
							JOptionPane.showMessageDialog(null,"Error al guardar texto");
						}
					} else {
						JOptionPane.showMessageDialog(null,"Debe guardar con extension TXT");
					}
				}
			}	
		});
		
		reiniciarSys.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent evt) {
				list.setInicio(null);
				list.setActual(null);
				list.setActual2(null);
				list.setInicioCryp(null);
				texto.setText("");
				texto2.setText("");
				texto3.setText("");
				caja1.setText("");
				caja2.setText("");
				
			
			}	
		});
		
		captura.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent evt) {
				int comprobar=texto.getText().trim().length();
				if(comprobar==0) {
					JOptionPane.showMessageDialog(null,"NO HAY TEXTO QUE ENCRIPTAR");
				}
				
				else {
					String na = texto.getText();
					
					
					int a=0;
					char[] textos = na.toCharArray();
					int ciclo = textos.length;
					while(a!=ciclo) {
						char p = textos[a];
						list.insertarTexto(p);
						a++;
					}
					
					JOptionPane.showMessageDialog(null, "TEXTO GUARDADO Y LISTO PARA ENCRIPTAR");
				}
			}	
		});
		encriptar.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent evt) {
				
				int comp = texto.getText().trim().length();
				
				if(comp==0) {
					JOptionPane.showMessageDialog(null, "NO HAY TEXTO QUE ENCRIPTAR");
				} else {
					
					int a=0;
					pass = JOptionPane.showInputDialog("INGRESE LA CONTRASEÑA");
					
					if(pass==null) {
						JOptionPane.showMessageDialog(null, "OPERACION CANCELADA");
					}
					else {
						char[] palabra =pass.toCharArray();
						int ciclo = palabra.length;
						while(a!=ciclo) {
							char p = palabra[a];
							list.insertar(p);
							a++;
						}
						String encriptada=list.encryptionString();
						texto2.setText(encriptada);
					}
				}
			}	
		});
		
		desencriptar.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent evt) {
				int comp = texto2.getText().trim().length();
				
				if(comp==0) {
					JOptionPane.showMessageDialog(null, "NO HAY TEXTO QUE DESENCRIPTAR");
				} else {
					String na = texto2.getText();
					
					int a=0;
					char[] textos2 = na.toCharArray();
					int ciclo = textos2.length;
					while(a!=ciclo) {
						char p = textos2[a];
						list.insertarTextoCryp(p);
						a++;
					}
					
					
					int as=0;
					pass = JOptionPane.showInputDialog("INGRESE LA CONTRASEÑA PARA DES-ENCRIPTAR");
					
					if(pass==null) {
						JOptionPane.showMessageDialog(null, "OPERACION CANCELADA");
					}
					else {
						char[] palabra2 =pass.toCharArray();
						int ciclo2 = palabra2.length;
						while(as!=ciclo2) {
							char p = palabra2[as];
							list.insertarDecryip(p);
							as++;
						}
						String encriptada2inver="";
						String encriptada2=list.decryptionString();
						for(int x=encriptada2.length()-1;x>=0;x--){
							encriptada2inver = encriptada2inver + encriptada2.charAt(x);
						}
						texto3.setText(encriptada2inver);
					}
				}
			}	
		});
		
		
	}

	

}
