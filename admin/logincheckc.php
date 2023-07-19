<?php
	session_start();
	$dbc = mysqli_connect('localhost','root','', 'cookmate')
        or die('Error Connecting to Database on the MySQL');
		
		if(isset($_POST["Email"] , $_POST["Password"])) 
        {     

            $Email = $_POST["Email"]; 
            $password = $_POST["Password"];
			
			$sql = "SELECT a_name,a_password FROM admin WHERE a_name = '$Email' AND a_password = '$password'";
			$result = mysqli_query($dbc, $sql);
			if (mysqli_num_rows($result) > 0) 
			{
				while($row = mysqli_fetch_assoc($result))
				{
					$_SESSION["Email"] = $row["username"];
					$_SESSION["IsAdmin"] = true;
					header('Location: home.php');
				} 
			}	 	
			else
			{
				echo "<SCRIPT type='text/javascript'>alert('Invalid Username And Password');window.location.replace('index.php');</SCRIPT>";
			}
		}
?>