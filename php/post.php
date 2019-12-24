<?php 
$con=mysqli_connect("localhost", "root", "");
mysqli_select_db($con,"myweb"); 

$email = $_POST['email'];
$pass = $_POST['pass'];

$qr = "INSERT INTO account(AccountID, AccountEmail, TypeOfAccountID, HashPassword) VALUES('ID00000007', '$email', 'TYPEID03', '$pass')";
$query=mysqli_query($con,$qr); 

if ($query) {
	echo "thanh cong";
}
else {
	echo "that bai";
}


?>