<?php include('Header.php'); ?>
<?php
    $dsn = "mysql:host=localhost;dbname=cookmate";
    $options = [
        PDO::ATTR_ERRMODE            => PDO::ERRMODE_EXCEPTION,
        PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,
        PDO::ATTR_EMULATE_PREPARES   => false,
    ];
    $pdo = new PDO($dsn, "root", "", $options);
    $statement = $pdo->query("SELECT c.c_name,r.* FROM recipe r,categories c where c.c_id=r.c_id");
?>
<!-- <script src="js\image_pop.js"></script> -->
<main>
    <div class="container">
        <div class="row">&nbsp;</div>
        <div class="row">
            <div class="col s12 m12 l12 center-align">
                 <div class="col-lg-12 col-md-12 col-sm-12">
					</br></br><h2><div class="card-header" align = "center" style="background-color:#589107;"><font color="#fffff">Manage Recipe</font></div></h2>
				</div>
</br>
                <a href="AddRecipe.php" class="btn btn-info btn-lg">+ Add Recipe</a>
			</div>
        </div>
        <div class="row">&nbsp;</div>
        <div class="row">
			<div class="col s12 m12 l12">		
				<table id="my_recipe"class="table table-striped table-responsive">
				  <thead align="center">
						<tr>
                            <th>Name</th>
                            <th>Image</th>
                            <th>Ingredients</th>
                            <th>Instruction</th>
                            <th>Categories Name</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
				  </thead>
				  <tbody>
                 
						<?php  $i=0; while ($row = $statement->fetch()) {  $i++; ?>
                            <tr>
                                <td><?= $row["r_name"] ?></td>
                                <td>
                                    <a href="<?php echo $row["r_image"]; ?>" id="myImg <?= $row['r_id'] ?>">
                                        
                                        <img src="<?php echo $row["r_image"]; ?>" height="200" width="200" class="img-responsive" alt="responsive Image">
                                    </a>
                                    
                                    <div id="myModal" class="modal">
                                        <span class="close">&times;</span>
                                        <!-- <img class="modal-content" id="img01"> -->
                                        <div id="caption"></div>
                                    </div>
                                </td>
                                <td><?= $row["r_ingredients"] ?></td>
                                <td><?= $row["r_instruction"] ?></td>
                                <td><?= $row["c_name"] ?></td>
                                <td>
                                    <a href="manage_recipe_edit.php?id=<?= $row['r_id'] ?>&mode=edit" class="btn btn-primary btn-sm">Edit</a><br>
                                </td>
                                <td>
                                    <a href="manage_recipe_delete.php?id=<?= $row['r_id'] ?>&mode=delete" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure you want to delete this Category?');">Delete</a>
                                </td>
    
                            </tr>
                        <?php } ?>
				  </tbody>
				</table>
                
			</div>
		
</main>
</div>
<!-- <script>
    $("#pop").on("click", function() {
   $(this).modal();
});
</script> -->

<script>
    $(document).ready( function () {
        $('#my_recipe').DataTable();
    } );
</script>
<script>
var modal = document.getElementById("myModal");

// Get the image and insert it inside the modal - use its "alt" text as a caption
var img = document.getElementById("myImg");
var modalImg = document.getElementById("img01");
var captionText = document.getElementById("caption");
img.onclick = function(){
  modal.style.display = "block";
  modalImg.src = this.src;
  captionText.innerHTML = this.alt;
}

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
  modal.style.display = "none";
  
}
</script>
</body>
</html>