<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Healthlife</title>
    <link rel="stylesheet" href="<?php echo e(URL::asset('bootstrap/css/bootstrap.min.css')); ?>">
    <link rel="stylesheet" href="<?php echo e(URL::asset('css/member/auth/styles.css')); ?>">
</head>

<body>
    <div class="LoginPage">
        <div class="videoplaying">
            <video style=" height:100%;" autoplay muted loop playsinline object-fit="cover">
                <source src="<?php echo e(URL::asset('video/memberWelcomeVideoDesktop.mp4')); ?>" type="video/mp4">
            </video>
        </div>
        <div class="righthand">
            <div class="container">
                <div class="logo"><img src="<?php echo e(URL::asset('img/health_life2.png')); ?>"></div>
                <?php echo $__env->yieldContent('content'); ?>
            </div>
        </div>    
    </div>
    <script src="<?php echo e(URL::asset('js/jquery.min.js')); ?>"></script>
    <script src="<?php echo e(URL::asset('bootstrap/js/bootstrap.min.js')); ?>"></script>
    <script src="<?php echo e(URL::asset('js/script.min.js')); ?>"></script>
</body>
</html>

        <?php /**PATH E:\xampp\htdocs\TestLaravel\resources\views/member/auth/layouts/layout.blade.php ENDPATH**/ ?>