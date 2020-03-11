<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>test</title>
    <link rel="stylesheet" href="<?php echo e(URL::asset('bootstrap/css/bootstrap.min.css')); ?>">
    <link rel="stylesheet" href="<?php echo e(URL::asset('css/styles.css')); ?>">
    <link rel="stylesheet" href="<?php echo e(URL::asset('css/styles.min.css')); ?>">
  </head>

<body>
    <nav class="navbar navbar-light navbar-expand-md" id="nav_home" src="<?php echo e(URL::asset('image/HealthLife_v2.png')); ?>">
        <div class="container-fluid"><img id="logo_img" src="<?php echo e(URL::asset('image/HealthLife_v2.png')); ?>">
            <div  id="navcol-1" class="collapse navbar-collapse">
                <ul class="nav navbar-nav ml-auto">
                    <li class="nav-item" role="presentation"><a class="nav-link active" href="#">Home</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link" href="#">My Record</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link" href="#">Notifications</a></li>
                    <li class="nav-item dropdown"><a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="false" href="#">Account</a>
                        <div class="dropdown-menu" role="menu"><a class="dropdown-item" role="presentation" href="#">Profile</a><a class="dropdown-item" role="presentation" href="#">Settings</a><a class="dropdown-item" role="presentation" href="#">Support</a><a class="dropdown-item" role="presentation"
                                href="#">Log out</a></div>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div id="content_div" class="content_div">
        <div id="content_main" class="main_content_div"><small class="form-text text-muted name_table" id="text_name_table">Account</small></div>
        <div class="main_content_div">
            <div id="account-version_div" class="div_parent_acc">
                <div class="col-6 column_acc" id="column_name_account"><img id="icon_acc" src="<?php echo e(URL::asset('image/icon-account.png')); ?>" width="64" height="64">
                    <div class="div_chi_acc-ver"><small class="form-text text-muted" id="text_name_account">Nguyet</small><small class="form-text text-muted edit_profile" id="text_editprofile">Edit profile</small></div>
                </div>
                <div class="col column_acc" id="column_healthlife"><img src="<?php echo e(URL::asset('image/organization_logo_url.png')); ?>">
                    <div class="div_chi_acc-ver"><small class="form-text text-muted" id="text_healthlife">HealthLife</small><small class="form-text text-muted">Basic Account<br></small></div>
                </div>
            </div>
            <div class="div_parent_acc">
                <div class="col"><small class="form-text text-muted" id="text_language">Display Language</small></div>
                <div class="col"><select class="select_language"><option value="12" selected="">English (US)</option></select></div>
            </div>
            <div class="div_parent_sslt">
                <div>
                    <div class="col column_sslt" src="<?php echo e(URL::asset('image/icon-setting.png')); ?>"><img class="img_sslt" src="<?php echo e(URL::asset('image/icon-setting.png')); ?>" width="40" height="40">
                        <div class="div_text_sslt"><a class="link_sslt" href="#">Settings</a><small class="form-text text-muted">Configure your account your way</small></div>
                    </div>
                </div>
                <div>
                    <div class="col column_sslt" src="<?php echo e(URL::asset('image/icon-setting.png')); ?>"><img class="img_sslt" src="<?php echo e(URL::asset('image/icon-help.png')); ?>" width="40" height="40">
                        <div class="div_text_sslt"><a class="link_sslt" href="#">Support</a><small class="form-text text-muted">24/7 customer support</small></div>
                    </div>
                </div>
                <div>
                    <div class="col column_sslt" src="assets/img/icon-setting.png"><img class="img_sslt" src="<?php echo e(URL::asset('image/icon-logout.png')); ?>" width="40" height="40">
                        <div class="div_text_sslt"><a class="link_sslt" href="#">Log out</a><small class="form-text text-muted">Securely log out of the site</small></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="<?php echo e(URL::asset('js/jquery.min.js')); ?>"></script>
    <script src="<?php echo e(URL::asset('bootstrap/js/bootstrap.min.js')); ?>"></script>
</body>

</html><?php /**PATH C:\xampp\htdocs\Laravel\TestLaravel\resources\views/Account.blade.php ENDPATH**/ ?>