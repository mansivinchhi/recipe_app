<?php
	$conn = mysqli_connect("localhost","root","","cookmate");

	if(isset($_POST['submit']))
	{
		$filename = $_FILES["uploadfile"] ["name"];
		$tempname = $_FILES["uploadfile"] ["tmp_name"];
		$folder = "images/" . $filename;

		move_uploaded_file($tempname, $folder);

		$r_name=$_REQUEST["r_name"];
		$r_ingredients=$_REQUEST["r_ingredients"];
		$r_instruction=$_REQUEST["r_instruction"];
		
		$r_categories = $_REQUEST["r_categories"];	

		if($filename!="")
		{ 
			$query = "INSERT INTO `recipe`(`r_name`, `r_image`, `r_ingredients`, `r_instruction`, `c_id`) VALUES ('$r_name','$folder','$r_ingredients','$r_instruction',$r_categories)";
			$result = mysqli_query($conn,$query);		
			if($result)
			{
					header('Location: ManageRecipe.php');
			}
		}
	}
	else
	{
		
	}
?>