<?php
define("DB_SERVER",'localhost');
define('DB_USER','root');
define("DB_PASSWORD",'12345');
define("DB_NAME",'studentinfo');

$conn=mysqli_connect(DB_SERVER,DB_USER,DB_PASSWORD,DB_NAME);

if($conn===false)
{
	die("error in database connection".mysqli_connect_error());
}
else
{
	echo "database connected";
	 
}
?>
