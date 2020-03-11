<!DOCTYPE html>
<html>
<head>
    <title></title>
</head>
<body>
    <p>Login success with admin v2</p>
    <form method="POST" action="<?php echo e(route('admin.logout')); ?>">
        <?php echo csrf_field(); ?>
        <input type='submit' name='logout' value='logout'>
    </form>
</body>
</html><?php /**PATH C:\xampp\htdocs\learncode\TestLaravel\resources\views/admin/home.blade.php ENDPATH**/ ?>