    <?php
    include "connection.php";
    $data = array();
    if(isset($_REQUEST['c_id'])) 
    {
        $c_id = $_REQUEST["c_id"];
       
        // $query = "SELECT r.r_name, r.r_image, r.r_ingredients, r.r_instruction, c.c_name FROM recipe r, categories c where c.c_id = $c_id and r.c_id = c.c_id";
        $query = "SELECT * FROM recipe where c_id = $c_id";
        $stmt = $conn->prepare($query);
      
        $stmt->execute();	
        if($stmt->rowCount())
        {
            $row = $stmt->fetchAll(PDO::FETCH_ASSOC);
            //$data['data'] = $row;
            $data=$row;
        }  
        else
        {
            $data['status']="0";
            $data['msg']="No Recipe Avilable";
        }

    }
    else
    {
        $data['msg'] = "Paramter missing!";
        $data['succes']=false;
    }
    echo json_encode($data);
?>