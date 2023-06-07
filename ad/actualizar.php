<!DOCTYPE html>
<html>
   <head>
      <title>Actualizacion</title>
      <link  href="tablaCss.css" rel="stylesheet" type="text/css" >
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous"> 
   </head>
   <body>
    <header>
        <h1 style="color:white">Actualizacion</h1>
      </header>
    
    <div>
      <div class="centrar3">
          
          <?php

            $servidor="localhost";
            $usuario="root";
            $clave="";
            $baseDeDatos="elpalacio";

            $conexion = mysqli_connect($servidor,$usuario,$clave, $baseDeDatos);
            if(!$conexion){
              echo "Error en la conexioni con el servidor";   
            }
            if(isset($_POST['confirma'])){
              $id=$_POST['idBuscado'];
              $usuario1=$usuario;
              $ssql = "Update reservas set Estado = 'Aceptada' where id=".$id;
              if($conexion->query($ssql)) {
                echo '<p>Cliente actualizado con éxito</p>';
              } else {
                echo '<p>Hubo un error al actualizar el cliente: ' . $conexion->error . '</p>';
              }
                    
              }
              if(isset($_POST['anular'])){
                $id=$_POST['idBuscado'];
                $usuario1=$usuario;
                $ssql = "Update reservas set Estado = 'Cancelada' where id=".$id;
                if($conexion->query($ssql)) {
                  echo '<p>Cliente actualizado con éxito</p>';
                } else {
                  echo '<p>Hubo un error al actualizar el cliente: ' . $conexion->error . '</p>';
                }
              
              }
          ?>
        <a  class="btn btn-primary" href=".\Index.html">Inicio</a>
        <a  class="btn btn-success" href=".\FormularioC.php">Reservar</a>
        <a  class="btn btn-info" href=".\login.php">Login</a>
      </div>
    </div>
   </body>
</html>
