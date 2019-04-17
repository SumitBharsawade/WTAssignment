<?php
require_once 'dbconnect.php';

$username=$password=$firstname=$lastname=$gender=$email=$course=$mobile="";

if(isset($_POST['submit'])){

    //Access the values of input fields
    $username = trim($_POST['username']);
    $password = trim($_POST['password']);
    $firstname = trim($_POST['firstname']);
    $lastname = trim($_POST['lastname']);
    $gender = trim($_POST['gender']);
    $email = trim($_POST['email']);
    $course = trim($_POST['course']);
    $mobile = trim($_POST['mobile']);

    //Define SQL query
    $sql = "INSERT INTO student(username,password,firstname,lastname,gender,email,course,mobile)values('$username','$password','$firstname','$lastname','$gender','$email','$course','$mobile')";

    //Execute SQL Query
    $query = mysqli_query($conn,$sql);

    if($query){
       echo "<script>alert('Your are registered successfully!!')</script>";
    }
    else{
        echo "<script>alert('Sorry!! Error!!')</script>";
    }

}
else{

}

?>
<!DOCTYPE html>
<html>
<head>
    <title>Registration Form</title>
</head>
<body>
<h3>Student Registration Form</h3>
<hr>
<form action="<?php htmlspecialchars($_SERVER["PHP_SELF"])?>" method="POST">
    <label>Username</label><br>
    <input type="text" name="username" placeholder="Enter your username"><br>
    <label>Password</label><br>
    <input type="password" name="password" placeholder="Enter your password"><br>
    <label>Firstname</label><br>
    <input type="text" name="firstname" placeholder="Enter your firstname"><br>
    <label>Lastname</label><br>
    <input type="text" name="lastname" placeholder="Enter your lastname"><br>
    <label>Gender</label><br>
    <input type="radio" name="gender" value="Male">Male
    <input type="radio" name="gender" value="Female">Female<br>
    <label>Email</label><br>
    <input type="email" name="email" placeholder="Enter your email address"><br>
    <label>Course</label><br>
    <select name="course">
        <option>Select Course</option>
        <option>SE Computer</option>
        <option>TE Computer</option>
        <option>BE Computer</option>
    </select><br>
    <label>Mobile Number</label><br>
    <input type="text" name="mobile" placeholder="Enter your mobile number"><br>
    <input type="submit" name="submit" value="Submit">
    <input type="reset" name="reset" value="Reset">
    <p>Already Registered? <a href="login.php">Sign In</a></p>
</form>
</body>
</html>
