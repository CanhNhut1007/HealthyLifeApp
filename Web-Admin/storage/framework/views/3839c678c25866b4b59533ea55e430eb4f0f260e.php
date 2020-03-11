<!DOCTYPE html>
<html>
    <head>
        <title>Home</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="<?php echo e(URL::asset('css/homecss.css')); ?>">
    </head>
    <body>
        <div class="HomePage">
            <div class="header">
                <div class="bar">
                    <div class="contentBar">
                        <div class="logo">
                            <img src="<?php echo e(URL::asset('image/HealthLife_v2.png')); ?>" alt="logo">
                        </div>
                        <div class="options">
                            <nav>
                                <ul>
                                    <!-- <li class="nav">
                                        <a id="a-bar" role="button" tabindex="0" href="">Group</a>
                                    </li>
                                    <li class="nav">
                                        <a id="a-bar" role="button" href="">Individuals</a>
                                    </li> -->
                                    <li class="subnav">
                                        <div class="div-subnav">
                                            <a id="a-bar" role="button" tabindex="0" href="#">Sign up</a>
                                            <div class="subnav-content">
                                                <ul>
                                                    <li>
                                                        <a id="a-bar" role="button" tabindex="0" href="<?php echo e(URL::asset('sign-up')); ?>">For Patient</a>
                                                    </li>
                                                </ul>    
                                            </div>
                                        </div>
                                        <div class="div-subnav">
                                            <a id="a-bar" role="button" tabindex="0" href="#">Log in</a>
                                            <div class="subnav-content">
                                                <ul>
                                                    <li>
                                                        <a id="a-bar" role="button" tabindex="0" href="<?php echo e(URL::asset('login')); ?>">For Patient</a>
                                                    </li>
                                                    <li>
                                                        <a id="a-bar" role="button" tabindex="0" href="Login.html">For Doctor</a>
                                                    </li>
                                                </ul>    
                                            </div>
                                        </div>
                                        
                                    </li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="picture">
                    <img id="picturebg" src="<?php echo e(URL::asset('image/home_background.jpg')); ?>">
                </div>
            </div>
        </div>
    </body>
</html><?php /**PATH C:\xampp\htdocs\Laravel\TestLaravel\resources\views/Home.blade.php ENDPATH**/ ?>