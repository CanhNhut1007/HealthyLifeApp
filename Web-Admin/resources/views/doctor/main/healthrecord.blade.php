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
                    <p id="text_id_detail" class="text_detail" style="border:none; width:100%; border-radius:20px; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;">{{$healthrecord->HealthRecordID}}</p>
                    <p id="text_date_detail" class="text_detail" style="border:none; width:100%; border-radius:20px; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;">{{$healthrecord->HealthRecorDateTime}}</p>
                    <p id="text_doctor_detail" class="text_detail" style="border:none; width:100%; border-radius:20px; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;">{{$healthrecord->EmployeeName}}</p>
                    <p id="text_description_detail" class="text_detail" style="border:none; width:100%; border-radius:20px; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;">{{$healthrecord->Description}}</p>
                    <p id="text_diagnosis_detail" class="text_detail" style="border:none; width:100%; border-radius:20px; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;">{{$healthrecord->Diagnosis}}</p>
                    <p id="text_result_detail" class="text_detail" style="border:none; width:100%; border-radius:20px; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;">{{$healthrecord->Result}}</p>
                    <p id="text_notes_detail" class="text_detail" style="border:none; width:100%; border-radius:20px; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;">{{$healthrecord->Notes}}</p>
                    <p id="text_notes_detail" class="text_detail" style="border:none; width:100%; border-radius:20px; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;">{{$healthrecord->PatientView}}</p>
                    <p id="text_totalfee_detal" class="text_detail" style="border:none; width:100%; border-radius:20px; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;">{{$healthrecord->TotalFee}}</p>
                </div>
            </div>
        </div>
    </div>
@stop