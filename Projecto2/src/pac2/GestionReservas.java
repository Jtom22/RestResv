package pac2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.AddressException;

import java.awt.FlowLayout;
import java.awt.TextArea;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.PrintStream;

import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.Dimension;
import java.awt.Font;

public class GestionReservas extends JFrame {

	private JPanel contentPane;
	private JTextField buscador_txt;
	private JTextField textField;
	
	int Opcion;
	int Turno=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionReservas frame = new GestionReservas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param i 
	 */
	public GestionReservas() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 601);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 874, 35);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Gestion de reservas");
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setMinimumSize(new Dimension(150, 100));
		panel_1.setBounds(10, 43, 864, 508);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		//textArea.setBounds(35, 48, 500, 253);
		//panel_1.add(textArea);
		
		
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Boton para volver al menu
				dispose();
	      		new Menu().setVisible(true);
			}
		});
		btnNewButton.setBounds(415, 441, 125, 39);
		panel_1.add(btnNewButton);
		
		buscador_txt = new JTextField();
		buscador_txt.setBounds(115, 25, 112, 28);
		panel_1.add(buscador_txt);
		buscador_txt.setColumns(10);
		
		JLabel FechaBuscador = new JLabel("Fecha:");
		FechaBuscador.setBounds(56, 25, 59, 23);
		panel_1.add(FechaBuscador);
		
		JLabel turnoBuscador = new JLabel("Turno:");
		turnoBuscador.setBounds(342, 28, 52, 23);
		panel_1.add(turnoBuscador);
		
		JLabel estadoBuscador = new JLabel("Estado");
		estadoBuscador.setBounds(658, 25, 65, 28);
		panel_1.add(estadoBuscador);
		
		
		
		JComboBox comboBox_estado = new JComboBox();
		comboBox_estado.setBounds(725, 25, 94, 26);
		comboBox_estado.addItem("Espera");
		comboBox_estado.addItem("Lleno");
		comboBox_estado.addItem("Cancelado");
		comboBox_estado.addItem("Aceptada");
		comboBox_estado.addItem("ALL");
		
		panel_1.add(comboBox_estado);
		
		
		JComboBox comboBox_Turno = new JComboBox();
		comboBox_Turno.setBounds(388, 25, 112, 28);
		comboBox_Turno.addItem("1");
		comboBox_Turno.addItem("2");
		comboBox_Turno.addItem("ALL");
		
		
		
		panel_1.add(comboBox_Turno);
		
		
		
		
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 71, 793, 347);
		//scrollPane.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
		panel_1.add(scrollPane);
		
		

		JList list = new JList();
		list.setMaximumSize(new Dimension(30, 28));
		list.setFont(new Font("Tahoma", Font.PLAIN, 18));
		list.setBounds(43, 71, 793, 347);
		scrollPane.setViewportView(list);
		//panel_1.add(list);
		scrollPane.setViewportView(list);
		
		
		JButton buscaFecha = new JButton("Busca");
		buscaFecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//comboBox_estado.setSelectedIndex(4);
				//comboBox_Turno.setSelectedIndex(2);
				String fecha=buscaFecha.getText();
				if (buscador_txt.getText().equalsIgnoreCase("")) {
					Todas(list,buscador_txt.getText());
					
					
					
				}else {
					buscaFecha(list,buscador_txt.getText());
					 scrollPane.setViewportView(list);
					
				}
				
				
				
				
			}
		});
		buscaFecha.setBounds(227, 25, 32, 28);
		panel_1.add(buscaFecha);
		
		
		
		comboBox_Turno.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev) {
				comboBox_estado.setSelectedIndex(4);
				//Seleccionamos a modo de filtro cual es el turno que buscamos mostrar tiene menos prioridad que la fecha
				 switch (comboBox_Turno.getSelectedIndex()){
				case 0: {
					Turno=comboBox_Turno.getSelectedIndex()+1;
					System.out.println(Turno);
					Turno1(list, buscador_txt.getText());
			
					
					break;
				}case 1:{
					Turno=comboBox_Turno.getSelectedIndex()+1;
					Turno2(list, buscador_txt.getText());
					
					break;
				}case 2:{
					Turno=0;
					Todas(list,buscador_txt.getText());
					
					
				break;
				}default:
					throw new IllegalArgumentException("Unexpected value: " + comboBox_Turno.getSelectedIndex());
				}
				 scrollPane.setViewportView(list);
				 
				
			}
		});
		
		
		comboBox_estado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Seleccionamos a modo de filtro cual es el estado que buscamos mostrar tiene menos prioridad que el turno
				switch (comboBox_estado.getSelectedIndex()) {
				case 0: {
					espera(list,buscador_txt.getText());
					scrollPane.setViewportView(list);

					break;
				
				}case 1: {
					lleno(list,buscador_txt.getText());
					
					scrollPane.setViewportView(list);
					break;
				}case 2: {
					cancelada(list,buscador_txt.getText());
					scrollPane.setViewportView(list);
					break;
				}
				case 3: {
					aceptada(list,buscador_txt.getText());
					scrollPane.setViewportView(list);
					break;
				}case 4: {
					Todas(list,buscador_txt.getText());
					scrollPane.setViewportView(list);
					break;
				}
				default:
					//espera(list);
					scrollPane.setViewportView(list);
				}
			}

			
			
		});
		
		
		JButton CancelarReserva = new JButton("Cancelar reserva");
		CancelarReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//cogemos la lista que se muestra en pantalla y cambiamos el estado de los seleccionados
				int tamaño=list.getSelectedValuesList().size();
				String b[] = new String[tamaño];
				list.getSelectedValuesList().toArray(b);							
				for (int i =0;i<tamaño ;i++) {				
					Cancelar(b[i].toString());			
				}	
			
			}
		});
		CancelarReserva.setBounds(153, 441, 138, 39);
		panel_1.add(CancelarReserva);
		
		
		
		JButton esperaBoton = new JButton("Espera");
		esperaBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//cogemos la lista que se muestra en pantalla y cambiamos el estado de los seleccionados
				int tamaño=list.getSelectedValuesList().size();
				String b[] = new String[tamaño];
				list.getSelectedValuesList().toArray(b);							
				for (int i =0;i<tamaño ;i++) {				
					Esperar(b[i].toString());			
				}	
				
				
				
			}
		});
		esperaBoton.setBounds(290, 441, 125, 39);
		panel_1.add(esperaBoton);
		
		JButton enviarMail = new JButton("Avisar");
		enviarMail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//cogemos la lista que se muestra en pantalla y mandamos un correo a los seleccionados
				int tamaño=list.getSelectedValuesList().size();
				String b[] = new String[tamaño];
				list.getSelectedValuesList().toArray(b);							
				for (int i =0;i<tamaño ;i++) {				
				
					EnviarCorreo(b[i].toString());
								
				}
				
				
				
				
				
			}
		});
		enviarMail.setBounds(539, 441, 125, 39);
		panel_1.add(enviarMail);


		
	
		
		
		
	}

	

	protected void EnviarCorreo(String string){
		// TODO Auto-generated method stub
		String idReserva="";
		String Correo="";
		Conexion db = new Conexion();
        db.MySQLConnect();
        String valor[]= string.split(" ");
        
        for (int i = 0;i<valor.length;i++) {
        	//System.out.println(valor[i]+" "+i);
			
			if (i==11) {
				System.out.println(valor[i]);
				idReserva=valor[i];
				
				  
				      
			}else if(i==15) {
				System.out.println(valor[i]+" "+i);
				Correo=valor[i];  
		
			}else {
				
			}
			try {
				JavaMailUtil.sendMail(idReserva,Correo);
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
		
	}

	protected void Cancelar(String string) {
		// El string que nos llega del metodo comprobamos que el estado es Aceptada y dividimos el string donde esta el idReserva para saber a que reserva nos referimos
		try {
			String idReserva="";
			Conexion db = new Conexion();
	        db.MySQLConnect();
	        String valor[]= string.split(" ");
	        
	        for (int i = 0;i<valor.length;i++) {
	        	
				
				if (i==11) {
					System.out.println(valor[i]);
					idReserva=valor[i];
					
					  if (string.contains("Aceptada")) {
						  String Query="Update reservas set Estado = 'Cancelada' where id="+ idReserva;
						  db.comando = db.conexion.createStatement();
						  //db.registro = db.comando.executeUpdate(Query);
						  int value = db.comando.executeUpdate(Query);
					      
					    // System.out.println(value);
					      
					  }else {
						  
					  }
				}
				
			}

			
			
		} catch (SQLException ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
		
		
		
	}
	protected void Esperar(String string) {
		// El string que nos llega del metodo comprobamos que el estado es Cancelada y dividimos el string donde esta el idReserva para saber a que reserva nos referimos
		try {
			String idReserva="";
			Conexion db = new Conexion();
	        db.MySQLConnect();
	        String valor[]= string.split(" ");
	        
	        for (int i = 0;i<valor.length;i++) {
	        	
				
				if (i==11) {
					System.out.println(valor[i]);
					idReserva=valor[i];
					 if (string.contains("Cancelada")) {
						  String Query="Update reservas set Estado = 'Espera' where id="+ idReserva;
						  db.comando = db.conexion.createStatement();
						  //db.registro = db.comando.executeUpdate(Query);
						  int value = db.comando.executeUpdate(Query);
					      
					    // System.out.println(value);
					      
					  }else {
						  
					  }
				}
				
			}

			 
			
		} catch (SQLException ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
		
		
		
	}
	

	protected void buscaFecha(JList lista,String fecha) {
		//Metodo para buscar las reservas un dia concreto
	try {
			
			String fechaCad=CambiaFecha(fecha);
			Conexion db = new Conexion();
	        db.MySQLConnect();
	        String NombreDB = "reservas";
	        String Query;
	        
	        if (Fecha(fecha)==true) {
	        	
					
			  //Query= "SELECT * FROM " + NombreDB +" WHERE Fecha = '1970-01-01'";
	        	//System.out.println(fechaCad);
			Query= "SELECT * FROM " + NombreDB +" WHERE `fecha`= '"+fechaCad+"'";
		        
			
		      
		        db.comando = db.conexion.createStatement();
		        db.registro = db.comando.executeQuery(Query);
		        DefaultListModel DLM = new DefaultListModel();
		        lista.setModel(DLM);
		        TextArea textarea = new TextArea(); 
		        	while (db.registro.next()) {
		        		String info=(	                        
		                        "\n Turno: " + db.registro.getString(5) +
		                        "\n Nº Personas: " + db.registro.getString(6) +
		                        "\n Fecha: " + db.registro.getString(7) +
		                        "\n Estado: " + db.registro.getString(8)+
		                        "\n IdReserva: " + db.registro.getString(1)+
		                        "\n IdCliente: " + db.registro.getString(9)+
		                        "\n Correo: " + db.registro.getString(3));		 
		        		DLM.addElement(info); 
		        		lista.setModel(DLM);
		        		//lista.add(DLM);
		        	}
					
			
				
			}else {
				Query= "SELECT * FROM " + NombreDB ;
		        
				
			      
		        db.comando = db.conexion.createStatement();
		        db.registro = db.comando.executeQuery(Query);
		        DefaultListModel DLM = new DefaultListModel();
		        lista.setModel(DLM);
		        TextArea textarea = new TextArea(); 
		        	while (db.registro.next()) {
		        		String info=(	                        
		                        "\n Turno: " + db.registro.getString(5) +
		                        "\n Nº Personas: " + db.registro.getString(6) +
		                        "\n Fecha: " + db.registro.getString(7) +
		                        "\n Estado: " + db.registro.getString(8)+
		                        "\n IdCliente: " + db.registro.getString(9)+
		                        "\n Correo: " + db.registro.getString(3));		 
		        		DLM.addElement(info); 
		        		lista.setModel(DLM);
		        		//lista.add(DLM);
		        	}

			}
	       
	       
	        	
		}catch (SQLException ex) {
			ex.printStackTrace();
	        }
		
		
		
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

	private void espera(JList lista,String fecha) {
		// Metodo que nos muestra las reservas cuyo estado e s espera
		try {
			if (Fecha(fecha)==true) {
				Conexion db = new Conexion();
		        db.MySQLConnect();
		        String fechaCad=CambiaFecha(fecha);
		        String NombreDB = "reservas";
		        String Query;
		        if (Turno==0) {
		        	 Query= "SELECT * FROM " + NombreDB +" WHERE `Estado` = 'Espera' AND `fecha`= '"+fechaCad+"'";
			        
				}else {
					   Query = "SELECT * FROM " + NombreDB +" WHERE `Turno` ="+Turno+" AND `Estado` = 'Espera' AND `fecha`= '"+fechaCad+"'";
				}
		      
		        db.comando = db.conexion.createStatement();
		        db.registro = db.comando.executeQuery(Query);
		        DefaultListModel DLM = new DefaultListModel();
		        lista.setModel(DLM);
		        TextArea textarea = new TextArea(); 
		        	while (db.registro.next()) {
		        		String info=(	                        
		                        "\n Turno: " + db.registro.getString(5) +
		                        "\n Nº Personas: " + db.registro.getString(6) +
		                        "\n Fecha: " + db.registro.getString(7) +
		                        "\n Estado: " + db.registro.getString(8)+
		                        "\n IdReserva: " + db.registro.getString(1)+
		                        "\n IdCliente: " + db.registro.getString(9)+
		                        "\n Correo: " + db.registro.getString(3));		 
		        		DLM.addElement(info); 
		        		lista.setModel(DLM);
		        		//lista.add(DLM);
		        	}
		        		
			}else {
				
			
			
			Conexion db = new Conexion();
	        db.MySQLConnect();
	        String NombreDB = "reservas";
	        String Query;
	        if (Turno==0) {
	        	 Query= "SELECT * FROM " + NombreDB +" WHERE `Estado` = 'Espera'";
		        
			}else {
				   Query = "SELECT * FROM " + NombreDB +" WHERE `Turno` ="+Turno+" AND `Estado` = 'Espera'";
			}
	      
	        db.comando = db.conexion.createStatement();
	        db.registro = db.comando.executeQuery(Query);
	        DefaultListModel DLM = new DefaultListModel();
	        lista.setModel(DLM);
	        TextArea textarea = new TextArea(); 
	        	while (db.registro.next()) {
	        		String info=(	                        
	                        "\n Turno: " + db.registro.getString(5) +
	                        "\n Nº Personas: " + db.registro.getString(6) +
	                        "\n Fecha: " + db.registro.getString(7) +
	                        "\n Estado: " + db.registro.getString(8)+
	                        "\n IdReserva: " + db.registro.getString(1)+
	                        "\n IdCliente: " + db.registro.getString(9)+
	                        "\n Correo: " + db.registro.getString(3));	 
	        		DLM.addElement(info); 
	        		lista.setModel(DLM);
	        		//lista.add(DLM);
	        	}
			}
	        	
		}catch (SQLException ex) {
			ex.printStackTrace();
	        }
		
		
	}
	private void cancelada(JList lista, String fecha) {
		// Metodo que nos muestrta las reservas cuyo estado es cancelada
		try {
			if (Fecha(fecha)==true) {
				Conexion db = new Conexion();
		        db.MySQLConnect();
		        String fechaCad=CambiaFecha(fecha);
		        String NombreDB = "reservas";
		        String Query ;
		        if (Turno==0) {
		        	 Query= "SELECT * FROM " + NombreDB +" WHERE `Estado` = 'Cancelada' AND `fecha`= '"+fechaCad+"'";
			        
				}else {
					   Query = "SELECT * FROM " + NombreDB +" WHERE `Turno` ="+Turno+" AND `Estado` = 'Cancelada' AND `fecha`= '"+fechaCad+"'";
				}
		        db.comando = db.conexion.createStatement();
		        db.registro = db.comando.executeQuery(Query);
		        DefaultListModel DLM = new DefaultListModel();
		        lista.setModel(DLM);
		        TextArea textarea = new TextArea(); 
		        	while (db.registro.next()) {
		        		String info=(	                        
		                        "\n Turno: " + db.registro.getString(5) +
		                        "\n Nº Personas: " + db.registro.getString(6) +
		                        "\n Fecha: " + db.registro.getString(7) +
		                        "\n Estado: " + db.registro.getString(8)+
		                        "\n IdReserva: " + db.registro.getString(1)+
		                        "\n IdCliente: " + db.registro.getString(9)+
		                        "\n Correo: " + db.registro.getString(3));		 
		        		DLM.addElement(info); 
		        		lista.setModel(DLM);
		        		//lista.add(DLM);
		        	}
			}else {
				
			
				Conexion db = new Conexion();
		        db.MySQLConnect();
		        String NombreDB = "reservas";
		        String Query ;
		        if (Turno==0) {
		        	 Query= "SELECT * FROM " + NombreDB +" WHERE `Estado` = 'Cancelada'";
			        
				}else {
					   Query = "SELECT * FROM " + NombreDB +" WHERE `Turno` ="+Turno+" AND `Estado` = 'Cancelada'";
				}
		        db.comando = db.conexion.createStatement();
		        db.registro = db.comando.executeQuery(Query);
		        DefaultListModel DLM = new DefaultListModel();
		        lista.setModel(DLM);
		        TextArea textarea = new TextArea(); 
		        	while (db.registro.next()) {
		        		String info=(	                        
		                        "\n Turno: " + db.registro.getString(5) +
		                        "\n Nº Personas: " + db.registro.getString(6) +
		                        "\n Fecha: " + db.registro.getString(7) +
		                        "\n Estado: " + db.registro.getString(8)+
		                        "\n IdReserva: " + db.registro.getString(1)+
		        				"\n IdCliente: " + db.registro.getString(9)+
		        				"\n Correo: " + db.registro.getString(3));	 
		        		DLM.addElement(info); 
		        		lista.setModel(DLM);
		        		//lista.add(DLM);
	        	}
			}
	        	
		}catch (SQLException ex) {
			ex.printStackTrace();
	    }
	}
	private void lleno(JList lista, String fecha) {
		// Metodo que nos muestra las reservas cuyo estado es lleno
		try {
			if (Fecha(fecha)==true) {
				Conexion db = new Conexion();
		        db.MySQLConnect();
		        String fechaCad=CambiaFecha(fecha);
		        String NombreDB = "reservas";
		        String Query ;
		        if (Turno==0) {
		        	 Query= "SELECT * FROM " + NombreDB +" WHERE `Estado` = 'Lleno' AND `fecha`= '"+fechaCad+"'";
			        
				}else {
					   Query = "SELECT * FROM " + NombreDB +" WHERE `Turno` ="+Turno+" AND `Estado` = 'Lleno' AND `fecha`= '"+fechaCad+"'";
				}
		        db.comando = db.conexion.createStatement();
		        db.registro = db.comando.executeQuery(Query);
		        DefaultListModel DLM = new DefaultListModel();
		        lista.setModel(DLM);
		        TextArea textarea = new TextArea(); 
		        	while (db.registro.next()) {
		        		String info=(	                        
		                        "\n Turno: " + db.registro.getString(5) +
		                        "\n Nº Personas: " + db.registro.getString(6) +
		                        "\n Fecha: " + db.registro.getString(7) +
		                        "\n Estado: " + db.registro.getString(8)+
		                        "\n IdReserva: " + db.registro.getString(1)+
		                        "\n IdCliente: " + db.registro.getString(9)+
		                        "\n Correo: " + db.registro.getString(3));	 
		        		DLM.addElement(info); 
		        		lista.setModel(DLM);
		        		//lista.add(DLM);
		        	}
				
			}else {
				
			
				Conexion db = new Conexion();
		        db.MySQLConnect();
		        String NombreDB = "reservas";
		        String Query ;
		        if (Turno==0) {
		        	 Query= "SELECT * FROM " + NombreDB +" WHERE `Estado` = 'Lleno'";
			        
				}else {
					   Query = "SELECT * FROM " + NombreDB +" WHERE `Turno` ="+Turno+" AND `Estado` = 'Lleno'";
				}
		        db.comando = db.conexion.createStatement();
		        db.registro = db.comando.executeQuery(Query);
		        DefaultListModel DLM = new DefaultListModel();
		        lista.setModel(DLM);
		        TextArea textarea = new TextArea(); 
		        	while (db.registro.next()) {
		        		String info=(	                        
		                        "\n Turno: " + db.registro.getString(5) +
		                        "\n Nº Personas: " + db.registro.getString(6) +
		                        "\n Fecha: " + db.registro.getString(7) +
		                        "\n Estado: " + db.registro.getString(8)+
		                        "\n IdReserva: " + db.registro.getString(1)+
		                        "\n IdCliente: " + db.registro.getString(9)+
		                        "\n Correo: " + db.registro.getString(3));		 
		        		DLM.addElement(info); 
		        		lista.setModel(DLM);
		        		//lista.add(DLM);
		        	}
			}
	        	
		}catch (SQLException ex) {
			ex.printStackTrace();
	    }
	}
	
	private void aceptada(JList lista, String fecha) {
		// Metodo que nos muestra las reservas cuyo estado es aceptada
		try {
			if (Fecha(fecha)==true) {

				Conexion db = new Conexion();
		        db.MySQLConnect();
		        String fechaCad=CambiaFecha(fecha);
		        String NombreDB = "reservas";
		        String Query;
		        
		        if (Turno==0) {
		        	 Query= "SELECT * FROM " + NombreDB +" WHERE `Estado` = 'Aceptada' AND `fecha`= '"+fechaCad+"'";
			        
				}else {
					   Query = "SELECT * FROM " + NombreDB +" WHERE `Turno` ="+Turno+" AND `Estado` = 'Aceptada' AND `fecha`= '"+fechaCad+"'";
				}
		        db.comando = db.conexion.createStatement();
		        db.registro = db.comando.executeQuery(Query);
		        DefaultListModel DLM = new DefaultListModel();
		        lista.setModel(DLM);
		        TextArea textarea = new TextArea(); 
		        
		        	while (db.registro.next()) {
		        		String info=(	                        
		                        "\n Turno: " + db.registro.getString(5) +
		                        "\n Nº Personas: " + db.registro.getString(6) +
		                        "\n Fecha: " + db.registro.getString(7) +
		                        "\n Estado: " + db.registro.getString(8)+
		                        "\n IdReserva: " + db.registro.getString(1)+
		                        "\n IdCliente: " + db.registro.getString(9)+
		                        "\n Correo: " + db.registro.getString(3));		 
		        		DLM.addElement(info); 
		        		lista.setModel(DLM);
		        	}
				
			}else {
				
			Conexion db = new Conexion();
	        db.MySQLConnect();
	        String NombreDB = "reservas";
	        String Query;
	        
	        if (Turno==0) {
	        	 Query= "SELECT * FROM " + NombreDB +" WHERE `Estado` = 'Aceptada'";
		        
			}else {
				 Query = "SELECT * FROM " + NombreDB +" WHERE `Turno` ="+Turno+" AND `Estado` = 'Aceptada'";
			}
	        db.comando = db.conexion.createStatement();
	        db.registro = db.comando.executeQuery(Query);
	        DefaultListModel DLM = new DefaultListModel();
	        lista.setModel(DLM);
	        TextArea textarea = new TextArea(); 
	        
	        	while (db.registro.next()) {
	        		String info=(	                        
	                        "\n Turno: " + db.registro.getString(5) +
	                        "\n Nº Personas: " + db.registro.getString(6) +
	                        "\n Fecha: " + db.registro.getString(7) +
	                        "\n Estado: " + db.registro.getString(8)+
	                        "\n IdReserva: " + db.registro.getString(1)+
	                        "\n IdCliente: " + db.registro.getString(9)+
	                        "\n Correo: " + db.registro.getString(3));		 
	        		DLM.addElement(info); 
	        		lista.setModel(DLM);
	        		//lista.add(DLM);
	        	}
			}
		}catch (SQLException ex) {
			ex.printStackTrace();
	    }
	}
	
	private void Turno1(JList list, String fecha) {
		// Metodo que nos muestra las reservas cuyo turno es 1
		try {
			
			if(Fecha(fecha)==true) {
				Conexion db = new Conexion();
		        db.MySQLConnect();
		        String fechaCad=CambiaFecha(fecha);
		        String NombreDB = "reservas";
		        String Query = "SELECT * FROM " + NombreDB +" WHERE `turno` = '1' AND `fecha`= '"+fechaCad+"'";
		        db.comando = db.conexion.createStatement();
		        db.registro = db.comando.executeQuery(Query);
		        DefaultListModel DLM = new DefaultListModel();
		        list.setModel(DLM);
		        TextArea textarea = new TextArea(); 
		        	while (db.registro.next()) {
		        		String info=(	                        
		                        "\n Turno: " + db.registro.getString(5) +
		                        "\n Nº Personas: " + db.registro.getString(6) +
		                        "\n Fecha: " + db.registro.getString(7) +
		                        "\n Estado: " + db.registro.getString(8)+
		                        "\n IdReserva: " + db.registro.getString(1)+
		                        "\n IdCliente: " + db.registro.getString(9)+
		                        "\n Correo: " + db.registro.getString(3));		 
		        		DLM.addElement(info); 
		        		list.setModel(DLM);
		        	}
		        		
		        		
		        		
			}else {
			Conexion db = new Conexion();
	        db.MySQLConnect();
	        String NombreDB = "reservas";
	        String Query = "SELECT * FROM " + NombreDB +" WHERE `turno` = '1'";
	        db.comando = db.conexion.createStatement();
	        db.registro = db.comando.executeQuery(Query);
	        DefaultListModel DLM = new DefaultListModel();
	        list.setModel(DLM);
	        TextArea textarea = new TextArea(); 
	        	while (db.registro.next()) {
	        		String info=(	                        
	                        "\n Turno: " + db.registro.getString(5) +
	                        "\n Nº Personas: " + db.registro.getString(6) +
	                        "\n Fecha: " + db.registro.getString(7) +
	                        "\n Estado: " + db.registro.getString(8)+
	                        "\n IdReserva: " + db.registro.getString(1)+
	                        "\n IdCliente: " + db.registro.getString(9)+
	        				"\n Correo: " + db.registro.getString(3));		 
	        		DLM.addElement(info); 
	        		list.setModel(DLM);
	        		
	        		
	        		
	        		//lista.add(DLM);
	        	}
			}
	        	
		}catch (SQLException ex) {
			ex.printStackTrace();
	    }
	}
	private void Turno2(JList list, String fecha)  {
		// Metodo que nos muestra las reservas cuyo turno es 2
		try {	
			if(Fecha(fecha)==true) {
					
					
					Conexion db = new Conexion();
			        db.MySQLConnect();
			        String NombreDB = "reservas";
			        String fechaCad=CambiaFecha(fecha);
			        String Query = "SELECT * FROM " + NombreDB +" WHERE `turno` = '2' AND `fecha`= '"+fechaCad+"'";
			        db.comando = db.conexion.createStatement();
			        db.registro = db.comando.executeQuery(Query);
			        DefaultListModel DLM = new DefaultListModel();
			        list.setModel(DLM);
			        TextArea textarea = new TextArea(); 
			        	while (db.registro.next()) {
			        		String info=(	                        
			                        "\n Turno: " + db.registro.getString(5) +
			                        "\n Nº Personas: " + db.registro.getString(6) +
			                        "\n Fecha: " + db.registro.getString(7) +
			                        "\n Estado: " + db.registro.getString(8)+
			                        "\n IdReserva: " + db.registro.getString(1)+
			                        "\n IdCliente: " + db.registro.getString(9)+
			                        "\n Correo: " + db.registro.getString(3));		 
			        		DLM.addElement(info); 
			        		list.setModel(DLM);
			        		
			        		//lista.add(DLM);
			        	}
			        	
				
			}else {
				Conexion db = new Conexion();
		        db.MySQLConnect();
		        String NombreDB = "reservas";
		        String Query = "SELECT * FROM " + NombreDB +" WHERE `turno` = '2' ";
		        db.comando = db.conexion.createStatement();
		        db.registro = db.comando.executeQuery(Query);
		        DefaultListModel DLM = new DefaultListModel();
		        list.setModel(DLM);
		        TextArea textarea = new TextArea(); 
		        	while (db.registro.next()) {
		        		String info=(	                        
		                        "\n Turno: " + db.registro.getString(5) +
		                        "\n Nº Personas: " + db.registro.getString(6) +
		                        "\n Fecha: " + db.registro.getString(7) +
		                        "\n Estado: " + db.registro.getString(8)+
		                        "\n IdReserva: " + db.registro.getString(1)+
		                        "\n IdCliente: " + db.registro.getString(9)+
		                        "\n Correo: " + db.registro.getString(3));		 
		        		DLM.addElement(info); 
		        		list.setModel(DLM);
		        		
		        		//lista.add(DLM);
		        	}
			}
		}catch (SQLException ex) {
			ex.printStackTrace();
	    }
	}
	private void Todas(JList list, String fecha) {
		//Metodo que nos muestra todas las reservas en la base de datos teniendo en cuenta el textArea de las fechas
		try {
			if (Fecha(fecha)) {
				Conexion db = new Conexion();
		        db.MySQLConnect();
		        SimpleDateFormat sdfrmt = new SimpleDateFormat("dd-MM-yyyy");
		        String fechaCad=CambiaFecha(fecha);

		        String NombreDB = "reservas";
		        String Query= "SELECT * FROM " + NombreDB +" WHERE `fecha`= '"+fechaCad+"'";
		        
		        db.comando = db.conexion.createStatement();
		        db.registro = db.comando.executeQuery(Query);
		        DefaultListModel DLM = new DefaultListModel();
		        list.setModel(DLM);
		        TextArea textarea = new TextArea(); 
		        	while (db.registro.next()) {
		        		String info=(	                        
		                        "\n Turno: " + db.registro.getString(5) +
		                        "\n Nº Personas: " + db.registro.getString(6) +
		                        "\n Fecha: " + db.registro.getString(7) +
		                        "\n Estado: " + db.registro.getString(8)+
		                        "\n IdReserva: " + db.registro.getString(1)+
		                        "\n IdCliente: " + db.registro.getString(9)+
		                        "\n Correo: " + db.registro.getString(3));	 
		        		DLM.addElement(info); 
		        		list.setModel(DLM);
		        		
		        		//lista.add(DLM);
		        	}
		        	
		        
			}else {
				Conexion db = new Conexion();
		        db.MySQLConnect();
		        String NombreDB = "reservas";
		        String Query = "SELECT * FROM " + NombreDB ;
		        db.comando = db.conexion.createStatement();
		        db.registro = db.comando.executeQuery(Query);
		        DefaultListModel DLM = new DefaultListModel();
		        list.setModel(DLM);
		        TextArea textarea = new TextArea(); 
		        	while (db.registro.next()) {
		        		String info=(	                        
		                        "\n Turno: " + db.registro.getString(5) +
		                        "\n Nº Personas: " + db.registro.getString(6) +
		                        "\n Fecha: " + db.registro.getString(7) +
		                        "\n Estado: " + db.registro.getString(8)+
		                        "\n IdReserva: " + db.registro.getString(1)+
		                        "\n IdCliente: " + db.registro.getString(9)+
		                        "\n Correo: " + db.registro.getString(3));	 
		        		DLM.addElement(info); 
		        		list.setModel(DLM);
		        		
		        		//lista.add(DLM);
		        	}
		        	
			}
			
			
		}catch (SQLException ex) {
			ex.printStackTrace();
	    }
	}
	private boolean Fecha(String fecha) {
		// Metodo para comprobar si una fecha es valida
		/* Comprueba si la fecha es null */
		if (fecha.trim().equals(""))
		{
		    return false;
		}
		/*Si no es null */
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
}
