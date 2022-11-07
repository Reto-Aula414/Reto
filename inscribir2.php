<html>
<body>

<?php
    $nombre=$_POST["nombre"];
    $apellidos=$_POST["apellidos"];
    $username=$_POST["email"];
    $ciudad=$_POST["ciudad"];
    $evento=$_POST["evento"];
?>   

Datos recibidos:<br>
Nombre: <?php echo $nombre; ?><br>
Apellidos: <?php echo $apellidos; ?><br>
Ciudad: <?php echo $ciudad; ?><br>
Evento: <?php echo $evento; ?><br>

<?php
$servidor = "localhost";
$usuario = "root";
$password = "";
$basedatos = "eventos";

// Crear conexión
$conn = new mysqli($servidor, $usuario, $password, $basedatos);
// Checkear conexión
if ($conn->connect_error) {
  die("Conexión fallida: " . $conn->connect_error);
}

$sql = "INSERT INTO inscripciones (nombre, apellidos, email, ciudad, evento)
VALUES ('$nombre','$apellidos', '$username', '$ciudad', '$evento')";

if ($conn->query($sql) === TRUE) {
  echo "Dado de alta satisfactoriamente";
} else {
  echo "Error: " . $sql . "<br>" . $conn->error;
}

// Cerrar conexión
$conn->close();
?>

</body>
</html>