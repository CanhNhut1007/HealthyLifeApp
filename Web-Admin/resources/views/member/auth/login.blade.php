@extends('member.auth.layouts.layout')

@section('content')
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
    <form method="POST" action="{{route('user.login')}}">
        {{csrf_field()}}
        <div class="Input_Info">
            <div class="textinput">
                <div class="label">Email</div>
                    <input type="email" name="email" value="{{ old('email') }}">
                <div>
                    @if ($errors->has('email'))
                        <span class='text-danger'>
                            <p>{{ $errors->first('email') }}</p>
                        </span>
                    @endif
                </div>   
            </div>          
        </div>
        <div class="forgotpassword"><a href="{{route('forgotpassword')}}">Forgot Password?</a></div>
            <div class="Input_Info">
                <div class="textinput">
                    <div class="label">Password</div>
                    <input type="password" class="inputPW" name="password" value="">
                <div>
                    @if ($errors->has('password'))
                        <span class='text-danger'>
                            <p>{{ $errors->first('password') }}</p>
                        </span>
                    @endif
                </div>
            </div>
        </div>
        <div class="button"><input class="form-control btn color depth" type="submit" value="Log in"/></div>
        <div class="orsignup">or <a href="{{route('signup')}}">Sign up</a></div>
    </form>
</div>
@stop