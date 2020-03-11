@extends('doctor.main.layouts.layout_doctor')

@section('content')
<div id="main_div">
        <div id="main_home">
            <div class="container">
                <div class="row">
                    <div class="col">
                        <p id="text_username">Patient: {{$patientname}}</p>
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
            <div id="table_last_result">
                <div class="col-4" id="column_name">
                    <p class="text_name">Health Record ID<br /></p>
                    <p class="text_name">Date<br /></p>
                    <p class="text_name">Patient ID<br /></p>
                    <p class="text_name">Employee ID<br /></p>
                    <p class="text_name">Description<br /></p>
                    <p class="text_name">Diagnosis<br /></p>
                    <p class="text_name">Result<br /></p>
                    <p class="text_name">Notes<br /></p>
                    <p class="text_name">TotalFee<br /></p>
                </div>
                <div class="col" id="column_detail">
                    <form action="" method="POST">
                        @csrf()
                        <input type="text" class="text_edit_detail_record" id="id_healthrecordid" name="HealthRecordID" style="border:none; width:100%; border-radius:20px; margin-bottom:2.1%; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;"/><br>
                        <input type="text" class="text_edit_detail_record" id="id_date" name="HealthRecorDateTime" style="border:none; width:100%; border-radius:20px; margin-bottom:2.1%; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;"/><br>
                        <input type="text" class="text_edit_detail_record" id="id_patientid" name="PatientID" style="border:none; width:100%; border-radius:20px; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;" value="{{$patientid}}"><br>
                        <input type="text" class="text_edit_detail_record" id="id_employeeid" name="EmployeeID" style="border:none; width:100%; border-radius:20px; margin-bottom:2.1%; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;" value="{{$employeeid}}"/><br>
                        <input type="text" class="text_edit_detail_record" id="id_description" name="Description" style="border:none; width:100%; border-radius:20px; margin-bottom:2.1%; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;"/><br>
                        <input type="text" class="text_edit_detail_record" id="id_diagnosis" name="Diagnosis" style="border:none; width:100%; border-radius:20px; margin-bottom:2.1%; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;"/><br>
                        <input type="text" class="text_edit_detail_record" id="id_result" name="Result" style="border:none; width:100%; border-radius:20px; margin-bottom:2.1%; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;"/><br>
                        <input type="text" class="text_edit_detail_record" id="id_notes" name="Notes" style="border:none; width:100%; border-radius:20px; margin-bottom:2.1%; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;"/><br>
                        <input type="text" class="text_edit_detail_record" id="id_totalfee" name="TotalFee" style="border:none; width:100%; border-radius:20px; margin-bottom:2.1%; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;"/><br>
                        <div style="display:flex;">
                            <button class="btn btn-primary btn_save" type="submit" style="margin-top:4%; margin-left:0%;">Save</button>
                            <button class="btn btn-primary" type="button" style="margin-top:4%; margin-left:20%;" id="btn_cancel">Cancel</button>
                        </div>
                    </form>
                </div>
            </div>
            
        </div>
    </div>
@stop

<script>
    $(document).ready(function() {
        $('#btn_cancel').click(function() {
            $('#id_healthrecordid').val("");
            $('#id_date').val("");
            $('#id_description').val("");
            $('#id_diagnosis').val("");
            $('#id_result').val("");
            $('#id_notes').val("");
            $('#id_totalfee').val("");
            });
        });
</script> 