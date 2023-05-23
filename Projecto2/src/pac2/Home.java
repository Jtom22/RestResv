package pac2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Button;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.SQLException;
import java.util.Iterator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.Toolkit;

public class Home extends JFrame {

	private JPanel contentPane;
	private JTextField Usuario_Field;
	private JPasswordField passwordField;
	
	int xx,xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	// going to borrow code from a gist to move frame.
	

	/**
	 * Create the frame.
	 */
	public Home() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Home.class.getResource("/Imagenes/IconoRestaurante.png")));
		setAlwaysOnTop(true);
		setBackground(Color.WHITE);
		this.setLocationRelativeTo(null);
		setBounds(100, 100, 816, 593);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 347, 554);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/rest.jpg")));
		
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				 xx = e.getX();
			     xy = e.getY();
			}
		});
		label.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				
				int x = arg0.getXOnScreen();
	            int y = arg0.getYOnScreen();
	            Home.this.setLocation(x - xx, y - xy);  
			}
		});
		label.setBounds(-183, -22, 617, 621);
		label.setVerticalAlignment(SwingConstants.TOP);
		panel.add(label);
		
		Button button = new Button("Login");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean existe=false;
				Conexion db = new Conexion();
		        db.MySQLConnect();
		        String UsuarioDB = "usuario";
		        String Query = "SELECT * FROM " + UsuarioDB ;
		        try {
					db.comando = db.conexion.createStatement();
					db.registro = db.comando.executeQuery(Query);
					while (db.registro.next()) {
		        		String Usuario= db.registro.getString(2);
		        		String Pass= db.registro.getString(3) ;
		        		if (Usuario.equalsIgnoreCase(Usuario_Field.getText())) {
		        			
							if (Pass.equalsIgnoreCase(String.valueOf(passwordField.getPassword()))) {
								existe =true;
								
							}else {
								JOptionPane.showMessageDialog(Home.this, "Contraseña Incorrecta","Advertencia",0);
							}
						}else {
							JOptionPane.showMessageDialog(Home.this, "Usuario Incorrecto","Advertencia",0);
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		     
		        if (existe==true) {
		        	 Menu ventana = new Menu();
						dispose();
						ventana.setVisible(true);
						
				}
		       
			
			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(Color.RED);
		button.setBounds(408, 438, 283, 52);
		contentPane.add(button);
		
		Usuario_Field = new JTextField();
		Usuario_Field.setBounds(408, 230, 283, 52);
		contentPane.add(Usuario_Field);
		Usuario_Field.setColumns(10);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setBounds(408, 205, 114, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(408, 302, 96, 14);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(408, 341, 283, 52);
		contentPane.add(passwordField);
		
		
		JLabel lblNewLabel = new JLabel("El Palacio");
		lblNewLabel.setBounds(408, 71, 283, 81);
		contentPane.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 50));
		lblNewLabel.setForeground(Color.BLACK);
	}
}