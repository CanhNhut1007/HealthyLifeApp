<html>

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no" />
    <title>test</title>
    <link rel="stylesheet" href="{{URL::asset('bootstrap/css/bootstrap.min.css')}}">
    <link rel="stylesheet" href="{{URL::asset('fonts/font-awesome.min.css')}}">
    <link rel="stylesheet" href="{{URL::asset('css/member/main/styles.min.css')}}">
</head>

<body>
    <nav class="navbar navbar-light navbar-expand-md" id="nav_home" src="{{URL::asset('img/HealthLife_v2.png')}}">
        <div class="container-fluid"><img class="logo_img" src="{{URL::asset('img/HealthLife_v2.png')}}" /><button data-toggle="collapse" data-target="#navcol-1" class="navbar-toggler"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse"
                id="navcol-1">
                <ul class="nav navbar-nav ml-auto">
                    <li role="presentation" class="nav-item"></li>
                    <li role="presentation" class="nav-item"></li>
                    <li role="presentation" class="nav-item"></li>
                    <li role="presentation" class="nav-item"></li>
                </ul>
            </div>
        </div>
    </nav>
    <div>
    @if(session()->has('success'))
        <div class="text-success" role="alert">
            <p>{{ session('success') }}</p>
        </div>
    @elseif(session()->has('error'))
        <div class='text-danger' role="alert">
            <p>{{ session('error') }}</p>
        </div>
    @endif
        <div id="welcome" style="margin-left:23%;margin-right:23%;background:#fff;padding:5%">
            <p id="p_welcome" style="font-weight:700;font-size:xx-large;text-align:center;margin-top:6%;margin-bottom:3%">INFORMATION</p>
            <form action="{{route('user.information')}}" method="POST">
            {{csrf_field()}}
            <div>
                <input type="hidden" name="email" value="<?php echo session()->get( 'email' ); ?>" />
                <p class="p_title" style="text-align:center;font-size:20px;color:#000;margin-top:5%">Name</p><input type="text" class="input_content" name="Name" style="border-radius:20px;background-color:#f1f3f5;width:100%;border:none;font-size:20px;"/></div>
                <div>
                    <p class="p_title" style="text-align:center;font-size:20px;color:#000;margin-top:5%">Identify Card</p><input type="text" class="input_content" name="IdentifyCard" style="border-radius:20px;background-color:#f1f3f5;width:100%;border:none;font-size:20px;"/></div>
                <div>
                    <p class="p_title" style="text-align:center;font-size:20px;color:#000;margin-top:5%">Gender</p><input type="text" class="input_content" name="Gender" style="border-radius:20px;background-color:#f1f3f5;width:100%;border:none;font-size:20px;"/></div>
                <div><button class="btn btn-primary" type="submit" style="margin-top:4%; margin-left:43%;">Continue</button></div>
            </form>
        </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="{{URL::asset('js/member/script.js')}}"></script>
    <script src="{{URL::asset('bootstrap/js/bootstrap.min.js')}}"></script>
</body>

</html>