<?php
    // echo $_REQUEST['id'];
    $r_id = $_REQUEST['id'];
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
    $sql = "DELETE FROM recipe WHERE r_id = $r_id";
    echo $sql;

    $statement = $pdo->query($sql);
    $statement->execute();
    header("Location: ManageRecipe.php");
?>