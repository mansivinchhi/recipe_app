<?php
    include "connection.php";
    $data = array();
   if(isset($_REQUEST['r_id']))  
    {
        $r_id = $_REQUEST["r_id"];
        $u_id = $_REQUEST["u_id"];
        $f_description = $_REQUEST["f_description"];
        $f_rating = $_REQUEST["f_rating"];

        
        // echo $r_id;
        // echo $u_id;
        // echo $f_description;
        // echo $f_rating;
        
        $insert_query = "INSERT INTO `feedback`(`r_id`, `u_id`, `f_description`, `f_rating`) VALUES ($r_id,$u_id,'$f_description',$f_rating)";
        $stmt = $conn->prepare($insert_query);
        $res=$stmt->execute();
        // $stmt = $conn->prepare($insert_query);
        // $stmt->execute();
        // $res = $stmt->rowCount();
        if($res)
        {
            $data['msg'] = "Your Feedback has been Submitted..";
            $data['success']=true;
        }
        else
        {
            $data['msg'] = "Your Feedback is not Submitted..";
            $data['success']=false;
        }	
    }
    else
    {
        $data['msg'] = "Paramter missing!";
        $data['success']=false;
    }
    echo json_encode($data);
?>