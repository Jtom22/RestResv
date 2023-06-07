<!DOCTYPE html>
<HTML>
  <head>
    <title>Mi primer WEB</title>
    <link  href="style2.css" rel="stylesheet" type="text/css" >
  </head>
  <body>
    <form method="POST" action="tablas.php" name="signup-form" class="centrar2">
        <div>
            <label id=titulo>Registro</label>
        </div>
        <div class="form-element">
            <label>Username</label>
            <input type="text" name="username"/>
        </div>
        <div class="form-element">
            <label>Password</label>
            <input type="password" name="password" required />
        </div>
        <button type="submit" name="register" value="register">Register</button>
        <!-- pattern="[a-zA-Z0-9]" -->
    </form>
  </body> 
</HTML>
<?php 
if(isset($_POST['register'])){
    //Conexion con la base de datos.
    $servidor="localhost";
    $usuario="root";
    $clave="";
    $baseDeDatos="elpalacio";

    $conexion = mysqli_connect($servidor,$usuario,$clave, $baseDeDatos);
    if(!$conexion){
    echo "Error en la conexioni con el servidor";   
    }
    
    if($conexion->connect_errno){
        echo "Fallo al conectar a MySQL:(". $conexion->connect_errno.")";
    }
        else{
        $conexion->select_db("elpalacio");
            
        //declaramos como variables a los campos de texto del formulario.
        $nombre=$_POST["username"];
        $password=$_POST["password"];

        //Consulta del usuario y el password
        $consulta="SELECT usuario,contraseña FROM clientes 
        WHERE usuario='$nombre' and contraseña='$password'";
        if($query= $conexion->query($consulta)){
        $row=$query->fetch_array(); 
        $nr =$query->num_rows; 
        //Si existe el usuario lo va a redireccionar a la pagina de Bienvenida.
        if($nr == 1){ 
            header ("Location:tablas.php"); 
        }
        //Si no existe lo va a enviar al login otra vez.
        else if($nr <= 0) { 
            
            header("Location:login.php"); 
            die();
        }  
        }
        else{
            echo $conexion->error;  
            }
    }  
}   
?>