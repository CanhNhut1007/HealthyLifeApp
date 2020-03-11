<html>
    <head>
        <title>Verify account</title>
    </head>
    <body>
        <h4>Hi, </h4>
        <p>We just noticed that you created a new account. You will need to activate your account to sign in into this account.</p>
        <p>Verifycation code: <?php echo   $user["user"]["codeverify"]; ?></p>
        <p>To complete the active, enter the verification code on this device.</p>
        <p>Thank you for using our application!</p>
    </body>
</html>