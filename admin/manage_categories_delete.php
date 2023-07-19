<?php
    // echo $_REQUEST['id'];
    $c_id = $_REQUEST['id'];
    $dsn = "mysql:host=localhost;dbname=cookmate";
    $options = [
        PDO::ATTR_ERRMODE            => PDO::ERRMODE_EXCEPTION,
        PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,
        PDO::ATTR_EMULATE_PREPARES   => false,
    ];
    $pdo = new PDO($dsn, "root", "", $options);

    $statement = $pdo->query("SELECT c_image FROM categories WHERE c_id = $c_id");
    $row = $statement->fetch();
    unlink($row["image"]); //for delete the old file
    $sql = "DELETE FROM categories WHERE c_id = $c_id";
    echo $sql;

    $statement = $pdo->query($sql);
    $statement->execute();
    header("Location: Managecategories.php");
?>