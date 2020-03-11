@extends('doctor.main.layouts.layout_doctor')

@section('content')
<div id="main_div">
        <div id="main_home">
            <div class="container">
                <div class="row">
                    <div class="col">
                        <p id="text_username">Patient: {{$PatientName}}</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="content_div">
        <div id="content_home">
        <div class="div_search"><small class="form-text text-muted name_table" id="text_name_table">Health Record</small><a class="text-right link_add_edit" href="{{route('doctor.addrecord', $patientid)}}">Add</a></div>
            <div id="table_last_result">
                <div class="table-responsive">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Date</th>
                                <th>Employee Name</th>
                                <th>Description</th>
                                <th>Result</th>
                                <th>Detail</th>
                            </tr>
                        </thead>
                        <tbody>
                        @foreach ($healthrecord as $record)
                            <tr>
                                <td>{{$record->HealthRecorDateTime}}</td>
                                <td>{{$record->EmployeeName}}</td>
                                <td>{{$record->Description}}</td>
                                <td>{{$record->Result}}</td>
                                <td><a style="text-decoration:none;" href="{{route('doctor.healthrecord',[$record->PatientID, $record->HealthRecordID])}}">ViewDetail</a></td>
                            </tr>
                        @endforeach
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
@stop