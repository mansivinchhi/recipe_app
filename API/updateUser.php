<?php
    include "connection.php";
    $data = array();
    if(isset($_REQUEST['u_id'])) 
    {
        $u_id = $_REQUEST['u_id'];
        $u_name = $_REQUEST["u_name"];
        $u_address = $_REQUEST["u_address"];
        $u_city = $_REQUEST["u_city"];
        $u_state = $_REQUEST["u_state"];
        $u_pincode = $_REQUEST["u_pincode"];
        $u_mobile = $_REQUEST["u_mobile"];
        $u_email = $_REQUEST["u_email"];
        
        $update_query = "UPDATE `user` SET `u_name`='$u_name',`u_address`='$u_address',`u_city`='$u_city',`u_state`='$u_state',`u_pincode`=$u_pincode,`u_mobile`=$u_mobile,`u_email`='$u_email' WHERE `u_id` = $u_id";
        $stmt = $conn->prepare($update_query);
        $res=$stmt->execute();
            
        if($res)
        {
            $data['msg'] = "Profile Updated!";
            $data['success']=true;
        }
        else
        {
            $data['msg'] = "Profile Not Updated!";
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