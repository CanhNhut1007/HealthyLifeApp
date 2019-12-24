<?php 
$con=mysqli_connect("localhost", "root", "");
mysqli_select_db($con,"myweb"); 

$email = $_POST['email'];
$pass = $_POST['pass'];

$response = array();

$qr = "SELECT `AccountID`, `AccountEmail` FROM `account` WHERE AccountEmail='$email' and HashPassword='$pass'";
$query=mysqli_query($con,$qr); 

if ($query) {
	if ($qr = mysqli_fetch_assoc($query)) {
				echo json_encode($qr);
			}
	
	//echo json_encode($qr);
}
else {
	echo "that bai";
}


?>