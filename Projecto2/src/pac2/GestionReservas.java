package pac2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.sql.SQLException;
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
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.Dimension;
import java.awt.Font;

public class GestionReservas extends JFrame {

	private JPanel contentPane;
	private JTextField buscador_txt;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionReservas frame = new GestionReservas(2);
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
	public GestionReservas(int i) {
		
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
		panel_1.setMinimumSize(new Dimension(15, 10));
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
		
		JList list = new JList();
		list.setFont(new Font("Tahoma", Font.PLAIN, 18));
		list.setBounds(43, 71, 793, 347);
		espera(list);
		

		
		panel_1.add(list);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(725, 25, 94, 26);
		panel_1.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(388, 25, 112, 28);
		panel_1.add(comboBox_1);
		
		JButton btnNewButton_1 = new JButton("Cancelar Reserva");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(153, 441, 138, 39);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Avisar");
		btnNewButton_2.setBounds(539, 441, 125, 39);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Espera");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(290, 441, 125, 39);
		panel_1.add(btnNewButton_3);
		


		
		
	}

	private void espera(JList lista) {
		// TODO Auto-generated method stub
		try {
			
			Conexion db = new Conexion();
	        db.MySQLConnect();
	        String NombreDB = "reservas";
	        String Query = "SELECT * FROM " + NombreDB +" WHERE `Estado` = 'Espera'";
	        db.comando = db.conexion.createStatement();
	        db.registro = db.comando.executeQuery(Query);
	        DefaultListModel DLM = new DefaultListModel();

	        TextArea textarea = new TextArea(); 
	        	while (db.registro.next()) {
	        		String info=(	                        
	                        "\n Turno: " + db.registro.getString(5) +
	                        "\n Nº Personas: " + db.registro.getString(6) +
	                        "\n Fecha: " + db.registro.getString(7) +
	                        "\n Estado: " + db.registro.getString(8)+
	        				"\n IdCliente: " + db.registro.getString(9));	 
	        		DLM.addElement(info); 
	        		lista.setModel(DLM);
	        		//lista.add(DLM);
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
	                        "\nTelefono: " + db.registro.getString(4) +
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
