@extends('doctor.main.layouts.layout_doctor')

@section('content')

<div id="content_div" class="content_div">
    <div id="content_main" class="main_content_div"><small class="form-text text-muted name_table" id="text_name_table">Account</small></div>
    <div class="main_content_div">
        <div id="account-version_div" class="div_parent_acc">
            <div class="col-6 column_acc" id="column_name_account"><img id="icon_acc" src="{{URL::asset('img/icon-account.png')}}" width="64" height="64">
                <div class="div_chi_acc-ver"><small class="form-text text-muted" id="text_name_account">Dr.{{$employeename}}</small><a id="text_editprofile" class="edit_profile" href="{{route('doctor.profile')}}">Edit profile</a></div>
            </div>
            <div class="col column_acc" id="column_healthlife"><img class="img_logo_h" src="{{URL::asset('img/organization_logo_url.png')}}">
                <div id="div_info_htext" class="div_chi_acc-ver"><small class="form-text text-muted" id="text_healthlife">HealthLife</small><small class="form-text text-muted">Basic Account<br></small></div>
            </div>
        </div>
        <div class="div_parent_acc">
            <div class="col"><small class="form-text text-muted" id="text_language">Display Language</small></div>
            <div class="col"><select class="select_language"><option value="12" selected="">English (US)</option></select></div>
        </div>
        <div class="div_parent_sslt">
            <div>
                <div class="col column_sslt" src="assets/img/icon-setting.png"><img class="img_sslt" src="{{URL::asset('img/icon-setting.png')}}" width="40" height="40">
                    <div class="div_text_sslt"><a class="link_sslt" href="{{route('doctor.setting')}}">Settings</a><small class="form-text text-muted">Configure your account your way</small></div>
                </div>
            </div>
            <div>
                <div class="col column_sslt" src="assets/img/icon-setting.png"><img class="img_sslt" src="{{URL::asset('img/icon-help.png')}}" width="40" height="40">
                    <div class="div_text_sslt"><a class="link_sslt" href="{{route('doctor.support')}}">Support</a><small class="form-text text-muted">24/7 customer support</small></div>
                </div>
            </div>
            <div>
                <div class="col column_sslt" src="assets/img/icon-setting.png"><img class="img_sslt" src="{{URL::asset('img/icon-logout.png')}}" width="40" height="40">
                    <div class="div_text_sslt"><a class="link_sslt" href="{{route('doctor.logout')}}">Log out</a><small class="form-text text-muted">Securely log out of the site</small></div>
                </div>
            </div>
        </div>
    </div>
</div>
@stop