<?php

    $c_id = $_GET["id"];
    $dsn = "mysql:host=localhost;dbname=cookmate";
    $options = [
        PDO::ATTR_ERRMODE            => PDO::ERRMODE_EXCEPTION,
        PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,
        PDO::ATTR_EMULATE_PREPARES   => false,
    ];
    $pdo = new PDO($dsn, "root", "", $options);
    $statement = $pdo->query("SELECT * FROM categories WHERE c_id = $c_id");
    $row = $statement->fetch();
?>

<?php include('Header.php'); ?>
	
<div class="container">
    <div class="row">
    <div class="col-lg-12 col-md-12 col-sm-12" align="center" >
    <br>
	<div>
	<div class="container">
        <div class="row">
            <div class="col s12 m12 l12 center-align">
                 <div class="col-lg-12 col-md-12 col-sm-12">
					</br></br><h2><div class="card-header" align = "center" style="background-color:#ECF0F1;"><font color="#22A8D8">Update Categories</font></div></h2>
				</div>
			</div>
		</div>
</div>

<div class="row">&nbsp;</div>
		<form action="update_categories.php?id=<?= $c_id ?>" method="post" enctype="multipart/form-data" onsubmit="return upload_image();">
		<br/>
			<label for="" class="text-justify">Categories Name : </label>
			<input type="text" name="c_name" id="name" required value="<?= $row['c_name']?>"/></br></br>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;		
			<label for="" class="text-justify">Categories Image : </label>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="file" name="uploadfile" id="uploadfile" required/></br></br>
        	<input type="submit" name="submit" value="Update Categories" class="btn btn-info btn-sm"/>
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
<?php include('footer.html'); ?>

