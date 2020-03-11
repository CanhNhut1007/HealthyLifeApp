@extends('admin.layouts.layout_dashboard')
@section('content')
<!-- Page Content -->
<div id="content-wrapper" style="padding:20px;">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">User
                    <small>Add</small>
                </h1>
            </div>
            <!-- /.col-lg-12 -->
            <div class="col-lg-7" style="padding-bottom:120px">
            @if(session()->has('success'))
            <div class="text-success" role="alert">
                <p>{{ session('success') }}</p>
            </div>
            @elseif(session()->has('error'))
            <div class='text-danger' role="alert">
                <p>{{ session('error') }}</p>
            </div>
            @endif
                <form action="{{route('admin.adduser')}}" method="POST">
                    
                    <div class="form-group">
                        <label>Email</label>
                        <input type="email" name="email" class="form-control {{ $errors->has('email') ? 'is-invalid' : '' }}" value="{{ old('email') }}" required autofocus>
                        @if ($errors->has('email'))
                        <span class='text-danger'>
                            <p>{{ $errors->first('email') }}</p>
                        </span>
                        @endif
                    </div>
                    <div class="form-group">
                        <label>Password</label>
                        <input type="password" class="form-control {{ $errors->has('password') ? 'is-invalid' : '' }}" name="password" value="" required>
                        @if ($errors->has('password'))
                        <span class='text-danger'>
                            <p>{{ $errors->first('password') }}</p>
                        </span>
                        @endif
                    </div>
                    <div class="form-group">
                        <label>RePassword</label>
                        <input type="password"  class="form-control" name="password_confirmation" value="" required>
                    </div>
                    <div class="form-group">
                        <label>Role: </label>
                        <label class="radio-inline" style="padding:10px;">
                            <input name="role" value="1" checked="" type="radio">admin
                        </label>
                        <label class="radio-inline" style="padding:10px;">
                            <input name="role" value="2" type="radio">doctor
                        </label>
                    </div>
                    <input type="submit" value="AddUser">
                    <input type="reset" value="Reset">
                <form>
            </div>
        </div>
        <!-- /.row -->
    </div>
    <!-- /.container-fluid -->
</div>
<!-- /#page-wrapper -->
@endsection