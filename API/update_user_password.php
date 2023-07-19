<?php
    include "connection.php";
    $data = array();

    if(isset($_REQUEST['u_id'])) 
    { 
		$u_id = $_REQUEST['u_id'];
        $u_password = $_REQUEST['u_password'];
        $query = "SELECT * FROM `user` WHERE `u_id` = $u_id";
		
        $result_pass = $conn->query($query);
        $result_pass->execute();
        $res = "";
        foreach ($result_pass->fetchAll() as $row)
            $res = password_verify($u_password,$row['u_password']);
		
		
        if($res)
        {

            $new_password = password_hash($_REQUEST['u1_password'],PASSWORD_DEFAULT);
            //$old_password = password_hash($_REQUEST['u_password'],PASSWORD_DEFAULT);
           // echo $new_password;
			//exit;
        
			//if($old_password  != $new_password)
			if(!password_verify($_REQUEST['u_password'],$new_password))
            {	
				$u_id = $_REQUEST['u_id'];
                $update_query = "UPDATE `user` SET `u_password`='$new_password' WHERE `u_id` = $u_id";
                $stmt = $conn->prepare($update_query);
                $res=$stmt->execute();
                
                if($res)
                {
                    $data['msg'] = "Password updated!";
                    $data['success']=true;
                }
                else
                {
                    $data['msg'] = "password Not updated!";
                    $data['success']=false;
                }
            }
            else
            {
		
                $data['msg'] = "old password and new password are same.. Try again !!!";
                $data['success']=false;    
            }
        }
        else
        {
            $data['msg'] = "Old password not match!!";
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