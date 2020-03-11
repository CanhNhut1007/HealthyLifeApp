@extends('doctor.main.layouts.layout_doctor')

@section('content')

<div class="content_div">
    <div id="content_main" class="main_content_div"><small class="form-text text-muted name_table" id="text_name_table">Account Settings</small></div>
        <div class="main_content_div">
            <div>
                <ul class="nav nav-tabs">
                    <li class="nav-item"><a class="nav-link active" role="tab" data-toggle="tab" href="#tab-1">Your Email</a></li>
                    <li class="nav-item"><a class="nav-link" role="tab" data-toggle="tab" href="#tab-2">Your Password<br></a></li>
                    <li class="nav-item"><a class="nav-link" role="tab" data-toggle="tab" href="#tab-3">About HealthLife<br></a></li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane active" role="tabpanel" id="tab-1">
                        <div>
                            <p id="text_name_insurance">Your Email</p>
                            <div>
                                <div class="div_insurance_name div_curent_email">
                                    <p class="para_current_mail">Curent login email<br></p>
                                    <p id="text_current_mai_login" class="para_current_mail text_mail_login" placeholder="Login Email">{{$email}}</p>
                                </div>
                                <form action="{{route('user.updateemail')}}" method="POST">
                                    @csrf()
                                    <div class="div_insurance_name">
                                        <input type="hidden" name="email" value="<?php echo $email; ?>" />
                                        <p class="text_setting">Enter your new login email<br></p><input class="form-control-sm input_setting" type="text" placeholder="Login Email" name="NewEmail" id="id_loginemail"></div>
                                    <div class="div_info_name">
                                        <p class="text_setting">Enter password to change your login email<br></p><input class="form-control-sm input_setting" type="password" placeholder="Password" name="Password" id="id_emailpass"></div>
                                    <div>
                                        @if($errors->any())
                                        <div class="alert alert-danger" text-align="right" style="margin-left:5%; margin-right:5%; margin-top:5%">
                                            @foreach($errors->all() as $err)
                                                <li>{{$err}}</li>
                                            @endforeach
                                        </div>
                                        @endif
                                    </div>
                                    <div class="button_save_cancel">
                                        <button class="btn btn-primary" type="submit" style="margin-top:4%; margin-left:20%;">Save</button>
                                        <button class="btn btn-primary" type="button" style="margin-top:4%; margin-left:20%;" id="btn_cancel1">Cancel</button>
                                    </div>
                                    
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane" role="tabpanel" id="tab-2">
                        <div>
                            <p id="text_name_insurance">Your Password</p>
                            <form action="{{route('user.updatepassword')}}" method="POST">
                                @csrf()
                                <div>
                                    <input type="hidden" name="email" value="<?php echo $email; ?>" />
                                    <div class="div_insurance_name">
                                        <p class="para_current_mail">Enter current password<br></p><input class="form-control-sm input_setting" type="password" placeholder="Current Password" name="Password" id="id_currentpass"></div>
                                    <div class="div_insurance_name">
                                        <p class="text_setting">Enter new password<br></p><input class="form-control-sm input_setting" type="password" placeholder="New Password" name="NewPassword" id="id_newpass"></div>
                                    <div class="div_info_name">
                                        <p class="text_setting">Confirm new password<br></p><input class="form-control-sm input_setting" type="password" placeholder="Confirm Password" name="password_confirmation" id="id_confirmpass"></div>
                                    <div>
                                        @if($errors->any())
                                        <div class="alert alert-danger" text-align="right" style="margin-left:5%; margin-right:5%; margin-top:5%">
                                            @foreach($errors->all() as $err)
                                                <li>{{$err}}</li>
                                            @endforeach
                                        </div>
                                        @endif
                                    </div>
                                    <div class="button_save_cancel">
                                        <button class="btn btn-primary" type="submit" style="margin-top:4%; margin-left:20%;">Save</button>
                                        <button class="btn btn-primary" type="button" style="margin-top:4%; margin-left:20%;" id="btn_cancel2">Cancel</button>
                                    </div>                                    
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="tab-pane" role="tabpanel" id="tab-3">
                        <div>
                            <p id="text_name_insurance">About HealthLife</p>
                            <div>
                                <div class="div_insurance_name"><a class="about_health" href="#"><br>Terms of Service<br><br></a><a class="about_health" href="#">Privacy Policy</a></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
@stop

<script>
        $(document).ready(function() {
            $('#btn_cancel1').click(function() {
                $('#id_loginemail').val("");
                $('#id_emailpass').val("");
            });
            $('#btn_cancel2').click(function() {
                $('#id_currentpass').val("");
                $('#id_newpass').val("");
                $('#id_confirmpass').val("");
            });
        });
    </script>