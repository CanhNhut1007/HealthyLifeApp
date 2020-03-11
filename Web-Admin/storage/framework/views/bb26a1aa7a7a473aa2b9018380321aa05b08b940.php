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
        <div class="container-fluid"><img id="logo_img" src="<?php echo e(URL::asset('image/HealthLife_v2.png')); ?>"><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse"
                id="navcol-1">
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
        <div id="content_main" class="main_content_div"><small class="form-text text-muted name_table" id="text_name_table">Profile</small></div>
        <div class="main_content_div">
            <div>
                <ul class="nav nav-tabs">
                    <li class="nav-item"><a class="nav-link active" role="tab" data-toggle="tab" href="#tab-1">About</a></li>
                    <li class="nav-item"><a class="nav-link" role="tab" data-toggle="tab" href="#tab-2">Contact Information<br></a></li>
                    <li class="nav-item"><a class="nav-link" role="tab" data-toggle="tab" href="#tab-3">Insurance<br></a></li>
                    <li class="nav-item"><a class="nav-link" role="tab" data-toggle="tab" href="#tab-4">Allergies&nbsp;<br></a></li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane active" role="tabpanel" id="tab-1">
                        <div>
                            <p id="text_name_about">About</p>
                            <div class="div_about_flex">
                                <div class="div_info_name">
                                    <p class="text_about">First name</p><input class="form-control-sm input_about" type="text" placeholder="First name"></div>
                                <div class="div_info_name">
                                    <p class="text_about">Middle name</p><input class="form-control-sm input_about" type="text" placeholder="Middle name"></div>
                                <div class="div_info_name">
                                    <p class="text_about">Last name</p><input class="form-control-sm input_about" type="text" placeholder="Last name"></div>
                            </div>
                            <div>
                                <p class="div_info_name text_about">Date of Birth</p>
                                <div class="div_about_flex"><input class="form-control-sm input_text_date input_about" type="text" placeholder="Date">
                                    <p>/</p><input class="form-control-sm input_text_date input_about" type="text" placeholder="Month">
                                    <p>/</p><input class="form-control-sm input_text_date input_about" type="text" placeholder="Year"></div>
                            </div>
                            <div>
                                <p class="div_info_name text_about">Biological sex<br></p>
                                <div id="id_radio_sex" class="div_about_flex">
                                    <div class="form-check div_radio_sex"><input class="form-check-input" type="radio" name="gender" checked="checked"><label class="form-check-label" for="formCheck-1" >Male</label></div>
                                    <div class="form-check div_radio_sex"><input class="form-check-input" type="radio" name="gender"><label class="form-check-label" for="formCheck-2">Female</label></div>
                                </div>
                            </div>
                            <div>
                                <p class="div_info_name text_about">Nationality</p>
                                <div><select class="select_about"><option value="12" selected="">English</option><option value="12" selected="">French</option><option value="12" selected="">German</option><option value="12" selected="">Japanese</option><option value="12" selected="">Korean</option><option value="12" selected="">Russian</option><option value="12" selected="">Spanish</option><option value="13">Chinese</option><option value="14">Vietnamese</option></select></div>
                            </div><button class="btn btn-primary" type="button">Save</button></div>
                    </div>
                    <div class="tab-pane" role="tabpanel" id="tab-2">
                        <div>
                            <p id="text_name_contact">Contact Infomation</p>
                            <div>
                                <div class="div_info_name">
                                    <p class="text_contact">Email</p><input class="form-control-sm input_contact" type="text" placeholder="Email"></div>
                                <div class="div_info_name">
                                    <p id="text_phone" class="text_contact">Phone</p>
                                    <div><input class="form-control-sm input_phone_pre" type="text" placeholder="+1"><input class="form-control-sm input_phone" type="text" placeholder="Phone number"></div>
                                </div>
                                <div>
                                    <p class="text_address">Address</p>
                                    <div class="div_info_name">
                                        <p class="text_contact address">Address</p><input class="form-control-sm input_contact address" type="text" placeholder="Address"></div>
                                    <div>
                                        <p class="text_contact address">City</p><input class="form-control-sm input_contact address" type="text" placeholder="Date"></div>
                                    <div class="div_contact_flex">
                                        <div class="div_pro_pos">
                                            <p class="text_contact address">State/Province<br></p><input class="form-control-sm input_pro_pos" type="text" placeholder="Month"></div>
                                        <div class="div_pro_pos">
                                            <p class="text_contact address">Postal code<br></p><input class="form-control-sm input_pro_pos" type="text" placeholder="Year"></div>
                                    </div>
                                    <div>
                                        <p class="text_contact address">Country/Region<br></p><select class="select_contact"><option value="12" selected="">English</option><option value="12" selected="">French</option><option value="12" selected="">German</option><option value="12" selected="">Japanese</option><option value="12" selected="">Korean</option><option value="12" selected="">Russian</option><option value="12" selected="">Spanish</option><option value="13">Chinese</option><option value="14">Vietnamese</option></select></div>
                                </div>
                                <div>
                                    <p class="text_address">Emergency contact<br></p>
                                    <div><input class="form-control-sm input_contact address" type="text" placeholder="Name">
                                        <div><input class="form-control-sm input_phone_pre input_contact address" type="text" placeholder="+1"><input class="form-control-sm input_phone input_contact address" type="text" id="tab-2" placeholder="Phone number"></div>
                                        <input
                                            class="form-control-sm input_contact address" type="text" placeholder="Relationship"></div>
                                </div>
                            </div>
                        </div><button class="btn btn-primary" type="button">Save</button></div>
                    <div class="tab-pane" role="tabpanel" id="tab-3">
                        <div>
                            <p id="text_name_insurance">Insurace</p>
                            <div>
                                <div class="div_insurance_name">
                                    <p class="text_insurance">Health Insurance Card Code</p><input class="form-control-sm input_insurance" type="text" placeholder="Card Code"></div>
                                <div class="div_info_name">
                                    <p class="text_about">Hospital Register</p><input class="form-control-sm input_insurance" type="text" placeholder="Hopital"></div>
                            </div>
                            <div class="div_ins_flex">
                                <div>
                                    <p class="div_info_name text_about">Health Insurance MFD</p>
                                    <div class="div_insurance_flex date_mfd"><input class="form-control-sm input_text_insdate input_insurance" type="text" placeholder="Date">
                                        <p>/</p><input class="form-control-sm input_text_insdate input_insurance" type="text" placeholder="Month">
                                        <p>/</p><input class="form-control-sm input_text_insdate input_insurance" type="text" placeholder="Year"></div>
                                </div>
                                <div>
                                    <p class="div_info_name text_about">Health Insurance EXP<br></p>
                                    <div class="div_insurance_flex date_mfd"><input class="form-control-sm input_text_insdate input_insurance" type="text" placeholder="Date">
                                        <p>/</p><input class="form-control-sm input_text_insdate input_insurance" type="text" placeholder="Month">
                                        <p>/</p><input class="form-control-sm input_text_insdate input_insurance" type="text" placeholder="Year"></div>
                                </div>
                            </div><button class="btn btn-primary" type="button">Save</button></div>
                    </div>
                    <div class="tab-pane" role="tabpanel" id="tab-4">
                        <div>
                            <p id="text_name_insurance">Insurace</p>
                            <div>
                                <div class="div_insurance_name">
                                    <p class="text_insurance">Health Insurance Card Code</p><input class="form-control-sm input_insurance" type="text" placeholder="Card Code"></div>
                                <div class="div_info_name">
                                    <p class="text_about">Hospital Register</p><input class="form-control-sm input_insurance" type="text" placeholder="Hopital"></div>
                            </div>
                            <div class="div_ins_flex">
                                <div>
                                    <p class="div_info_name text_about">Health Insurance MFD</p>
                                    <div class="div_insurance_flex date_mfd"><input class="form-control-sm input_text_insdate input_insurance" type="text" placeholder="Date">
                                        <p>/</p><input class="form-control-sm input_text_insdate input_insurance" type="text" placeholder="Month">
                                        <p>/</p><input class="form-control-sm input_text_insdate input_insurance" type="text" placeholder="Year"></div>
                                </div>
                                <div>
                                    <p class="div_info_name text_about">Health Insurance EXP<br></p>
                                    <div class="div_insurance_flex date_mfd"><input class="form-control-sm input_text_insdate input_insurance" type="text" placeholder="Date">
                                        <p>/</p><input class="form-control-sm input_text_insdate input_insurance" type="text" placeholder="Month">
                                        <p>/</p><input class="form-control-sm input_text_insdate input_insurance" type="text" placeholder="Year"></div>
                                </div>
                            </div><button class="btn btn-primary" type="button">Save</button></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="<?php echo e(URL::asset('js/jquery.min.js')); ?>"></script>
    <script src="<?php echo e(URL::asset('bootstrap/js/bootstrap.min.js')); ?>"></script>
</body>

</html><?php /**PATH C:\xampp\htdocs\Laravel\TestLaravel\resources\views/Profile.blade.php ENDPATH**/ ?>