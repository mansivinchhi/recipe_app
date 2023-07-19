<?php
    session_start();
    if (!isset($_SESSION["IsAdmin"]))
    {
        header("Location: index.php");
        exit();
    }
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <meta http-equiv="X-UA-Compatible" content="ie=edge">
  

    <!-- <title>Document</title>

    
  <-- Bootstrap core CSS -->

  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/dataTables.bootstrap4.min.css"> 
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
  <link href="css/simple-sidebar.css" rel="stylesheet">
  <script scr="https://cdn.ckeditor.com/4.13.0/standard/ckeditor.js"></script>
  <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.11.5/js/dataTables.bootstrap4.min.js"></script>

<style>
#myImg {
    border-radius: 5px;
    cursor: pointer;
    transition: 0.3s;
  }
  
  #myImg:hover {opacity: 0.7;}
  
  /* The Modal (background) */
  .modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    padding-top: 100px; /* Location of the box */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.9); /* Black w/ opacity */
  }
  
  /* Modal Content (Image) */
  .modal-content {
    margin: auto;
    display: block;
    width: 80%;
    max-width: 700px;
  }
  
  /* Caption of Modal Image (Image Text) - Same Width as the Image */
  #caption {
    margin: auto;
    display: block;
    width: 80%;
    max-width: 700px;
    text-align: center;
    color: #ccc;
    padding: 10px 0;
    height: 150px;
  }
  
  /* Add Animation - Zoom in the Modal */
  .modal-content, #caption {
    animation-name: zoom;
    animation-duration: 0.6s;
  }
  
  @keyframes zoom {
    from {transform:scale(0)}
    to {transform:scale(1)}
  }
  
  /* The Close Button */
  .close {
    position: absolute;
    top: 15px;
    right: 35px;
    color: #f1f1f1;
    font-size: 40px;
    font-weight: bold;
    transition: 0.3s;
  }
  
  .close:hover,
  .close:focus {
    color: #bbb;
    text-decoration: none;
    cursor: pointer;
  }
  
  /* 100% Image Width on Smaller Screens */
  @media only screen and (max-width: 700px){
    .modal-content {
      width: 100%;
    }
  }
</style>

</head>
<body>
    
    <ul class="smooth-scroll list-unstyled">
        
    <!-- <nav class="navbar navbar-expand-lg navbar-light "  style="background-color :#f5f5f5">
            
         <a class="navbar-brand" href="#">
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  
             <img src="cookmate_logo.png" width="100" height="100" class="d-inline-block align-top" alt="">
             &nbsp; </br>   
             <h5 style="color : hsl(196, 84%, 53%);">Book My Movie</h5>
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" color="accent" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
        </button>    
    <div class="collapse navbar-collapse" id="navbarSupportedContent">            
        <ul class="navbar-nav ml-auto">
            <li class="nav-item"><a href="home.php" class="nav-link"><b><font color="#0BB5FF">Home</font></b></a></li>
            &nbsp;  <li class="nav-item"><a href="Movies1.php" class="nav-link"><b><font color="#0BB5FF">Movies</font></b></a></li>
            &nbsp; <li class="nav-item"><a href="Customer.php" class="nav-link"><b><font color="#0BB5FF">Customer</font></b></a></li>
            &nbsp; <li class="nav-item"><a href="book.php" class="nav-link"><b><font color="#0BB5FF">Booking</font></b></a></li>
            &nbsp; <li class="nav-item"><a href="logout.php" class="nav-link"><b><font color="#0BB5FF">Log out</font></b></a></li>
        </ul>
    </div> 
    </nav>  -->
   
     <div class="d-flex" id="wrapper">
<div class="border-right" id="sidebar-wrapper">
<div class="pl-5 mt-2">
<img src="user_image(1).png" width="100" height="100" class="d-inline-block align-top" alt=""> &nbsp; </br>    
<h5 style="color : rgb(255,127,39);"> &nbsp;Admin Panel</h5>                
<!-- <p class="my-2">CookMate</p> -->

</div>

<div class="sidebar-heading">Dashbord</div>

      <div class="list-group list-group-flush">
      
		<a href="home.php" class="list-group-item list-group-item-action bi bi-house-fill"> Home</a>
        <a href="user.php" class="list-group-item list-group-item-action bi bi-people-fill"> User</a>
        <a href="Managecategories.php" class="list-group-item list-group-item-action ">Categories</a>
        <a href="ManageRecipe.php" class="list-group-item list-group-item-action ">Recipe</a>
        <a href="feedback.php" class="list-group-item list-group-item-action bi bi-people-fill">Feedback</a>
        <a href="logout.php" class="list-group-item list-group-item-action ">Logout</a>
        <!-- <a href="" class="list-group"></a> -->
      </div>
    </div>
	
	<div id="page-content-wrapper">
    