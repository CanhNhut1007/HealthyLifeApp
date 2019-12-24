<?php 
 
	/*
	* Created by Belal Khan
	* website: www.simplifiedcoding.net 
	* Retrieve Data From MySQL Database in Android
	*/
	
	//database constants
	define('DB_HOST', 'localhost');
	define('DB_USER', 'root');
	define('DB_PASS', '');
	define('DB_NAME', 'myweb');
	
	//connecting to database and getting the connection object
	$conn = new mysqli(DB_HOST, DB_USER, DB_PASS, DB_NAME);
	
	//Checking if any error occured while connecting
	if (mysqli_connect_errno()) {
		echo "Failed to connect to MySQL: " . mysqli_connect_error();
		die();
	}
	
	//creating a query
	$stmt = $conn->prepare("SELECT AccountID, AccountEmail, TypeOfAccountID, HashPassword FROM account WHERE AccountID = 'ID00000006';");
	
	//executing the query 
	$stmt->execute();
	
	//binding results to the query 
	$stmt->bind_result($AccountID, $AccountEmail, $TypeOfAccountID, $HashPassword);
	
	$products = array(); 

	//traversing through all the result 
	if($stmt->fetch()){
		$temp = array();
		$temp['AccountID'] = $AccountID; 
		$temp['AccountEmail'] = $AccountEmail; 
		$temp['TypeOfAccountID'] = $TypeOfAccountID; 
		$temp['HashPassword'] = $HashPassword; 
		//array_push($products, $temp);
	}
	
	//displaying the result in json format 
	echo json_encode($temp);