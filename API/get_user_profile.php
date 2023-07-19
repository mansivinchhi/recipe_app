<?php
    include "connection.php";
    $data = array();
    if(isset($_REQUEST['u_id'])) 
    {
        $u_id = $_REQUEST['u_id'];

        $query =$conn->prepare("SELECT * FROM `user` WHERE `u_id` = ?");
        $query->bindParam(1,$u_id);
        $res=$query->execute();
        $count=$query->rowCount();
        
        if($count)
        {
            foreach ($query->fetchAll() as $row)
            {
                // echo json_encode ($row);
                echo json_encode(['msg'=>"success","success"=>true,"data"=>$row]);
            }
         
        }
        else
        {
            echo json_encode(['msg'=>"Something wrong!","success"=>false]);
        }	
    }
    else
    {
        echo json_encode(['msg'=>"Paramter missing!","success"=>false]);
        
    }
   


   
?>