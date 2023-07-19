<?php include ('header.php'); ?>

<?php
    $dsn = "mysql:host=localhost;dbname=cookmate";
    $options = [
        PDO::ATTR_ERRMODE            => PDO::ERRMODE_EXCEPTION,
        PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,
        PDO::ATTR_EMULATE_PREPARES   => false
    ];
    $pdo = new PDO($dsn, "root", "", $options);
    $statement = $pdo->query("SELECT * FROM user");
?>

<main>
    <div class="container">
        <div class="row">&nbsp;</div>
        <div class="row">
        <div class="col-lg-12 col-md-12 col-sm-12">
        </br></br><h2><div class="card-header" align = "center" style="background-color:#589107;"><font color="#fffff">User</font></div></h2>
            </div>
        </div>
        <div class="row">&nbsp;</div>
        <div class="row">
            <div class="col s12 m12 l12">
                <table id="my_user" class="table table-striped table-responsive">
                    <thead align="center">
                        <tr>
                            <th>id</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>password</th>
                        </tr>
                    </thead>
                    <tbody align="center">
                        <?php while ($row = $statement->fetch()) { ?>
                            <tr>
                                <td><?=$row["u_id"] ?></td>
                                <td><?= $row["u_name"] ?></td>
                                <td><?= $row["u_email"] ?></td>
                                <td><?= $row["u_password"] ?></td>
                            </tr>
                        <?php } ?>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</main>
<script>
    $(document).ready( function () {
        $('#my_user').DataTable();
    } );
    </script>
</body>
</html>