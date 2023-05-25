package pac2;

import java.sql.Statement;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

public class basuraç {

	/*
	 * 
	 * 
	 * 
	 * 
	 *  if (existe=false) {
													//creamos cliente y reserva
										        	
										        	 Connection conec=(Connection) conexion.MySQLConnect();
													 String Query = "INSERT INTO "+NombreDBC+"(id, nombre, Contraseña) VALUES (NULL,'"+telefono+"','"+correo+"')";										
													 Statement st=conec.createStatement();
													 st.executeUpdate(Query);
													 JOptionPane.showMessageDialog(Formulario.this, "Creamos usuario");
										        	

													 Connection conec2=(Connection) conexion.MySQLConnect();
													 String Query3 = "INSERT INTO "+NombreDB+"(id, nombre, telefono, correo, turno, numero, fecha, Estado,id_cliente) VALUES (NULL,'"+nombre+"','"+telefono+"','"+correo+"','"+turno+"','"+numCli+"','"+fechaComoDate+"','Espera','"+telefono+"')";										
													 Statement st2=conec.createStatement();
													 st.executeUpdate(Query3);
													 JOptionPane.showMessageDialog(Formulario.this, "Reserva realizada");
										        	
										        }else {
													//insertamos solo reserva

													 Connection conec=(Connection) conexion.MySQLConnect();
													 String Query = "INSERT INTO "+NombreDB+"(id, nombre, telefono, correo, turno, numero, fecha, Estado,id_cliente) VALUES (NULL,'"+nombre+"','"+telefono+"','"+correo+"','"+turno+"','"+numCli+"','"+fechaComoDate+"','Espera','"+telefono+"')";										
													 Statement st=conec.createStatement();
													 st.executeUpdate(Query);
													 JOptionPane.showMessageDialog(Formulario.this, "Reserva realizada");
												}
										
												
//										       

												}else {
													//aqui cuando la reserva se rechaza por lleno
													 if (existe=false) {
															//creamos cliente y reserva
												        	
														 Connection conec=(Connection) conexion.MySQLConnect();
														 String Query = "INSERT INTO "+NombreDBC+"(id, nombre, Contraseña) VALUES (NULL,'"+telefono+"','"+correo+"')";										
														 Statement st=conec.createStatement();
														 st.executeUpdate(Query);
														 JOptionPane.showMessageDialog(Formulario.this, "Creamos usuario");

														 Connection conec2=(Connection) conexion.MySQLConnect();
															 String Query3 = "INSERT INTO "+NombreDB+"(id, nombre, telefono, correo, turno, numero, fecha, Estado, id_cliente) VALUES (NULL,'"+nombre+"','"+telefono+"','"+correo+"','"+turno+"','"+numCli+"','"+fechaComoDate+"','LLeno','"+telefono+"')";									
															 Statement st2=conec.createStatement();
															 st.executeUpdate(Query3);
															 JOptionPane.showMessageDialog(Formulario.this, "No hay sufiente espacio en el restaurante seleccione otro turno o dia");
												        	
												        }else {
															//insertamos solo reserva

												        	 Connection conec=(Connection) conexion.MySQLConnect();
															 String Query = "INSERT INTO "+NombreDB+"(id, nombre, telefono, correo, turno, numero, fecha, Estado,id_cliente) VALUES (NULL,'"+nombre+"','"+telefono+"','"+correo+"','"+turno+"','"+numCli+"','"+fechaComoDate+"','LLeno','"+telefono+"')";									
															 Statement st=conec.createStatement();
															 st.executeUpdate(Query);
															 JOptionPane.showMessageDialog(Formulario.this, "No hay sufiente espacio en el restaurante seleccione otro turno o dia");
												        }
	 */
}
