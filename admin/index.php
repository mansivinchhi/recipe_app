<?php
    session_start();
    if (isset($_SESSION["IsAdmin"]))
    {
        header("Location: home.php");
        exit();
    }
?>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Document</title>
  <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="login-form.css" rel="stylesheet">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


</head>



  <body background-color: white>

  <img src="foodlogo.png" class="rounded mx-auto d-block" alt="..." height="150" width="250"/>
  <div class="text-center">
  <label for="" style="color : rgb(0,128,0);" ><b>Food Recipe App</b></label>
  </div>  
  <div class="text-center">
  <label for="" style="color : rgb(255,140,0);" ><b><h1>Admin Panel</h1></b></label>
 
  <!-- <label for="" ><h1>Admin Panel</h1></label> -->
  </div>  
  
    <div class="wrapper fadeInDown">
      <div id="formContent">
        <form action="logincheckc.php" method="POST">
          </br>
          <div class="card-header" align = "center" style="background-color:#589107;"><font color="#fffff"><h1  >Login</h1></font></div>
          <!-- <font  size="6.5" align="center">Login</font> -->
          </br></br>
            <input type="text" id="name" class="fadeIn second" name="Email" placeholder="Username" required/>
            <input type="password" id="password" class="fadeIn third" name="Password" placeholder="Password" required />
            <input type="submit" name="login" class="fadeIn fourth" value="Log In">
          </form>
      </div>
    </div>
  </body>
</html>

