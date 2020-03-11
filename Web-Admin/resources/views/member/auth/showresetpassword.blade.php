@extends('member.auth.layouts.layout')

@section('content')

<div class="divbutton">
    <h4>Forgot your password?</h4>
    @if(session()->has('success'))
        <div class="text-success" role="alert">
            <p>{{ session('success') }}</p>
        </div>
    @elseif(session()->has('error'))
        <div class='text-danger' role="alert">
            <p>{{ session('error') }}</p>
        </div>
    @endif
    <p>No worries! Let us know your email and we'll send you a code to reset it.</p>
    <form method="POST" action="{{route('user.forgotpassword')}}">
        {{csrf_field()}}
	    <div class="Input_Info">
			<div class="textinput">
                <div class="label">Email</div>
                <input type="email" name="email" value="" required>
            </div>
		</div>
        <div class="button"><input class="form-control btn color depth" type="submit" value="Send"/></div>
    </form>
</div>
@stop