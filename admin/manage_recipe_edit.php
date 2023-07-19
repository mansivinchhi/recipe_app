<?php

    $r_id = $_GET["id"];
    $dsn = "mysql:host=localhost;dbname=cookmate";
    $options = [
        PDO::ATTR_ERRMODE            => PDO::ERRMODE_EXCEPTION,
        PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,
        PDO::ATTR_EMULATE_PREPARES   => false,
    ];
    $pdo = new PDO($dsn, "root", "", $options);
    $statement = $pdo->query("SELECT * FROM recipe WHERE r_id = $r_id");
    $row = $statement->fetch();
	//  print_r($row);
?>

<?php include('Header.php'); ?>
<script src="https://cdn.ckeditor.com/ckeditor5/34.0.0/classic/ckeditor.js"></script>
<div class="container">
    <div class="row">
    <div class="col-lg-12 col-md-12 col-sm-12">
    <br>
	<div>
	<div class="container">
        <div class="row">
            <div class="col s12 m12 l12 center-align">
                 <div class="col-lg-12 col-md-12 col-sm-12">
					</br></br><h2><div class="card-header" align = "center" style="background-color:#ECF0F1;"><font color="#22A8D8">Update Recipe</font></div></h2>
				</div>
			</div>
		</div>
</div>

<div class="row">&nbsp;</div>
		<form action="update_recipe.php?id=<?= $r_id ?>" method="post" enctype="multipart/form-data" onsubmit="return upload_image();">
		<br/>
			
			<label for="">Recipe Name:</label>	
			<input class="form-control" type="text" name="r_name" id="r_name" value="<?= $row['r_name'] ?>" required/></br></br>
			
			<label for="">Recipe Image:</label>
			<input type="file" name="uploadfile" id="uploadfile" required/></br></br>
			
			<label for="">Recipe ingredients:</label> 
			<textarea name="r_ingredients" id="ckeditor" >
				<?php echo htmlspecialchars($row['r_ingredients']) ?>
			</textarea></br></br>
			
			<label for="">Recipe instruction:</label>  
			<textarea name="r_instruction" id="ckeditor1">
				<?= $row['r_instruction'] ?>
			</textarea></br></br>			
			
			<label for="" >categories Name:</label>
			<select class="form-control" name="r_categories">
				<?php
 					$statement1 = $pdo->query("select * from categories");
					while($record = $statement1->fetch())
					{
				?>
					<option value="<?= $record['c_id'] ?>" ><?= $record['c_name'] ?></option>
				<?php	
					}
				?>
			</select>	
		
		
		</br></br></br>		
        	<input type="submit" name="submit" value="Update Recipe" class="btn btn-info btn-lg"/>
		</form>	
	</div>
	</div>
	</div>
	</div>
	
	<br>
			
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
