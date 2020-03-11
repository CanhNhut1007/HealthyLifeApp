
@extends('member.main.layouts.layout_home')

@section('content')
<br/>
<div>
    <div class="content_div">
        <div id="content_home"><small class="form-text text-muted name_table" id="text_name_table">Health Record Detail</small>
            <div id="table_last_result">
                <div class="col-4" id="column_name">
                    <p class="text_name">Health Record ID<br /></p>
                    <p class="text_name">Time<br /></p>
                    <p class="text_name">Employee Name<br /></p>
                    <p class="text_name">Description<br /></p>
                    <p class="text_name">Diagnosis<br /></p>
                    <p class="text_name">Result<br /></p>
                    <p class="text_name">Notes<br /></p>
                    <p class="text_name">TotalFee<br /></p>
                </div>
                <div class="col" id="column_detail">
                    <p class="text_detail" style="border:none; width:100%; border-radius:20px; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;">{{$healthrecord->HealthRecordID}}</p>
                    <p class="text_detail" style="border:none; width:100%; border-radius:20px; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;">{{$healthrecord->HealthRecorDateTime }}</p>
                    <p class="text_detail" style="border:none; width:100%; border-radius:20px; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;">{{$healthrecord->EmployeeName}}</p>
                    <p class="text_detail" style="border:none; width:100%; border-radius:20px; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;">{{$healthrecord->Description}}</p>
                    <p class="text_detail" style="border:none; width:100%; border-radius:20px; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;">{{$healthrecord->Diagnosis}}</p>
                    <p class="text_detail" style="border:none; width:100%; border-radius:20px; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;">{{$healthrecord->Result}}</p>
                    <p class="text_detail" style="border:none; width:100%; border-radius:20px; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;">{{$healthrecord->Notes}}</p>
                    <p class="text_detail" style="border:none; width:100%; border-radius:20px; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;">{{$healthrecord->TotalFee}}</p>
                </div>
            </div>
        </div>
    </div>
</div>
@stop