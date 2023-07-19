<?php
    $r_id = $_GET["id"];
    $r_name = $_POST["r_name"];
    $r_ingredients = $_POST["r_ingredients"];
    $r_instruction = $_POST["r_instruction"];
    $c_id = $_POST["r_categories"];

    $dsn = "mysql:host=localhost;dbname=cookmate";
    $options = [
        PDO::ATTR_ERRMODE            => PDO::ERRMODE_EXCEPTION,
        PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,
        PDO::ATTR_EMULATE_PREPARES   => false,
    ];
    $pdo = new PDO($dsn, "root", "", $options);

    $statement = $pdo->query("SELECT r_image FROM recipe WHERE r_id = $r_id");
    $row = $statement->fetch();
    unlink($row["r_image"]); //for delete the old file

    $tmp = $_FILES["uploadfile"]["tmp_name"];
    $upload_location = "images/" . $_FILES["uploadfile"]["name"];

    move_uploaded_file($tmp, $upload_location);

    $query = "UPDATE `recipe` SET `r_name`='$r_name',`r_image`='$upload_location',`r_ingredients`='$r_ingredients',`r_instruction`='$r_instruction',`c_id`=$c_id WHERE `r_id`=$r_id ";
    
    $statement = $pdo->query($query);
    $statement->execute();
    header("Location: ManageRecipe.php");
?>
