<nav class="navbar navbar-light navbar-expand-md" id="nav_home" src="{{URL::asset('img/HealthLife_v2.png')}}">
    <div class="container-fluid"><img class="logo_img" src="{{URL::asset('img/HealthLife_v2.png')}}"><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse"
            id="navcol-1">
            <ul class="nav navbar-nav ml-auto">
                <li class="nav-item" role="presentation"><a class="nav-link active" href="{{route('user.home')}}">Home</a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="{{route('user.healthrecord')}}">MyRecord</a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="{{route('user.notification')}}">Notifications</a></li>
                <li class="nav-item dropdown"><a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="false" href="untitled.html"><img id="icon_acc" src="{{URL::asset('img/icon-account.png')}}" width="24" height="24"></a>
                    <div class="dropdown-menu" role="menu">
                        <a class="dropdown-item" role="presentation" href="{{route('user.account')}}">Account</a>
                        <a class="dropdown-item" role="presentation" href="{{route('user.setting')}}">Settings</a>
                        <a class="dropdown-item" role="presentation" href="{{route('user.support')}}">Support</a>
                        <a class="dropdown-item" role="presentation" href="{{route('user.logout')}}">Logout</a>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</nav>

