<?php
	$conn = mysqli_connect("localhost","root","","cookmate");
	
	if(isset($_POST['submit']))
	{
		$filename = $_FILES["uploadfile"] ["name"];
		$tempname = $_FILES["uploadfile"] ["tmp_name"];
		$folder = "images/" . $filename;

		move_uploaded_file($tempname, $folder);
		$c_name=$_REQUEST["c_name"];

		if($filename!="")
		{ 	
			$query = "INSERT INTO categories(c_name,c_image) VALUES('$c_name','$folder')";
			$result = mysqli_query($conn,$query);
			if($result)
			{
				// echo "Done";
				header('Location: Managecategories.php');
			}
			else
			{
				echo "error";
			}
		}
	}
	else
	{
		
	}
?>