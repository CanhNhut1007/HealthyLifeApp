@extends('member.auth.layouts.layout')

@section('content')
<div class="divbutton">
    <form method="POST" action="{{route('user.signup')}}">
        {{csrf_field()}}
        <div class="Input_Info">
            <div class="textinput">
                <div class="label">Email</div>
                <input type="email" name="email" class="{{ $errors->has('email') ? 'form-control is-invalid' : '' }}" value="{{ old('email') }}" required autofocus>
                <div>
                    @if ($errors->has('email'))
                        <span class='text-danger'>
                            <strong>{{ $errors->first('email') }}</strong>
                        </span>
                    @endif
                </div>
            </div>
        </div>
        <div class="Input_Info">
            <div class="textinput">
                <div class="label">Password</div>
                <input type="password" class="inputPW {{ $errors->has('password') ? 'form-control is-invalid' : '' }}" name="password" value="" required>
                <div>
                    @if ($errors->has('password'))
                        <span class='text-danger'>
                            <strong>{{ $errors->first('password') }}</strong>
                        </span>
                    @endif
                </div>
            </div>
        </div>
        <div class="Input_Info">
            <div class="textinput">
                <div class="label">Confirm Password</div>
                <input type="password" class="inputCPW" name="password_confirmation" value="" required>
            </div>
        </div>
        <div class="button"><input class="form-control btn color depth" type="submit" value="Sign up"></div>
    </form>
    <div>
        <p>Already a member?<a href="{{route('login')}}"> Log in</a></p>
    </div>
</div>
@stop