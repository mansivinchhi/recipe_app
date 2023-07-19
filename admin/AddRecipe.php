<?php include('Header.php'); 
$conn = mysqli_connect("localhost","root","","cookmate");
?>
<script src="https://cdn.ckeditor.com/ckeditor5/34.0.0/classic/ckeditor.js"></script>
	<div class="container">
    <div class="row">
    <div class="col-lg-12 col-md-12 col-sm-12" >
    <br>
	<div>
	<div class="container">
        <div class="row">
            <div class="col s12 m12 l12 center-align">
                 <div class="col-lg-12 col-md-12 col-sm-12">
					</br></br><h2><div class="card-header" align = "center" style="background-color:#ECF0F1;"><font color="#22A8D8">Add Recipe</font></div></h2>
				</div>
			</div>
		</div>
</div>

<div class="row">&nbsp;</div>
		<form action="add_recipe_logic.php" method="post" enctype="multipart/form-data" onsubmit="return upload_image();">
            
			<label for="" >Recipe Name:</label>	
			<input type="text" name="r_name" id="r_name" class="form-control" required/></br></br>
			
			<label for="" >Recipe ingredients:</label> 
			<textarea name="r_ingredients" id="ckeditor" class="form-control"></textarea></br></br>
			
			<label for="" >Recipe instruction:</label>  
			<textarea name="r_instruction" id="ckeditor1" class="form-control"></textarea></br></br>			
			
			<label for="" class="text-right-justify">Categories Name:</label>
			<select name="r_categories" class="form-control">
				<?php

					$query = "select * from categories";
					$res = mysqli_query($conn, $query);
					while($row = mysqli_fetch_assoc($res))
					{
					?>
						<option value="<?= $row['c_id'] ?>" ><?= $row['c_name'] ?></option>
				<?php	
				}
				?>
			</select>	</br></br>
			
			<label for="" >Recipe Image:</label>
			<input type="file" name="uploadfile" id="uploadfile"  required/></br></br></br>
			
			<input type="submit" name="submit" value="Add Recipe" class = "btn btn-info btn-lg"/>
				</form>	
	</div>
	</div>
	</div>
	</div>
	
	<br>
	<script>
	ClassicEditor
		.create( document.querySelector( '#ckeditor' ) )
		.catch( error => {
			console.error( error );
		} );
	</script>
	<script>
	ClassicEditor
		.create( document.querySelector( '#ckeditor1' ) )
		.catch( error => {
			console.error( error );
		} );
	</script>
</body>
</html>

