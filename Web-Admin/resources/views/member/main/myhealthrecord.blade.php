@extends('member.main.layouts.layout_home')

@section('content')
<div class="content_div">
    <div id="content_home">
        <div class="div_search"><small class="form-text text-muted name_table" id="text_name_table">Health Record</small></div>
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
                            <td><a class="nav-link active" href="{{route('user.healthrecorddetail', $record->HealthRecordID)}}">ViewDetail</a></td>                               
                        </tr>
                        @endforeach
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
@stop