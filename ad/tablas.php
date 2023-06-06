<?php 
    $servidor="localhost";
    $usuario="root";
    $clave="";
    $baseDeDatos="elpalacio";
    

    $enlace = mysqli_connect($servidor,$usuario,$clave, $baseDeDatos);
    if(!$enlace){
     echo "Error en la conexioni con el servidor";   
    }

?>
<!DOCTYPE html>
<HTML>
  <head>
    <title>Mi primer WEB</title>
    <link  href="tablaCss.css" rel="stylesheet" type="text/css" >
    
  </head>
  <body>
  
    <?php 
        
        $usuario=$_POST['username'];
        echo $usuario;
        $consulta ="SELECT * from reservas where id_cliente='$usuario'";
        

       
        //$resultado=$mysqli_query($enlace,$consulta);
        //$res=$mysqli_query();
        $res = $enlace->query($consulta);
     
        if ($res->num_rows > 0) {
          echo "<table id=tablas><thead><tr><th>ID</th><th>Nombre</th><th>Correo</th><th>Telefono</th><th>Fecha</th><th>Estado</th><th>Estado</th></tr></thead>";
          // output data of each row
          while($row = $res->fetch_assoc()) {
            echo "<tbody><tr><td>".$row["id"]."</td><td>".$row["nombre"]."<td>".$row["correo"]."</td><td>".$row["telefono"]."</td><td>".$row["fecha"]."</td><td>".$row["Estado"]."</td></tr></tbody>";
             
          }
          echo "</table>";
        } else {
          echo "0 results";
        }
        $enlace->close();
  
    ?>
 

  </body> 
</HTML>