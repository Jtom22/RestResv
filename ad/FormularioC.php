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

<html>

<?php 
   
     ?>
    <head>

        <meta charset="utf-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

        <link  href="style.css" rel="stylesheet" type="text/css" >

        <title>Portal básico</title>

    </head>

    <body>

        <div id="header">
            <div class="container-fluid bg-dark text-light has-height-md middle-items border-top text-center wow fadeIn">
                <div class="row">
                    <div class="col-sm-4">
                        
                    </div>
                    <div class="col-sm-4" id="TituloForm">
                        El_Palacio
                    </div>
                   
                    
                </div>

                
            </div>

        </div>

        <div id="page" class="align-middle">
            <!-- contenedor -->

            

                <div id="part1">
                    <form method="POST" id="form">
                        <div class="cajaFormulario">
                            <div id="formulario">
                                <div id="formulario1">
                                    <label for="exampleFormControlInput1" class="form-label">Nombre</label>
                                    <input class="form-control" type="text" placeholder="Nombre" aria-label="default input example" name='nombre'>
        
                                    <label for="exampleFormControlInput1" class="form-label">Correo Electronico</label>
                                    <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="nombre@example.com" name="correo">

        
                                    <label for="exampleFormControlInput1" class="form-label">Teléfono</label>
                                    <input class="form-control" type="text" placeholder="632157874" aria-label="default input example" name="telefono">
        
                                
                                </div>
                            
                                <div id="formulario2">
                              
                                    <label for="exampleFormControlInput1" class="form-label">Número de clientes</label>
                                    <input class="form-control" type="text" placeholder="" aria-label="default input example" name="numero">
                                    
        
                                    <label for="exampleFormControlInput1" class="form-label">Fecha</label>
                                    <input class="form-control" type="text" placeholder="17-04-23" aria-label="default input example" name="fecha">
        
                                    <label for="exampleFormControlInput1" class="form-label">Numero de turno</label>
                                    <input class="form-control" type="text" placeholder="1 o 2" aria-label="default input example" name="turno">
        
        
                                </div>
    
    
                            </div>
                            <div class="text-center"><input type="submit" name="registrarse" class="btn btn-dark" id="enviar" value="Reservar"  /></div>


                        </div>
                        
 

                    </form>


                </div>

                <!-- fin cuerpo -->

            </div>
            


        </div>

        <div id="footer">
          
        <div class="container-fluid bg-dark text-light has-height-md middle-items text-center wow fadeIn">
        <div class="row">
            <div class="col-sm-4">
                <h3>Redes</h3>
                <p><span class="ti-location-pin pr-3"></span> https://twitter.com/El_Palacio</p>
                <p><span class="ti-support pr-3"></span> https://www.facebook.com/El_Palacio</p>
                <p><span class="ti-email pr-3"></span>info@website.com</p>
            </div>
            <div class="col-sm-4">
                <h3>Número de teléfono</h3>
                <P class="text-muted">(123) 456-7890</P>
            </div>
            <div class="col-sm-4">
                <h3>Dirección</h3>
                <P class="text-muted">Calle Manifestacion 23</P>
            </div>
        </div>
    </div>
    <div class="bg-white text-dark text-center border-top wow fadeIn">
        <p class="mb-0 py-3 text-muted small">&copy; Copyright <script>document.write(new Date().getFullYear())</script> Made with <i class="ti-heart text-danger"></i> By <a href="http://google.com">RestResv</a></p>
    </div>
    

    </body>

</html>
<?php 
    if(isset($_POST['registrarse'])){
        $usuario=$_POST['telefono'];
        $contraseña=$_POST['correo'];
        $id_cliente;
        $consulta ="SELECT * from clientes where usuario='$usuario'";

        $res = $enlace->query($consulta);

        if ($res->num_rows > 0) {
        //existe usuario
            while($row = $res->fetch_assoc()) {
                $id_cliente=$row["usuario"];
                
            }
            $nombre=$_POST['nombre'];
            $correo=$_POST['correo'];
            $telefono=$_POST['telefono'];
            $turno=$_POST['turno'];
            $numero=$_POST['numero'];
            $fecha =date("d-m-Y", strtotime($_POST['fecha']));
            $fecha2 =date("Y-m-d", strtotime($fecha));
            $estado='Espera';
            if(!empty($nombre) || !empty($correo)|| !empty($telefono)|| !empty($turno)|| !empty($numero)|| !empty($fecha2)){
                    $insertarDatos = "INSERT INTO reservas VALUES (null, '$nombre','$correo', '$telefono', '$turno', '$numero', '$fecha2', '$estado', '$id_cliente')";

                    $ejecutarInsertar = mysqli_query($enlace, $insertarDatos);
                    
                    if(!$ejecutarInsertar){
                        echo '<p>fallo sql</p>';
                        die;
                    }else{
                       
                    }
            }else{
            

            }
           
        } else {
            //no existe usuario
            if(!empty($usuario) || !empty($contraseña)){
                
               
                $insertarDatos = "INSERT INTO clientes VALUES (null, '$usuario','$contraseña')";

                $ejecutarInsertar = mysqli_query($enlace, $insertarDatos);
                
                if(!$ejecutarInsertar){
                    echo '<p>fallo sql</p>';
                    die;
                }else{
                    $usuario=$_POST['telefono'];
                    $contraseña=$_POST['correo'];
                   
                    $consulta ="SELECT * from clientes where usuario='$usuario'";

                    $res = $enlace->query($consulta);
                    
                    $id_cliente;
                    if ($res->num_rows > 0) {
                        while($row = $res->fetch_assoc()) {
                            $id_cliente=$row["usuario"];

                        }
                        $nombre=$_POST['nombre'];
                        $correo=$_POST['correo'];
                        $telefono=$_POST['telefono'];
                        $turno=$_POST['turno'];
                        $numero=$_POST['numero'];
                        $fecha =date("d-m-Y", strtotime($_POST['fecha']));
                        $fecha2 =date("Y-m-d", strtotime($fecha));
                        $estado='Espera';
                        if(!empty($nombre) || !empty($correo)|| !empty($telefono)|| !empty($turno)|| !empty($numero)|| !empty($fecha2)){
                                $insertarDatos = "INSERT INTO reservas VALUES (null, '$nombre','$correo', '$telefono', '$turno', '$numero', '$fecha2', '$estado', '$id_cliente')";
        
                                $ejecutarInsertar = mysqli_query($enlace, $insertarDatos);
                                
                                if(!$ejecutarInsertar){
                                    echo '<p>fallo sql</p>';
                                    die;
                                }else{
                                 
                                }
                        }else{
                        
        
                        }
                        
                    }else{
                    

                    }
                    }
            }   
    }
}

 
    
?>
<?php 
if(isset($_POST['registrarse'])){
    

}


?>