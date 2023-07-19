<?php
    include "connection.php";
    $data = array();
    if(isset($_REQUEST['u_email'])) 
    {
        $u_name = $_REQUEST["u_name"];
        $u_email = $_REQUEST["u_email"];
        $u_password = password_hash($_REQUEST["u_password"],PASSWORD_DEFAULT);
        
        $insert_query = 
            "INSERT INTO `user`(`u_name`,`u_email`, `u_password`) values ('$u_name','$u_email','$u_password')";
        $stmt = $conn->prepare($insert_query);
        $res=$stmt->execute();

        if($res)
        {
            $data['msg'] = "Congratulation registeration Successfully!";
            $data['success']=true;
        }
        else
        {
            $data['msg'] = "Opps registeration Failed !";
            $data['success']=false;
        }	
    }
    else
    {
        $data['msg'] = "Paramter missing!";
        $data['succes']=false;
    }
    echo json_encode($data);
?>