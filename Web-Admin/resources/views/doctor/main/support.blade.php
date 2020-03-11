@extends('doctor.main.layouts.layout_doctor')

@section('content')

<div class="content_div">
    <div id="content_main" class="main_content_div"><small class="form-text text-muted name_table" id="text_name_table">Help &amp; Support</small></div>
</div>
<div class="features-boxed block_support">
    <div class="container">
        <div class="intro">
            <p class="text-center">If you have any quesion, please contract with us. We will answer in 24h. Thank you!</p>
        </div>
        <div class="row justify-content-center features">
            <div class="col-sm-6 col-md-5 col-lg-4 item">
                <div class="box"><i class="fa fa-envelope-o icon"></i>
                    <h3 class="name">Email</h3>
                    <p class="description">healthlife.support@gmail.com</p>
                </div>
            </div>
            <div class="col-sm-6 col-md-5 col-lg-4 item">
                <div class="box"><i class="fa fa-facebook icon"></i>
                    <h3 class="name">Facebook</h3>
                    <p class="description">https://facebook.com</p>
                </div>
            </div>
            <div class="col-sm-6 col-md-5 col-lg-4 item">
                <div class="box"><i class="fa fa-phone icon"></i>
                    <h3 class="name">Mobile</h3>
                    <p class="description">+84123456789</p>
                </div>
            </div>
        </div>
    </div>
</div>
@stop