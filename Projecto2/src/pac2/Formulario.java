package pac2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.SpringLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.DebugGraphics;
import java.awt.Cursor;
import javax.swing.border.EtchedBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.awt.Toolkit;

public class Formulario extends JFrame {

	private JPanel contentPane;
	private JTextField fechaTxt;
	private JTextField nombreTxt;
	private JTextField correoTxt;
	private JTextField telefonoTxt;
	private JTextField turnoTxt;
	private JTextField numClientesTxt;



		public Formulario() {
			setIconImage(Toolkit.getDefaultToolkit().getImage(Formulario.class.getResource("/Imagenes/IconoRestaurante.png")));
			setAlwaysOnTop(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 816, 593);
			this.setLocationRelativeTo(null); 
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(255, 255, 255));
			panel.setBounds(0, 0, 800, 554);
			contentPane.add(panel);
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(new Color(255, 255, 255));
			panel_1.setBounds(0, 75, 800, 479);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JPanel panel_3 = new JPanel();
			panel_3.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(128, 128, 128), new Color(0, 0, 0)));
			panel_3.setBackground(Color.DARK_GRAY);
			panel_3.setBounds(88, 52, 273, 58);
			panel_1.add(panel_3);
			panel_3.setLayout(null);
			
			JLabel lblNewLabel_3 = new JLabel("Nombre");
			lblNewLabel_3.setBounds(25, 17, 93, 25);
			panel_3.add(lblNewLabel_3);
			lblNewLabel_3.setForeground(Color.WHITE);
			lblNewLabel_3.setBackground(Color.WHITE);
			
			nombreTxt = new JTextField();
			nombreTxt.setBounds(128, 0, 145, 58);
			panel_3.add(nombreTxt);
			nombreTxt.setHorizontalAlignment(SwingConstants.LEFT);
			nombreTxt.setColumns(10);
			
			JPanel panel_4 = new JPanel();
			panel_4.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(128, 128, 128), new Color(0, 0, 0)));
			panel_4.setForeground(Color.WHITE);
			panel_4.setBackground(Color.DARK_GRAY);
			panel_4.setBounds(88, 144, 273, 62);
			panel_1.add(panel_4);
			panel_4.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Correo electronico");
			lblNewLabel.setBounds(10, 24, 109, 14);
			panel_4.add(lblNewLabel);
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setBackground(Color.DARK_GRAY);
			
			correoTxt = new JTextField();
			correoTxt.setBounds(129, 0, 144, 62);
			panel_4.add(correoTxt);
			correoTxt.setBackground(Color.WHITE);
			correoTxt.setHorizontalAlignment(SwingConstants.LEFT);
			correoTxt.setColumns(10);
			
			JPanel panel_5 = new JPanel();
			panel_5.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(128, 128, 128), new Color(0, 0, 0)));
			panel_5.setBackground(Color.DARK_GRAY);
			panel_5.setForeground(Color.WHITE);
			panel_5.setBounds(400, 52, 324, 62);
			panel_1.add(panel_5);
			panel_5.setLayout(null);
			
			JLabel lblNewLabel_5 = new JLabel("Nuemero de clientes");
			lblNewLabel_5.setBounds(10, 24, 125, 14);
			panel_5.add(lblNewLabel_5);
			lblNewLabel_5.setForeground(Color.WHITE);
			lblNewLabel_5.setBackground(Color.DARK_GRAY);
			
			numClientesTxt = new JTextField();
			numClientesTxt.setBounds(145, 0, 179, 62);
			panel_5.add(numClientesTxt);
			numClientesTxt.setHorizontalAlignment(SwingConstants.LEFT);
			numClientesTxt.setColumns(10);
			
			JPanel panel_6 = new JPanel();
			panel_6.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(128, 128, 128), new Color(0, 0, 0)));
			panel_6.setForeground(Color.WHITE);
			panel_6.setBackground(Color.DARK_GRAY);
			panel_6.setBounds(400, 144, 324, 62);
			panel_1.add(panel_6);
			panel_6.setLayout(null);
			
			JLabel lblNewLabel_1 = new JLabel("Fecha");
			lblNewLabel_1.setBounds(38, 24, 80, 14);
			panel_6.add(lblNewLabel_1);
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setBackground(Color.DARK_GRAY);
			
			fechaTxt = new JTextField();
			fechaTxt.setBounds(144, 0, 180, 62);
			panel_6.add(fechaTxt);
			fechaTxt.setHorizontalAlignment(SwingConstants.LEFT);
			fechaTxt.setColumns(10);
			
			JPanel panel_7 = new JPanel();
			panel_7.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(128, 128, 128), new Color(0, 0, 0)));
			panel_7.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			panel_7.setForeground(Color.WHITE);
			panel_7.setBackground(Color.DARK_GRAY);
			panel_7.setBounds(88, 245, 279, 62);
			panel_1.add(panel_7);
			panel_7.setLayout(null);
			
			JLabel lblNewLabel_2 = new JLabel("Telefono");
			lblNewLabel_2.setBounds(10, 24, 90, 14);
			panel_7.add(lblNewLabel_2);
			lblNewLabel_2.setForeground(Color.WHITE);
			lblNewLabel_2.setBackground(Color.DARK_GRAY);
			
			telefonoTxt = new JTextField();
			telefonoTxt.setBounds(130, 0, 149, 62);
			panel_7.add(telefonoTxt);
			telefonoTxt.setHorizontalAlignment(SwingConstants.LEFT);
			telefonoTxt.setColumns(10);
			
			JPanel panel_8 = new JPanel();
			panel_8.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(128, 128, 128), new Color(0, 0, 0)));
			panel_8.setForeground(Color.WHITE);
			panel_8.setBackground(Color.DARK_GRAY);
			panel_8.setBounds(400, 245, 324, 62);
			panel_1.add(panel_8);
			panel_8.setLayout(null);
			
			JLabel lblNewLabel_4 = new JLabel("Numero de turno");
			lblNewLabel_4.setBounds(10, 24, 122, 14);
			panel_8.add(lblNewLabel_4);
			lblNewLabel_4.setForeground(Color.WHITE);
			lblNewLabel_4.setBackground(Color.DARK_GRAY);
			
			turnoTxt = new JTextField();
			turnoTxt.setBounds(142, 0, 182, 62);
			panel_8.add(turnoTxt);
			turnoTxt.setHorizontalAlignment(SwingConstants.LEFT);
			turnoTxt.setColumns(10);
			
			JButton btnNewButton_1 = new JButton("Salir");
			btnNewButton_1.setForeground(new Color(255, 255, 255));
			btnNewButton_1.setBounds(387, 318, 137, 58);
			panel_1.add(btnNewButton_1);
			btnNewButton_1.setBackground(Color.RED);
			
			JButton btnNewButton = new JButton("Confirmar");
			btnNewButton.setForeground(new Color(255, 255, 255));
			btnNewButton.setBounds(239, 318, 145, 57);
			panel_1.add(btnNewButton);
			btnNewButton.setBackground(new Color(130, 232, 96));
			
			JLabel IMAGEN = new JLabel("");
			IMAGEN.setIcon(new ImageIcon(Formulario.class.getResource("/Imagenes/fondo.jpg")));
			IMAGEN.setVerticalAlignment(SwingConstants.TOP);
			IMAGEN.setBounds(0, 0, 859, 479);
			panel_1.add(IMAGEN);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					//Comprobamos que los datos son correctos y creamos el usuario
					String nombre =nombreTxt.getText();
					String correo= correoTxt.getText();
					String fecha = fechaTxt.getText();
					String telefono = telefonoTxt.getText();
					String numCli= numClientesTxt.getText();
					String turno = turnoTxt.getText();
					boolean existe;
					boolean valido1=false;
					char [] letras=correo.toCharArray();
					System.out.println(letras);
					for(int i=0;i<letras.length;i++) {
						if(letras[i]=='@') {
							valido1=true;
						}
					}
					if(valido1=true) {
						if(Numeros(telefono)==true) {
							if(Numeros(numCli)==true) {
								if(Fecha(fecha)==true){
									Conexion db = new Conexion();
							        db.MySQLConnect();
							        String NombreDB = "reservas";
							        String NombreDBC="clientes";
									 Conexion conexion = new Conexion() ;

									
								    
								     String fechaComoCadena=CambiaFecha(fecha);
									 String Query2 = "SELECT SUM(`numero`) FROM `reservas` WHERE `fecha`='" +fechaComoCadena +"' AND `turno`='"+turno+"'";
									 SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy-MM-dd");
									 Date fechaComoDate = null;
									 String Query3 = "SELECT usuario FROM `clientes` WHERE `usuario`= "+telefono;
									  
									try {
										//Pasamos la fecha a formato date
										fechaComoDate = sdfrmt.parse(fecha);
									} catch (ParseException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								        try {
								        	
								        	//Comprobamos el numero de personas en una fecha determinada
								        	String resultado=NumPersonasQuery(Query2);
											

											//Conexion a la base de datos de parte de clientes
								        	System.out.println(ClienteQuery(Query3,telefono)); 
								        	existe=ClienteQuery(Query3,telefono);
											
											

											if (Integer.parseInt(resultado)<50) {
												//Realizamos reserva y la dejamos en espera si hay menos de 50 personas cierto dia;
										        
										        
										        if (existe==false) {
													//creamos cliente y reserva										  
										        	String Query = "INSERT INTO "+NombreDBC+"(id, usuario, Contraseña) VALUES (NULL,'"+telefono+"','"+correo+"')";
										        	CreaCliente(Query);
										        	
										        	JOptionPane.showMessageDialog(Formulario.this, "Creamos usuario");
										        	

													 Connection conec2=(Connection) conexion.MySQLConnect();
													 String Query4 = "INSERT INTO "+NombreDB+"(id, nombre, telefono, correo, turno, numero, fecha, Estado,id_cliente) VALUES (NULL,'"+nombre+"','"+telefono+"','"+correo+"','"+turno+"','"+numCli+"','"+fechaComoCadena+"','Espera','"+telefono+"')";										
													 Statement st2=conec2.createStatement();
													 st2.executeUpdate(Query4);
													 JOptionPane.showMessageDialog(Formulario.this, "Reserva realizada");
										        	
										        }else {
													//insertamos solo reserva funciona

													 Connection conec=(Connection) conexion.MySQLConnect();
													 String Query = "INSERT INTO "+NombreDB+"(id, nombre, telefono, correo, turno, numero, fecha, Estado,id_cliente) VALUES (NULL,'"+nombre+"','"+telefono+"','"+correo+"','"+turno+"','"+numCli+"','"+fechaComoCadena+"','Espera','"+telefono+"')";										
													 Statement st=conec.createStatement();
													 st.executeUpdate(Query);
													 JOptionPane.showMessageDialog(Formulario.this, "Reserva realizada");
												}
										
												
//										       

												}else {
													//aqui cuando la reserva se rechaza por lleno
													 if (existe==false) {
															//creamos cliente y reserva
												        	
														 Connection conec=(Connection) conexion.MySQLConnect();
														 String Query = "INSERT INTO "+NombreDBC+"(id, usuario, Contraseña) VALUES (NULL,'"+telefono+"','"+correo+"')";										
														 Statement st=conec.createStatement();
														 st.executeUpdate(Query);
														 
														 JOptionPane.showMessageDialog(Formulario.this, "Creamos usuario");

														 Connection conec2=(Connection) conexion.MySQLConnect();
														 String Query4 = "INSERT INTO "+NombreDB+"(id, nombre, telefono, correo, turno, numero, fecha, Estado, id_cliente) VALUES (NULL,'"+nombre+"','"+telefono+"','"+correo+"','"+turno+"','"+numCli+"','"+fechaComoCadena+"','LLeno','"+telefono+"')";									
														 Statement st2=conec.createStatement();
														 st.executeUpdate(Query4);
														 JOptionPane.showMessageDialog(Formulario.this, "No hay sufiente espacio en el restaurante seleccione otro turno o dia");
											        	
												      }else {
															//insertamos solo reserva

											        	 Connection conec=(Connection) conexion.MySQLConnect();
														 String Query = "INSERT INTO "+NombreDB+"(id, nombre, telefono, correo, turno, numero, fecha, Estado,id_cliente) VALUES (NULL,'"+nombre+"','"+telefono+"','"+correo+"','"+turno+"','"+numCli+"','"+fechaComoCadena+"','LLeno','"+telefono+"')";									
														 Statement st=conec.createStatement();
														 st.executeUpdate(Query);
														 JOptionPane.showMessageDialog(Formulario.this, "No hay sufiente espacio en el restaurante seleccione otro turno o dia");
												        }
													
													 
												}
																					
											} catch (SQLException ex) {
												// TODO Auto-generated catch block
												ex.printStackTrace();
								        	
								        }
						
									
									 
								}else{JOptionPane.showMessageDialog(Formulario.this, "Error de formato en la fecha recuerda que es dd-MM-yyyy");}								
							}else{JOptionPane.showMessageDialog(Formulario.this, "Error de formato en el numero de personas recuerda que debe ser un numero");}
						}else{JOptionPane.showMessageDialog(Formulario.this, "Error de formato en el numero de telefono recuerda que debe ser un numero");}						
					}else{JOptionPane.showMessageDialog(Formulario.this, "Error de formato en el correo");}
					
					
					
					
					
					
				
					
					
					
					
				}
				private void CreaCliente(String Query) throws SQLException {
					// TODO Auto-generated method stub
					Conexion  db= new Conexion();
					db.MySQLConnect();
					db.comando = db.conexion.createStatement();
					db.comando.executeUpdate(Query);
				
				
					
				}
				private boolean ClienteQuery(String query3, String telefono) throws SQLException {
					//Comprobamos si existe cierto usuario
					Conexion  db= new Conexion();
					db.MySQLConnect();
					db.comando = db.conexion.createStatement();
					db.registro = db.comando.executeQuery(query3);
					String resultado=String.valueOf(db.registro);
					while(db.registro.next()) {
						resultado=db.registro.getString(1);
						System.out.println("?" +resultado);
					}
					if(resultado.equalsIgnoreCase(telefono)){
						return true;
					}
					if (resultado!=telefono) {
						return false;
					}
					// TODO Auto-generated method stub
					return true;
					
				}
				private String NumPersonasQuery(String Query2) throws SQLException {
					//Comprobamos el numero de personas cierto dia
					Conexion  db= new Conexion();
					db.MySQLConnect();
					db.comando = db.conexion.createStatement();
					db.registro = db.comando.executeQuery(Query2);
					String resultado=String.valueOf(db.registro);
					while(db.registro.next()) {
						resultado=db.registro.getString(1);
						System.out.println(resultado);
					}
					if (resultado==null) {
						return "0";
					}else {
						return resultado;
					}
					
					// TODO Auto-generated method stub
					
				}
				private boolean Fecha(String fecha) {
					// TODO Auto-generated method stub
					/* COmprueba si date es null */
					if (fecha.trim().equals(""))
					{
					    return false;
					}
					/* Si date no es null */
					else
					{
					    /*
					   
					     *  MM-dd-yyyy, MM.dd.yyyy,dd.MM.yyyy etc.*/
					    SimpleDateFormat sdfrmt = new SimpleDateFormat("dd-MM-yyyy");
					    sdfrmt.setLenient(false);
					     /* cambiamos el formato de Sting a date  */
					    try
					    {
					        Date javaDate = sdfrmt.parse(fecha); 
					        System.out.println(fecha+" is valid date format");
					    }
					    /* Date format es invalido */
					    catch (ParseException e)
					    {
					        System.out.println(fecha+" is Invalid Date format");
					        return false;
					    }
					    /* Devuelve true si es valido */
					    return true;
					}
				}
				//Comprobamos que los valores sean numeriscos
				private boolean Numeros(String valores) {
					// TODO Auto-generated method stub
					
					boolean Numerico = (valores != null && valores.matches("[0-9]+"));
			       
				
					return Numerico;
				}
			});
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new Menu().setVisible(true);
					
				}
			});
			
			JLabel lblNewLabel_6 = new JLabel("El Palacio");
			lblNewLabel_6.setFont(new Font("Trebuchet MS", Font.PLAIN, 40));
			lblNewLabel_6.setBounds(330, 11, 208, 49);
			panel.add(lblNewLabel_6);
		}
		
		private String CambiaFecha(String fecha) {
			// Metodo para cambiar el formato del a fecha y poder hacer insert en la BBDD
			 SimpleDateFormat sdfrmt = new SimpleDateFormat("dd-MM-yyyy");
			 Date javaDate=null;
			 try {
				javaDate = sdfrmt.parse(fecha);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
	        System.out.println("Original Date: "+javaDate);
	 
	        // Specify format as "yyyy-MM-dd"
	        SimpleDateFormat dmyFormat = new SimpleDateFormat("yyyy-MM-dd");
	 
	        // Use format method on SimpleDateFormat
	        String formattedDateStr = dmyFormat.format(javaDate);
	        System.out.println("Formatted Date in String format: "+formattedDateStr);
			return formattedDateStr;
		}
}