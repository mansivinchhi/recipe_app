<?php
	mysql_connect("localhost","root","");
	mysql_select_db("admin");
	
		
		if($_POST['submit'])
		{
		$filename = $_FILES["uploadfile"] ["name"];
		$tempname = $_FILES["uploadfile"] ["tmp_name"];
		$folder = "images/" . $filename;
		move_uploaded_file($tempname, $folder);
		$name=$_REQUEST["name"];
		$prize=$_REQUEST["prize"];
		$lng=$_REQUEST["lng"];
		$about=$_REQUEST["about"];
		$type=$_REQUEST["type"];
		
		if($filename!="")
		{ 
			$result = mysql_query("INSERT INTO movies VALUES('$folder','$name','$prize','$lng','$about','$type')");
		}
		
			if($result)
			{
					header('Location: he.php');
			}
		}
	else
	{
		
	}
	
	?>