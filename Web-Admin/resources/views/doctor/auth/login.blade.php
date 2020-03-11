@extends('doctor.auth.layouts.layout_login')

@section('content')
<div class="loginDoctorPage">
    <div class="head"><img src="{{url('img/health_life.png')}}"></div>
    <div class="content">
        <div class="login">
            <h3 class="text-center">Please enter your login doctor info.</h3>
            <div class="divform">
                <div class="divbutton">
                    @if(session()->has('success'))
                    <div class="text-success" role="alert">
                        <p>{{ session('success') }}</p>
                    </div>
                    @elseif(session()->has('error'))
                    <div class='text-danger' role="alert">
                        <p>{{ session('error') }}</p>
                    </div>
                    @endif
                    <form method='POST' action="{{route('doctor.login')}}">
                    {{csrf_field()}}
                        <div class="Input_Info">
                            <div class="textinput">
                                <div class="label">Email</div>
                                <input type="email" name="email" value="{{ old('email') }}" />
                            </div>
                            @if ($errors->has('email'))
                            <span class='text-danger'>
                                <p>{{ $errors->first('email') }}</p>
                            </span>
                            @endif
                        </div>
                        <div class="forgotpassword"><a href="forgotpassword.html">Forgot Password?</a></div>
                        <div class="Input_Info">
                            <div class="textinput"><div class="label">Password</div><input type="password" class="inputPW" name="password" value="" /></div>
                            <div></div>
                            @if ($errors->has('password'))
                                <span class='text-danger'>
                                    <p>{{ $errors->first('password') }}</p>
                                </span>
                            @endif
                        </div>
                        <div class="button"><input class="form-control btn color depth" type="submit" value="Log in"/></div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
@stop