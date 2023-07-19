<?php include('Header.php'); 
$Currentdate = date('Y-m-d');
?>

	<div class="container">
    <div class="row">
    <div class="col-lg-12 col-md-12 col-sm-12" align="center" >
    <br>
	<div>
	<div class="container">
        <div class="row">
            <div class="col s12 m12 l12 center-align">
                 <div class="col-lg-12 col-md-12 col-sm-12">
					</br></br><h2><div class="card-header" align = "center" style="background-color:#ECF0F1;"><font color="#22A8D8">Add Categories</font></div></h2>
				</div>
			</div>
		</div>
</div>

<div class="row">&nbsp;</div>
		<form action="add_categories_logic.php" method="post" enctype="multipart/form-data" onsubmit="return upload_image();">
		<br/>
			<label for="" class="text-justify">Categories Name : </label>
			<input type="text" name="c_name" id="name" required/></br></br>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;		
			<label for="" class="text-justify">Categories Image : </label>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="file" name="uploadfile" id="uploadfile" required/></br></br>
        	<input type="submit" name="submit" value="Add Categories" class="btn btn-info btn-sm"/>
		</form>	
	</div>
	</div>
	</div>
	</div>
	
	<br>
</body>
</html>

