package pac2;
//import required classes and packages  
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.awt.event.ActionEvent;  

//create NewPage class to create a new page on which user will navigate  
class Menu extends JFrame  
{
  //constructor  
  Menu()  
  {
  	setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/Imagenes/IconoRestaurante.png")));
  	setAlwaysOnTop(true);  
     
      this.setLocationRelativeTo(null);   
      setBounds(100, 100, 816, 593);
      getContentPane().setLayout(null);
      ((JComponent) getContentPane()).setBorder(new EmptyBorder(5, 5, 5, 5));

      
      JPanel panel = new JPanel();
      panel.setBackground(new Color(255, 255, 255));
      panel.setBounds(0, 66, 489, 488);
      getContentPane().add(panel);
      panel.setLayout(null);
      
      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBounds(10, 11, 469, 466);
      panel.add(scrollPane);
      
      JTextArea textArea = new JTextArea();
      textArea.setEditable(false);
      MuestraAceptadas(textArea);
      scrollPane.setViewportView(textArea);
      
      
      
      
      JPanel panel_1 = new JPanel();
      panel_1.setBounds(489, 66, 311, 488);
      getContentPane().add(panel_1);
      panel_1.setLayout(new GridLayout(0, 1, 0, 0));
      
      JButton btnNewButton = new JButton("Crear reserva");
      btnNewButton.setForeground(Color.WHITE);
      btnNewButton.setBackground(Color.DARK_GRAY);
     
      btnNewButton.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		Formulario bien = new Formulario();
      		dispose();
      		bien.setVisible(true);
      	}
      });
      panel_1.add(btnNewButton);
      
      JButton btnNewButton_1 = new JButton("Reservas en curso");
      btnNewButton_1.setForeground(Color.WHITE);
      btnNewButton_1.setBackground(Color.DARK_GRAY);
      btnNewButton_1.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		dispose();      		
			new Muestra(1).setVisible(true);
      		
      	}
      });
      panel_1.add(btnNewButton_1);
      
      JButton btnNewButton_2 = new JButton("Reservas canceladas");
      btnNewButton_2.setForeground(Color.WHITE);
      btnNewButton_2.setBackground(Color.DARK_GRAY);
      btnNewButton_2.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		dispose();
			new Muestra(2).setVisible(true);
      	}
      });
      panel_1.add(btnNewButton_2);
      
      JButton btnNewButton_3 = new JButton("Reservas no realizadas por lleno");
      btnNewButton_3.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		dispose();      		
			new Muestra(3).setVisible(true);
      	}
      });
      btnNewButton_3.setForeground(Color.WHITE);
      btnNewButton_3.setBackground(Color.DARK_GRAY);
      panel_1.add(btnNewButton_3);
      
      JButton btnGestionarReservas = new JButton("Gestionar reservas");
      btnGestionarReservas.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		dispose();
      		new GestionReservas().setVisible(true);
      	}
      });
      btnGestionarReservas.setForeground(Color.WHITE);
      btnGestionarReservas.setBackground(Color.DARK_GRAY);
      panel_1.add(btnGestionarReservas);
      
      JButton btnNewButton_4 = new JButton("Volver");
      panel_1.add(btnNewButton_4);
      btnNewButton_4.setForeground(Color.WHITE);
      btnNewButton_4.setBackground(Color.RED);
      btnNewButton_4.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		dispose();
      		new Home().setVisible(true);
      	}
      });
      
      JPanel panel_2 = new JPanel();
      panel_2.setBackground(new Color(255, 255, 255));
      panel_2.setBounds(0, 0, 800, 65);
      getContentPane().add(panel_2);
      panel_2.setLayout(null);
      
      JLabel lblNewLabel = new JLabel("El Palacio");
      lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 40));
      lblNewLabel.setBounds(347, 5, 208, 49);
      panel_2.add(lblNewLabel);
  }
	
	private void MuestraAceptadas(JTextArea textArea) {
		// Mostramos las reservas que hay para el dia actual
		
try {

		
		Conexion db = new Conexion();
        db.MySQLConnect();
        String NombreDB = "reservas";
        LocalDate todaysDate = LocalDate.now();
        String Query = "SELECT * FROM " + NombreDB +" WHERE `Estado` = 'Aceptada' AND `fecha`= '"+todaysDate+"'";
        db.comando = db.conexion.createStatement();
        db.registro = db.comando.executeQuery(Query);
        
        	while (db.registro.next()) {
        		textArea.append("\nId: " + db.registro.getString(1)+
                		"\nNombre: " + db.registro.getString(2) + 
                        "\nEmail: " + db.registro.getString(3) +
                        "\nTelefono: " + db.registro.getString(4) +
                        "\nTurno: " + db.registro.getString(5) +
                        "\nNumero de Personas: " + db.registro.getString(6) +
                        "\nFecha: " + db.registro.getString(7) +
                        "\nEstado: " + db.registro.getString(8)+
                        "\nIdCliente: " + db.registro.getString(9));
        		
        		textArea.append("\n------------------------------------------");

        	}
	}catch (SQLException ex) {
		System.out.println(ex);
			 
			
			
	        }
		}		
	
}  
