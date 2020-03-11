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
        <div id="content_home"><small class="form-text text-muted name_table" id="text_name_table">Health Record Detail</small>
            @if($errors->any())
                <div class="alert alert-danger" text-align="right" style="margin-left:5%; margin-right:5%;">
                @foreach($errors->all() as $err)
                    <li>{{$err}}</li>
                @endforeach
                    </div>
            @endif
            <form action="{{route('doctor.healthrecordedit', [$patientid, $healthrecordid])}}" method="POST">
                @csrf()
                <div id="table_last_result">
                    <div class="col-4" id="column_name">
                        <p class="text_name">Health Record ID<br /></p>
                        <p class="text_name">Date<br /></p>
                        <p class="text_name">Employee Name<br /></p>
                        <p class="text_name">Description<br /></p>
                        <p class="text_name">Diagnosis<br /></p>
                        <p class="text_name">Result<br /></p>
                        <p class="text_name">Notes<br /></p>
                        <p class="text_name">Patient View<br /></p>
                        <p class="text_name">TotalFee<br /></p>
                    </div>
                    <div class="col" id="column_detail">
                        <p style="border:none; width:100%; border-radius:20px; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;">{{$healthrecord->HealthRecordID}}</p>
                        <p style="border:none; width:100%; border-radius:20px; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;">{{$healthrecord->HealthRecorDateTime}}</p>
                        <p style="border:none; width:100%; border-radius:20px; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;">{{$healthrecord->EmployeeName}}</p>
                        <input name="Description" type="text" class="text_edit_detail_record" style="border:none; width:100%; border-radius:20px; margin-bottom:2.1%; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;" value="{{$healthrecord->Description}}"/><br>
                        <input name="Diagnosis" type="text" class="text_edit_detail_record" style="border:none; width:100%; border-radius:20px; margin-bottom:2.1%; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;" value="{{$healthrecord->Diagnosis}}"/><br>
                        <input name="Result" type="text" class="text_edit_detail_record" style="border:none; width:100%; border-radius:20px; margin-bottom:2.1%; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;" value="{{$healthrecord->Result}}"/><br>
                        <input name="Notes" type="text" class="text_edit_detail_record" style="border:none; width:100%; border-radius:20px; margin-bottom:2.1%; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;" value="{{$healthrecord->Notes}}"/><br>
                        <input name="PatientView" type="text" class="text_edit_detail_record" style="border:none; width:100%; border-radius:20px; margin-bottom:2.1%; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;" value="{{$healthrecord->PatientView}}"/><br>
                        <input name="TotalFee" type="text" class="text_edit_detail_record" style="border:none; width:100%; border-radius:20px; margin-bottom:2.1%; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;" value="{{$healthrecord->TotalFee}}"/><br>
                    </div>
                </div>
                <div>
                    <button class="btn btn-primary btn_save_record" type="submit" style="margin-top:4%; margin-left:45%;">Save</button>
                </div>
            </form>
        </div>
    </div>
@stop