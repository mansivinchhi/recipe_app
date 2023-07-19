<?php

	//variable type for imagepath
	$ImagePath = "http://192.168.1.68/food/admin/";
	// for connection file
    include "connection.php";
    $data = array();
	// select all the field from categories table
    $query = "SELECT * FROM `categories`";
    $res = $conn->query($query);

	//if rowcount is > 0 then it in if statement other wise else and show 0 and masg="No Category Available" 
	if ($res->rowCount() > 0)
	{
		while ($row = $res->fetch()) {
		$data['Data'][] = array('ID' => $row['c_id'], 'CategoryName' => $row['c_name'], 'CategoryImage' => $ImagePath.$row['c_image']);
		}
	}  
	else
	{
		$data['status']="0";
		$data['msg']="No Category Avilable";
	}


    echo json_encode($data);
?>