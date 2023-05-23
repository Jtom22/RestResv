package pac2;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class Reserva {
	
	String Nombre;
	String telefono;
	String correo;
	int turno;
	int numero;
	Date fecha;
	String Estado;
	
	public Reserva(String nombre, String telefono, String correo, int turno, int numero, Date fecha) {
		super();
		Nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
		this.turno = turno;
		this.numero = numero;
		this.fecha = fecha;
		Estado = Comprueba(fecha,turno);
		
	}
	public static void main(String[] args) {
		java.util.Date fechas = new Date();
		Reserva res= new Reserva("paco", "632542587", "pacolucero@hotmail.com", 2, 3,fechas);
	}

	private String Comprueba(Date fechaCom, int turnoCom) {
		// TODO Auto-generated method stub
		Conexion db = new Conexion();
        db.MySQLConnect();
        String NombreDB = "reservas";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String fechaComoCadena = sdf.format(fechaCom);
        fechaComoCadena="'"+fechaComoCadena+"'";
        String Query = "SELECT SUM(`numero`) FROM `reservas` WHERE `fecha`=" +fechaComoCadena +"AND `turno`="+turno;
        try {
			db.comando = db.conexion.createStatement();
			db.registro = db.comando.executeQuery(Query);
			String resultado=String.valueOf(db.registro);
			while (db.registro.next()) {
				resultado=db.registro.getString(1);
				//System.out.println(resultado);
				if (resultado==null) {
					resultado="0";
				}
			}
			if (Integer.parseInt(resultado)<50) {
				System.out.println("bueno");
				return "Espera";
				
			}else {
				System.out.println("vale");
				JOptionPane.showMessageDialog(null, "No hay sufiente espacio en el restaurante seleccione otro turno o dia");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
		return "LLeno";
	}
	

	@Override
	public String toString() {
		return "Reserva [Nombre=" + Nombre + ", telefono=" + telefono + ", correo=" + correo + ", turno=" + turno
				+ ", numero=" + numero + ", fecha=" + fecha + ", Estado=" + Estado + "]";
	}
	
}
