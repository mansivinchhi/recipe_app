<?php include('Header.php'); ?>
<?php
    $dsn = "mysql:host=localhost;dbname=cookmate";
    $options = [
        PDO::ATTR_ERRMODE            => PDO::ERRMODE_EXCEPTION,
        PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,
        PDO::ATTR_EMULATE_PREPARES   => false,
    ];
    $pdo = new PDO($dsn, "root", "", $options);
    $statement = $pdo->query("SELECT * FROM categories");
?>
<main>
    <div class="container">
        <div class="row">&nbsp;</div>
        <div class="row">
            <div class="col s12 m12 l12 center-align">
                 <div class="col-lg-12 col-md-12 col-sm-12">
					</br></br><h2><div class="card-header" align = "center" style="background-color:#589107;"><font color="#fffff">Manage Categories</font></div></h2>
				</div>
                <!-- <div class="col-lg-12 col-md-12 col-sm-12">
					</br></br>
                    <h3>
                        <div class="card-header" style="background-color:white;">
                            <form action="">
                               <input type="search" name="" id="">
                               <input type="submit" value="search" class="btn btn-secondary btn-ml">
                           </form>
                        </div>
                    </h3>
                    
				</div> -->
                    </br>
                <a href="AddCategories.php" class="btn btn-info btn-lg">+ Add Categories</a>
			</div>
        </div>
        <div class="row">&nbsp;</div>
        <div class="row">
			<div class="col s12 m12 l12 center-align">		
				<table id="my_categories" class="table table-striped table-responsive">
				  <thead align="center">
						<tr>
                            <th>Name</th>
                            <th>Image</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
				  </thead>
				  <tbody>
						<?php while ($row = $statement->fetch()) { ?>
                            <tr>
							     <td><?= $row["c_name"] ?></td>
                                <td><img src="<?php echo $row["c_image"]; ?>" height="200" width="200" class="img-responsive" alt="responsive Image"></td>
                                <td>   
                                    <a href="manage_categories_edit.php?id=<?= $row['c_id'] ?>&mode=edit" class="btn btn-primary btn-sm">Edit</a><br>
                                </td>
                                <td>
                                    <a href="manage_categories_delete.php?id=<?= $row['c_id'] ?>&mode=delete" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure you want to delete this Category?');">Delete</a>
                                </td>
                            </tr>
                        <?php } ?>
				  </tbody>
				</table>

                </div> 
			</div>
		
</main>
</div>
 <script>
    $(document).ready( function () {
        $('#my_categories').DataTable();
    } );
    </script>
</body>
</html>