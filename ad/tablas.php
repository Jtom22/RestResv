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
    <title>Reservas</title>
    <link  href="tablaCss.css" rel="stylesheet" type="text/css" >
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous"> 
  </head>
  <body>
    <div style="color:white"class="text-center">
      <p style="font-size: 5svw;" >Reservas</p>
    </div>
 
    <div>
      <?php 
            
            $usuario=$_POST['username'];
            echo $usuario;
            $consulta ="SELECT * from reservas where id_cliente='$usuario'";
            

          
            //$resultado=$mysqli_query($enlace,$consulta);
            //$res=$mysqli_query();
            $res = $enlace->query($consulta);
        
            if ($res->num_rows > 0) {
              echo "<table id=tablas><thead><tr><th>ID</th><th>Nombre</th><th>Correo</th><th>Telefono</th><th>Fecha</th><th>Estado</th><th>Turno</th></tr></thead>";
              // output data of each row
              while($row = $res->fetch_assoc()) {
                echo "<tbody><tr><td>".$row["id"]."&nbsp-&nbsp"."</td><td>".$row["nombre"]."&nbsp&nbsp"."<td>".$row["correo"]."&nbsp&nbsp"."</td><td>".$row["telefono"]."&nbsp&nbsp"."</td><td>".$row["fecha"]."&nbsp&nbsp"."</td><td>".$row["Estado"]."&nbsp&nbsp"."</td><td>".$row["turno"]."</td></tr></tbody>";
                
              }
              echo "</table>";
            } else {
              echo "0 results";
            }
            $enlace->close();
      
        ?>
    </div>
    
    <div id="elecccion">
      <div class="text-center"style="margin-top:15px" >
      
          <form  method="POST" action="actualizar.php"  name="signup-form" >
            <div style="width:45%; color:white;display:block; transform: translate(50%,0);margin-bottom:15px;">
              <label for="exampleInputEmail1">Email address</label>
              <input type="text" class="form-control " name="idBuscado" aria-describedby="emailHelp" placeholder="introduce el id de la reserva">
            </div> 
       
            <div style="display:block">
              <button type="submit" class="btn btn-secondary" name="confirma" value="confirma">Confirmar </button>
              <button type="submit" class="btn btn-secondary" name="anular"value="anular">Anular</button>
              <a  class="btn btn-danger" href=".\Index.html">Volver</a>

            </div>
          </form>
          
      </div>
    </div>
      

  </body> 
  
</HTML>
