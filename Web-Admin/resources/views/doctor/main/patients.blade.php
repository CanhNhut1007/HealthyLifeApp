@extends('doctor.main.layouts.layout_doctor')

@section('content')

<div class="container box" >
    <div class="panel panel-default">
        <div class="table-responsive">
            <h3><span id="total_records"></span></h3>
            <p class="form-text text-muted name_table" id="text_name_table">My Patient</p>
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
@stop