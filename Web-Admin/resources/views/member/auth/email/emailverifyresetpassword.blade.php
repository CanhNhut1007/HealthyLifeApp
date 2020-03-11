<html>
    <head>
        <title>Reset Password</title>
    </head>
    <body>
        <h4>Hi, </h4>
        <p>We just noticed that you want to reset password. </p>
        <p>Your reset password code: <?php echo   $user["user"]["codeverify"]; ?></p>
        <p>To complete the reset password, enter your reset password code on this device.</p>
        <p>Thank you for using our application!</p>
    </body>
</html>