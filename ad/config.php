<?php
define('USER', 'root');
define('HOST', 'localhost');
define('DATABASE', 'test');
try {
    $connection = new PDO("mysql:host=".HOST.";dbname=".DATABASE, USER);
} catch (PDOException $e) {
    exit("Error: " . $e->getMessage());
}
?>