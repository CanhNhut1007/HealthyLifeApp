@extends('doctor.main.layouts.layout_doctor')

@section('content')
<div class="container box" >
    <div class="panel panel-default">
        <div class="panel-heading"></div>
            <div class="panel-body">
                <div class="form-group">
                    <div id="main_div">
                        <div id="main_home">
                            <div class="container">
                                <div class="row">
                                    <div class="col"><small class="form-text text-muted" id="text_username">Hi {{$EmployeeName}} </small>
                                        <form action="{{route('doctor.searchpatient')}}" method="GET" role="search">
                                        
                                        <div class="input-group">
                                            <input type="text" class="form-control" name="q" placeholder="Search users"> 
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
                            <th>Patient ID</th>
                            <th>Patient Name</th>
                            <th>Identify Card</th>
                            <th>Heath Record</th>  
                        </tr>
                    </thead>
                    <tbody id="tbody">
                        @foreach ($patients as $patient)
                            <tr>
                                <td>{{$patient->PatientID}}</td>
                                <td>{{$patient->PatientName}}</td>
                                <td>{{$patient->IdentifyCard}}</td>
                                <td><a class="nav-link active" href="{{route('doctor.patientrecord',  $patient->PatientID)}}">ViewHealthRecord</a></td>
                            </tr>
                        @endforeach
                        </tbody>   
                </table>
            </div>
        </div>    
    </div>
</div>
@stop