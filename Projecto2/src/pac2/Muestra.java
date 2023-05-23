package pac2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.sql.SQLException;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Muestra extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Muestra frame = new Muestra(2);
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
	public Muestra(int i) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 555, 35);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("New label");
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 43, 545, 336);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		//textArea.setBounds(35, 48, 500, 253);
		//panel_1.add(textArea);
		
		
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
	      		new Menu().setVisible(true);
			}
		});
		btnNewButton.setBounds(235, 302, 89, 23);
		panel_1.add(btnNewButton);
		
		
		
		JTextArea textArea = new JTextArea(16, 58);
		//textArea.setBounds(31, -1, 504, 292);
		//panel_1.add(textArea);
		textArea.setEditable ( false );

		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
		scrollPane.setBounds(33, 11, 487, 280);
		panel_1.add(scrollPane);
		
		if(i==1) {
			lblNewLabel.setText("Reservas en espera");
			espera(textArea);
			
		}else if(i==2) {
			lblNewLabel.setText("Reservas canceladas");
			cancelada(textArea);
		}else if(i==3) {
			lblNewLabel.setText("Reservas canceladas por lleno");
			lleno(textArea);
		}
		
		else {
			textArea.append("fallo");
		}
		
		
	}

	private void espera(JTextArea textArea) {
		// TODO Auto-generated method stub
		try {
			
			Conexion db = new Conexion();
	        db.MySQLConnect();
	        String NombreDB = "reservas";
	        String Query = "SELECT * FROM " + NombreDB +" WHERE `Estado` = 'Espera'";
	        db.comando = db.conexion.createStatement();
	        db.registro = db.comando.executeQuery(Query);
	        
	        	while (db.registro.next()) {
	        		textArea.append("\nId: " + db.registro.getString(1)+
	                		"\nNombre: " + db.registro.getString(2) + 
	                        "\nEmail: " + db.registro.getString(3) +
	                        "\nEmail: " + db.registro.getString(4) +
	                        "\nTurno: " + db.registro.getString(5) +
	                        "\nNumero de Personas: " + db.registro.getString(6) +
	                        "\nFecha: " + db.registro.getString(7) +
	                        "\nEstado: " + db.registro.getString(8));
	        		
	        		textArea.append("\n------------------------------------------");

	        	}
		}catch (SQLException ex) {
			System.out.println(ex);
			 
			
			
	        }
	}
	private void cancelada(JTextArea textArea) {
		// TODO Auto-generated method stub
		try {
			
			Conexion db = new Conexion();
	        db.MySQLConnect();
	        String NombreDB = "reservas";
	        String Query = "SELECT * FROM " + NombreDB +" WHERE `Estado` = 'Rechazada'";
	        db.comando = db.conexion.createStatement();
	        db.registro = db.comando.executeQuery(Query);
	        
	        	while (db.registro.next()) {
	        		textArea.append("\nId: " + db.registro.getString(1)+
	                		"\nNombre: " + db.registro.getString(2) + 
	                        "\nEmail: " + db.registro.getString(3) +
	                        "\nEmail: " + db.registro.getString(4) +
	                        "\nTurno: " + db.registro.getString(5) +
	                        "\nNumero de Personas: " + db.registro.getString(6) +
	                        "\nFecha: " + db.registro.getString(7) +
	                        "\nEstado: " + db.registro.getString(8));
	        		
	        		textArea.append("\n------------------------------------------");

	        	}
		}catch (SQLException ex) {
			System.out.println(ex);
			 
			
			
	        }
	}
	private void lleno(JTextArea textArea) {
		// TODO Auto-generated method stub
		try {
			
			Conexion db = new Conexion();
	        db.MySQLConnect();
	        String NombreDB = "reservas";
	        String Query = "SELECT * FROM " + NombreDB +" WHERE `Estado` = 'LLeno'";
	        db.comando = db.conexion.createStatement();
	        db.registro = db.comando.executeQuery(Query);
	        
	        	while (db.registro.next()) {
	        		textArea.append("\nId: " + db.registro.getString(1)+
	                		"\nNombre: " + db.registro.getString(2) + 
	                        "\nEmail: " + db.registro.getString(3) +
	                        "\nEmail: " + db.registro.getString(4) +
	                        "\nTurno: " + db.registro.getString(5) +
	                        "\nNumero de Personas: " + db.registro.getString(6) +
	                        "\nFecha: " + db.registro.getString(7) +
	                        "\nEstado: " + db.registro.getString(8));
	        		
	        		textArea.append("\n------------------------------------------");
	        	}
		}catch (SQLException ex) {
			System.out.println(ex);
			 
			
			
	        }
	}
}
