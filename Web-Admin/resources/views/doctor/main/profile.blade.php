@extends('doctor.main.layouts.layout_doctor')

@section('content')
<div id="content_div" class="content_div">
    <div id="content_main" class="main_content_div"><small class="form-text text-muted name_table" id="text_name_table">Profile</small></div>
    <div class="main_content_div">
        <div>
            <ul class="nav nav-tabs">
                <li class="nav-item"><a class="nav-link active" role="tab" data-toggle="tab" href="#tab-1">About</a></li>
                <li class="nav-item"><a class="nav-link" role="tab" data-toggle="tab" href="#tab-2">Educational Background<br></a></li>
                <li class="nav-item"><a class="nav-link" role="tab" data-toggle="tab" href="#tab-3">License<br></a></li>
            </ul>                
            <form action="{{route('doctor.updateprofile')}}" method="POST">
            @csrf()
                <div class="tab-content">
                    <div class="tab-pane active" role="tabpanel" id="tab-1">
                        <div>
                            <p id="text_name_about">About</p>
                            <div class="div_about">
                                <div class="div_info_name div_name">
                                    <p class="text_about">Employee Name</p><input name="EmployeeName" class="form-control-sm input_about input_name_card" type="text" placeholder="Name" value="<?php echo $employee->EmployeeName ?>"></div>
                                <div class="div_info_name div_name">
                                    <p class="text_about">Identify Card</p><input name="IdentifyCard" class="form-control-sm input_about input_name_card" type="text" placeholder="Identify Card" value="<?php echo $employee->IdentifyCard ?>"></div>
                                <div class="div_info_name div_name">
                                    <p class="text_about">Date of Birth</p><input name="DayOfBirth" class="form-control-sm input_about input_name_card" type="text" placeholder="Year/Month/Year" value="<?php echo $employee->DayofBirth ?>"></div>
                                <div>
                                    <p class="div_info_name text_about">Gender</p><input name="Gender" class="form-control-sm input_about input_name_card" type="text" placeholder="Gender" value="<?php echo $employee->Gender ?>"></div>
                                <div>
                                    <p class="div_info_name text_about">Phone Number</p><input name="Phonenumber" class="form-control-sm input_about input_name_card" type="text" placeholder="Phone Number" value="<?php echo $employee->PhoneNumber ?>"></div>
                            </div>    
                        </div>
                    </div>
                    <div class="tab-pane" role="tabpanel" id="tab-2">
                        <div>
                            <p id="text_name_contact">Educational Background</p>
                            <div>
                                <div class="div_info_name">
                                    <p class="text_contact">Degree</p><input name="Degree" class="form-control-sm input_contact" type="text" placeholder="Degree" value="<?php echo $employee->Degree ?>"></div>
                                <div class="div_info_name">
                                    <p id="text_phone" class="text_contact">Speciality</p>
                                    <div><input name="Speciality" class="form-control-sm input_contact" type="text" placeholder="Speciality" value="<?php echo $employee->Speciality ?>"></div>
                                </div>
                                <div class="div_info_name">
                                    <p id="text_phone" class="text_contact">Medical School<br></p>
                                    <div><input name="MedicalSchool" class="form-control-sm input_contact" type="text" placeholder="Medical School" value="<?php echo $employee->MedicalSchool ?>"></div>
                                </div>
                                <div class="div_info_name">
                                    <p id="text_phone" class="text_contact">Year of Degree<br></p>
                                    <div><input name="YearOfDegree" class="form-control-sm input_contact" type="text" placeholder="Year of Degree" value="<?php echo $employee->YearOfDegree ?>"></div>
                                </div>
                            </div>  
                        </div>
                    </div>
                    <div class="tab-pane" role="tabpanel" id="tab-3">
                        <div>
                            <p id="text_name_insurance">License</p>
                            <div>
                                <div class="div_insurance_name">
                                    <p class="text_insurance">License Number</p><input id="id_licensenumber" name="LicenseNumber" class="form-control-sm input_insurance" type="text" placeholder="License Number" value="<?php echo $employee->LicenseNumber ?>"></div>
                                <div class="div_info_name">
                                    <p class="text_about">License Contry</p><input id="id_licensecontry" name="LicenseCountry" class="form-control-sm input_insurance" type="text" placeholder="License Country" value="<?php echo $employee->LicenseCountry ?>"></div>
                                <div class="div_info_name">
                                    <p class="text_about">License EXP</p><input id="id_licenseexp" name="LicenseExp" class="form-control-sm input_insurance" type="text" placeholder="Year/Month/Day" value="<?php echo $employee->LicenseEXP ?>"></div>
                            </div>   
                        </div>
                    </div>
                    @if($errors->any())
                        <div class="alert alert-danger" text-align="right" style="margin-left:5%; margin-right:5%;">
                        @foreach($errors->all() as $err)
                            <li>{{$err}}</li>
                        @endforeach
                        </div>
                    @endif
                    <button class="btn btn-primary" type="submit" style="margin-top:5%; margin-left:40%; margin-bottom:5%;" id="id_savelicense">Save</button>
                </div>
            </form>

        </div>
    </div>
</div>
@stop