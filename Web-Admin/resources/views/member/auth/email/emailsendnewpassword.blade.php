<html>
    <head>
        <title>Reset Password</title>
    </head>
    <body>
        <h4>Hi, </h4>
        <p>As you requested, your password has now been reset. </p>
        <p>Your new details are as follows:<p>
        <br>
        <p>Email: <?php echo  $user["user"]["email"]; ?></p>
        <p>Password: <?php echo  $user["user"]["password"]; ?></p>
        <br>
        <p>Thank you for using our application!</p>
    </body>
</html>