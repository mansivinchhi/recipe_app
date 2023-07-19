<?php include ('header.php'); ?>

<?php
    $dsn = "mysql:host=localhost;dbname=cookmate";
    $options = [
        PDO::ATTR_ERRMODE            => PDO::ERRMODE_EXCEPTION,
        PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,
        PDO::ATTR_EMULATE_PREPARES   => false
    ];
    $pdo = new PDO($dsn, "root", "", $options);
    $statement = $pdo->query("SELECT f.*,r.r_name,u.u_name FROM feedback f,recipe r,user u where f.r_id=r.r_id and f.u_id = u.u_id");
?>

<main>
    <div class="container">
        <div class="row">&nbsp;</div>
        <div class="row  justify-content-center">
            <div class="col-12 col-md-12 col-sm-12">
                </br></br><h2><div class="card-header" align = "center" style="background-color:#589107;"><font color="#fffff">Feedback</font></div></h2>
            </div>
        </div>
        <div class="row">&nbsp;</div>
        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12 ">
                <table id="my_feedback" class="table table-striped table-responsive">
                    <thead align="center">
                        <tr>
                            <th>Racipe Name</th>
                            <th>User Name</th>
                            <th>Description</th>
                            <th>Rating</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody align="center">
                        <?php while ($row = $statement->fetch()) { ?>
                            <tr>
                                <td><?= $row["r_name"] ?></td>
                                <td><?= $row["u_name"] ?></td>
                                <td><?= $row["f_description"] ?></td>
                                <td><?= $row["f_rating"] ?></td>
                                <td>
                                <a href="manage_feedback_delete.php?id=<?= $row['f_id'] ?>&mode=delete" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure you want to delete this Category?');">Delete</a>
                                </td>
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
        $('#my_feedback').DataTable();
    } );
    </script>
</body>
</html>