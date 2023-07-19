<?php $level = "../../"; ?>
<?php require("../../header.php"); ?>
<?php
    $dsn = "mysql:host=localhost;dbname=admin";
    $options = [
        PDO::ATTR_ERRMODE            => PDO::ERRMODE_EXCEPTION,
        PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,
        PDO::ATTR_EMULATE_PREPARES   => false,
    ];
    $pdo = new PDO($dsn, "root", "", $options);
    $statement = $pdo->query("SELECT * FROM movies");
?>
<main>
    <div class="container">
        <div class="row">&nbsp;</div>
        <div class="row">
            <div class="col s12 m12 l12 center-align">
                <h4>Manage Products</h4>
            </div>
        </div>
        <div class="row">&nbsp;</div>
        <div class="row">
            <div class="col s12 m12 l12 center-align">
                <table class="striped responsive-table">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Description</th>
                            <th>Type</th>
                            <th class="center-align">Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <?php while ($row = $statement->fetch()) { ?>
                            <tr>
								<td><img src="<?php echo $row["image"]; ?>" height="20%" width="20%" class="img-responsive" alt="responsive Image">
	</td>
                                <td><?= $row["name"] ?></td>
                                <td><?= $row["lng"] ?></td>
                                <td><?= $row["about"] ?></td>
                                <td class="center-align">
                                    <a href="manage.php?id=<?= $row['ProductID'] ?>&mode=edit" class="btn btn-small blue">Edit</a>
                                    <a href="manage.php?id=<?= $row['ProductID'] ?>&mode=delete" class="btn btn-small red">Delete</a>
                                </td>
                            </tr>
                        <?php } ?>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</main>
<?php require("../../footer.php"); ?>