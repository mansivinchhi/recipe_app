<?php
    // echo $_REQUEST['id'];
    $f_id = $_REQUEST['id'];
    $dsn = "mysql:host=localhost;dbname=cookmate";
    $options = [
        PDO::ATTR_ERRMODE            => PDO::ERRMODE_EXCEPTION,
        PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,
        PDO::ATTR_EMULATE_PREPARES   => false,
    ];
    $pdo = new PDO($dsn, "root", "", $options);

    $sql = "DELETE FROM feedback WHERE f_id = $f_id";
    echo $sql;

    $statement = $pdo->query($sql);
    $statement->execute();
    header("Location:feedback.php");
?>