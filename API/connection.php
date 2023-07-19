<?php
    $servername = "localhost";
    $username = "root";
    $password = "";
    $db="cookmate";
    try 
	{
        $conn = new PDO("mysql:host=$servername;dbname=$db", $username, $password);
    	$conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);   
        // echo "Connection success: ";     
    }
	catch(PDOException $e)
    {
    	echo "Connection failed: " . $e->getMessage();
    }
?>