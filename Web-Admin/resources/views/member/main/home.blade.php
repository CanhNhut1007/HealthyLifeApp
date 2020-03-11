
@extends('member.main.layouts.layout_home')

@section('content')
<br/>
<div class="container box" >
    <div class="panel panel-default">
        <div class="panel-heading"></div>
            <div class="panel-body">
                <div class="form-group">
                    <div id="main_div">
                        <div id="main_home">
                            <div class="container">
                                <div class="row">
                                    <div class="col"><small class="form-text text-muted" id="text_username">Hi {{$patientname}}</small>
                                        <form action="{{route('user.search')}}" method="GET" role="search">
                                    
                                        <div class="input-group">
                                            <input type="text" class="form-control" style="width:100%; border-radius:20px;" name="q" placeholder="Search users"> 
                                            <span class="input-group-btn">
                                                <button type="submit" class="btn btn-default">
                                                    <span class="glyphicon glyphicon-search"></span>
                                                </button>
                                            </span>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="table-responsive">
                <h3><span id="total_records"></span></h3>
                <p class="form-text text-muted name_table" id="text_name_table">Search Result: {{$mess}}</p>
                
                <table class="table table-striped table-bordered">
                    <thead>
                        <tr>
                            <th>Employee ID</th>
                            <th>Employee Name</th>
                            <th>Speciality</th>
                            <th>MedicalSchool</th>
                            <th>Detail</th>     
                        </tr>
                    </thead>
                    <tbody id="tbody">
                        @foreach ($employee as $user)
                            <tr>
                                <td>{{$user->EmployeeID}}</td>
                                <td>{{$user->EmployeeName}}</td>
                                <td>{{$user->Speciality}}</td>
                                <td>{{$user->MedicalSchool}}</td>
                                <td><a class="nav-link active" href="{{route('user.doctorprofile', $user->UserID)}}">ViewDoctorProfile</a></td>
                            </tr>
                        @endforeach
                        </tbody>   
                </table>
            </div>
        </div>    
    </div>
</div>
@stop