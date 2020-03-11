@extends('admin.layouts.layout_dashboard')
@section('content')
<!-- Page Content -->
<div id="content-wrapper" style="padding:20px;">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Doctor
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
                <form action="{{route('admin.adddoctor')}}" method="POST">
                {{csrf_field()}}
                    <div class="form-group">
                    <select id="myselect">
                        <option value="" selected="selected">Please select email</option>
                        @foreach ($listemail as $email)
                        <option name='email' value="<?php echo $email->email ?>">{{$email->email}}</option>  
                        @endforeach
                    </select>
                    <select id="myselect1">
                        <option value="" selected="selected">Please select Hospital</option>
                        @foreach ($listhospital as $hospital)
                        <option name='hospital' value="<?php echo $hospital->HospitalID ?>">{{$hospital->HospitalName}}</option>  
                        @endforeach
                    </select>
                    <input type="hidden" id="email" name="email" value="">
                    <input type="hidden" id="hospital" name="hospital" value="">
                    <script> 
                        $(document).ready(function(){
                            $("#myselect").change(function(){
                                
                                $("#email").val($(this).val());
                            });
                            $("#myselect1").change(function(){
                                
                                $("#hospital").val($(this).val());
                            });
                        });
                    </script>
                    </div>
                    <div class="form-group">
                        <label>Doctor Name</label>
                        <input type="text" name="EmployeeName" class="form-control" value="" required autofocus>
                    </div>
                    <div class="form-group">
                        <label>Gender: </label>
                        <input type="text" name="Gender" class="form-control" value="" required>
                    </div>
                    <div class="form-group">
                        <label>Phone Number</label>
                        <input type="text"  class="form-control" name="PhoneNumber" value="" required>
                    </div>
                    <div class="form-group">
                        <label>Day of Birth</label>
                        <input type="date"  class="form-control" name="DayofBirth" value="" required pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}">
                    </div>
                    <div class="form-group">
                        <label>Degree</label>
                        <input type="text"  class="form-control" name="Degree" value="" required>
                    </div>
                    <div class="form-group">
                        <label>Speciality</label>
                        <input type="text"  class="form-control" name="Speciality" value="" required>
                    </div>
                    <div class="form-group">
                        <label>Medical School</label>
                        <input type="text"  class="form-control" name="MedicalSchool" value="" required>
                    </div>
                    <div class="form-group">
                        <label>YearOfDegree</label>
                        <input type="text"  class="form-control" name="YearOfDegree" value="" required>
                    </div>
                    <div class="form-group">
                        <label>LicenseNumber</label>
                        <input type="text"  class="form-control" name="LicenseNumber" value="" required>
                    </div>	
                    <div class="form-group">
                        <label>LicenseCountry</label>
                        <input type="text"  class="form-control" name="LicenseCountry" value="" required>
                    </div>
                    <div class="form-group">
                        <label>LicenseEXP</label>
                        <input type="date"  class="form-control" name="LicenseEXP" value="" required>
                    </div>
                    <div class="form-group">
                        <label>IdentifyCard</label>
                        <input type="text"  class="form-control" name="IdentifyCard" value="" required>
                    </div>	
                    <input type="submit" value="AddDoctor">
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