<?php
$servidor="localhostaa";
$usuario="root";
$clave="";
$baseDeDatos="formulario";
$enlace= mysqli_connect($servidor, $usuario, $clave, $baseDeDatos);

if(!$enlace){
    echo"Error en la concexion con el servidor";
}else{
    echo"Que si funciona vamossss siuuuuu";
}


?>
<!DOCTYPE html>


<html>

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
                    <div class="col-sm-4">
                        <img src="../\IconoRestaurante.png" id="icono">
                    </div>
                    
                </div>

                
            </div>

        </div>

        <div id="page" class="align-middle">
            <!-- contenedor 
        $id=;
$nombre
$Correo
$telefono
$turno
$Numero
$Fecha
$estado
$id_cliente-->

            

                <div id="part1">
                    <form method="get" action="accion.html" id="form">
                        <div class="cajaFormulario">
                            <div id="formulario">
                                <div id="formulario1">
                                    <?php echo "loco";?>
                                    <label for="exampleFormControlInput1" class="form-label">Nombre</label>
                                    <input class="form-control" type="text" placeholder="Nombre" aria-label="default input example">
        
                                    <label for="exampleFormControlInput1" class="form-label">Correo Electronico</label>
                                    <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="nombre@example.com">

        
                                    <label for="exampleFormControlInput1" class="form-label">Teléfono</label>
                                    <input class="form-control" type="text" placeholder="632157874" aria-label="default input example">
        
                                
                                </div>
                            
                                <div id="formulario2">
                              
                                    <label for="exampleFormControlInput1" class="form-label">Número de clientes</label>
                                    <input class="form-control" type="text" placeholder="" aria-label="default input example">
                                    
        
                                    <label for="exampleFormControlInput1" class="form-label">Fecha</label>
                                    <input class="form-control" type="text" placeholder="17/04/23" aria-label="default input example">
        
                                    <label for="exampleFormControlInput1" class="form-label">Numero de turno</label>
                                    <input class="form-control" type="text" placeholder="1 o 2" aria-label="default input example">
        
        
                                </div>
    
    
                            </div>
                            <div class="text-center"><input type="submit" name="enviar" class="btn btn-dark " id="enviar" /></div>


                        </div>
                        


                    </form>


                </div>

                <!-- fin cuerpo -->

            </div>
            


        </div>
        <div id="footer">

                
            
            <div class="container-fluid bg-dark text-light has-height-md middle-items border-top text-center wow fadeIn">
                <div class="row">
                    <div class="col-sm-4">
                        <h3>Nuestra web</h3>
                        <P class="text-muted">info@website.com</P>
                    </div>
                    <div class="col-sm-4">
                        <h3>Número de telefono</h3>
                        <P class="text-muted">(123) 456-7890</P>
                    </div>
                    <div class="col-sm-4">
                        <h3>Dirección</h3>
                        <P class="text-muted">12345 Fake ST NoWhere AB Country</P>
                    </div>
                </div>
                
           
        </div>

    </body>

</html>