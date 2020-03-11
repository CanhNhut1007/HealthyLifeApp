<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>HealthLife</title>
    <link rel="stylesheet" href="<?php echo e(URL::asset('bootstrap/css/bootstrap.min.css')); ?>">
    <link rel="stylesheet" href="<?php echo e(URL::asset('fonts/font-awesome.min.css')); ?>">
    <link rel="stylesheet" href="<?php echo e(URL::asset('css/member/main/styles.min.css')); ?>">
    <meta name="csrf-token" content="<?php echo e(csrf_token()); ?>" />
</head>

<body>
    <?php echo $__env->make('member.main.layouts.layout_navbar', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?>
    
    <?php echo $__env->yieldContent('content'); ?>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="<?php echo e(URL::asset('js/member/script.js')); ?>"></script>
    <script src="<?php echo e(URL::asset('bootstrap/js/bootstrap.min.js')); ?>"></script>
</body>

</html><?php /**PATH C:\xampp\htdocs\learncode\TestLaravel\resources\views/member/main/layouts/layout_home.blade.php ENDPATH**/ ?>