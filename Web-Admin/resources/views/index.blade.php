<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Healthlife</title>
    <link rel="stylesheet" href="{{URL::asset('bootstrap/css/bootstrap.min.css')}}">
    <link rel="stylesheet" href="{{URL::asset('css/member/auth/styles.css')}}">
</head>

<body>
    <div class="HomePage">
        <div class="header">
            <div class="bar">
                <div class="containerBar">
                    <div class="logo"><a href="{{URL::asset('/')}}" role="button" tabindex="0"><img src="{{URL::asset('img/health_life.png')}}"></a></div>
                    <div class="options">
                        <nav class="navbar navbar-light navbar-expand-md">
                            <div class="container-fluid"><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
                                <div class="collapse navbar-collapse" id="navcol-1">
                                    <ul class="nav navbar-nav">
                                        <li class="nav-item" role="presentation"><a class="nav-link active" href="{{route('welcome')}}">Sign up</a></li>
                                        <li class="nav-item dropdown show"><a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="true" href="#">Log in</a>
                                            <div class="dropdown-menu show" role="menu"><a class="dropdown-item" role="presentation" href="{{route('login')}}">For Individual</a><a class="dropdown-item" role="presentation" href="{{route('doctor.login')}}">For Doctor</a></div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
        <div class="Body">
            <div class="imageBody">
                <div class="card">
                    <div class="card-img-overlay">
                        <h4>HEALTH LIFE</h4>
                        <p>To improve your life</p>
                    </div>
                </div><img id="imgBody" src="{{URL::asset('img/home_background.jpg')}}">
                <div></div>
            </div>
            <div></div>
        </div>
    </div>
    <script src="{{URL::asset('js/jquery.min.js')}}"></script>
    <script src="{{URL::asset('bootstrap/js/bootstrap.min.js')}}"></script>
    <script src="{{URL::asset('js/script.min.js')}}"></script>
</body>

</html>