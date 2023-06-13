<!DOCTYPE html>
<html>
   <head>
      <title>Actualizacion</title>
      <link  href="tablaCss.css" rel="stylesheet" type="text/css" >
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous"> 
   </head>
   <body>
        <header>
            <h1 style="color:white" class> </h1>
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
                    "Error en la conexioni con el servidor";   
                    }else{
                    echo' <h1 class="text-white">Reserva aceptada<h1>'; 
                    }
                    echo'<script type="text/javascript">
                    alert("Tarea Guardada");
                    window.location.href="FormularioC.php";
                    </script>';
                ?>
                <a  class="btn btn-primary" href=".\Index.html">Inicio</a>
                <a  class="btn btn-success" href=".\FormularioC.php">Reservar</a>
                <a  class="btn btn-info" href=".\login.php">Login</a>
            </div>
        </div>
   </body>
</html>
function aviso($aviso){

if ($aviso==true) {
    echo'<script type="text/javascript">
    alert("Tarea Guardada");
    window.location.href="FormularioC.php";
    </script>';
}

}