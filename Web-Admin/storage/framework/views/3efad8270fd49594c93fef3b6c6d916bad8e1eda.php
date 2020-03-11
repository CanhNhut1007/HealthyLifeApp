<!DOCTYPE html>
<html>
<head>
    <title></title>
</head>
<body>
    <p>Login success with user v2</p>
    <form method="POST" action="<?php echo e(route('user.logout')); ?>">
    <?php echo e(csrf_field()); ?>

        <input type='submit' name='logout' value='logout'>
    </form>
</body>
</html><?php /**PATH C:\xampp\htdocs\learncode\TestLaravel\resources\views/member/home.blade.php ENDPATH**/ ?>