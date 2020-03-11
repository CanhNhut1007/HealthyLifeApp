@extends('admin.layouts.layout_dashboard')
@section('content')
<!-- Page Content -->
<div id="content-wrapper" style="padding:20px;">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Hospital
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
                <form action="{{route('admin.addhospital')}}" method="POST">
                    
                    <div class="form-group">
                        <label>Hospital Name</label>
                        <input type="text" name="hospitalname" class="form-control" value="" required autofocus>
                    </div>
                    <div class="form-group">
                        <label>City</label>
                        <input type="text" class="form-control" name="city" value="" required>
                    </div>
                    <div class="form-group">
                        <label>Country</label>
                        <input type="text"  class="form-control" name="country" value="" required>
                    </div>
                    
                    <input type="submit" value="Add Hospital">
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