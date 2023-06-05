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
    <link  href="style2.css" rel="stylesheet" type="text/css" >
  </head>
  <body>
  
    <?php 
        $consulta ="SELECT * from reservas";
        $usuario=$_POST['username'];
        echo $usuario;
        $query = $mysqli->query("SELECT * from reservas where usuario='$usuario'");
        if ($result = $mysqli->query($query)) {

            /* fetch associative array */
            while ($row = $result->fetch_assoc()) {
                $field1name = $row["col1"];
                $field2name = $row["col2"];
                $field3name = $row["col3"];
                $field4name = $row["col4"];
                $field5name = $row["col5"];
            }
        
            /* free result set */
            $result->free();
        }
  
    ?>
  </body> 
</HTML>