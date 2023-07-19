<?php
    include "connection.php";
    $data = array();
    if(isset($_REQUEST['u_email']) && isset($_REQUEST["u_password"])) 
    {
        $u_email = $_REQUEST["u_email"];
        $u_password =$_REQUEST["u_password"];
        
                    
            $query = $conn->prepare("SELECT * from user WHERE u_email = ?");
            $query->bindParam(1,$u_email);
            $query->execute();


            foreach ($query->fetchAll() as $row) {
                
               
                
                $res = password_verify($u_password,$row['u_password']);
                    
            if($res)
            {
                    echo json_encode(['success' => true,'msg' => "Congratulation login Successfully!",'u_id'=>$row['u_id']]);             
            }
            else
            {
                    echo json_encode(['success'=> false,'msg'=>"Opps login Failed!"]);
            }
                    
   }
}
else{
        echo json_encode(['msg' => "No Parameter"]); 
}
?>

