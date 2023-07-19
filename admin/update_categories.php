<?php
    $c_id = $_GET["id"];
    $c_name = $_POST["c_name"];

    $dsn = "mysql:host=localhost;dbname=cookmate";
    $options = [
        PDO::ATTR_ERRMODE            => PDO::ERRMODE_EXCEPTION,
        PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,
        PDO::ATTR_EMULATE_PREPARES   => false,
    ];
    $pdo = new PDO($dsn, "root", "", $options);

    $statement = $pdo->query("SELECT c_image FROM categories WHERE c_id = $c_id");
    $row = $statement->fetch();
    unlink($row["c_image"]); //for delete the old file

    $tmp = $_FILES["uploadfile"]["tmp_name"];
    $upload_location = "images/" . $_FILES["uploadfile"]["name"];

    move_uploaded_file($tmp, $upload_location);

    $query = "UPDATE categories SET c_name = '$c_name', c_image='$upload_location' WHERE c_id = $c_id";
    echo $query;
    $statement = $pdo->query($query);
    $statement->execute();
    header("Location: Managecategories.php");
?>