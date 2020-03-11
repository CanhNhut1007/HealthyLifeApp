@extends('member.main.layouts.layout_home')

@section('content')
<div class="content_div">
    <div id="content_main" class="main_content_div"><small class="form-text text-muted name_table" id="text_name_table">Profile</small></div>
    <div class="main_content_div">
        <div>
            <ul class="nav nav-tabs">
                <li class="nav-item"><a role="tab" data-toggle="tab" class="nav-link active" href="#tab-1">About</a></li>
                <li class="nav-item"><a role="tab" data-toggle="tab" class="nav-link" href="#tab-2">Contact Information<br /></a></li>
                <li class="nav-item"><a role="tab" data-toggle="tab" class="nav-link" href="#tab-3">Insurance<br /></a></li>
            </ul>
            <form action="{{route('user.updateprofile')}}" method="POST">
                @csrf()
                <div class="tab-content">               
                    <div role="tabpanel" class="tab-pane active" id="tab-1">
                        <div>
                            <p id="text_name_about">About</p>
                            <div class="div_about">
                                <div class="div_info_name div_name">
                                    <p class="text_about">Patient Name</p>
                                    <input name="PatientName" type="text" class="form-control-sm input_about input_name_card" placeholder="Name" value="<?php echo $patient->PatientName; ?>"/>
                                </div>
                                <div class="div_info_name div_name">
                                    <p class="text_about">Identify Card</p>
                                    <input name="IdentifyCard" type="text" class="form-control-sm input_about input_name_card" placeholder="Identify Card" value="<?php echo $patient->IdentifyCard; ?>"/>
                                </div>
                                <div class="div_info_name div_name">
                                    <p class="text_about">Day of Birth</p><input name="DayOfBirth" type="text" class="form-control-sm input_about input_name_card" placeholder="Year/Month/Year" value="<?php echo $patient->DayofBirth; ?>"/>
                                </div>
                                <div>
                                    <p class="div_info_name div_name">Gender</p>
                                    <input name="Gender" type="text" class="form-control-sm input_about input_name_card" placeholder="Gender" value="<?php echo $patient->Gender; ?>"/>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div role="tabpanel" class="tab-pane" id="tab-2">
                        <div>
                            <p id="text_name_contact">Contact Infomation</p>
                            <div>
                                <div class="div_insurance_name div_curent_email">
                                    <p class="para_current_mail">Email<br></p>
                                    <p id="text_current_mai_login" class="para_current_mail text_mail_login" placeholder="Login Email">{{$accountemail}}</p>
                                </div>
                                <div class="div_info_name">
                                    <p id="text_phone" class="text_contact">Phone</p>
                                    <div><input name="Phone" type="text" class="form-control-sm input_contact" placeholder="Phone number" value="<?php echo $patient->PhoneNumber; ?>"/></div>
                                </div>
                                <div class="div_info_name">
                                    <p id="text_phone" class="text_contact">Address<br /></p>
                                    <div><input name="Address" type="text" class="form-control-sm input_contact" placeholder="Address" value="<?php echo $patient->Address; ?>"/></div>
                                </div>
                                <div class="div_info_name">
                                    <p id="text_phone" class="text_contact">City/Province<br /></p>
                                    <div><input name="City" type="text" class="form-control-sm input_contact" placeholder="City" value="<?php echo $patient->City; ?>"/></div>
                                </div>
                                <div class="div_info_name">
                                    <p id="text_phone" class="text_contact">District<br /></p>
                                    <div><input name="District" type="text" class="form-control-sm input_contact" placeholder="District" value="<?php echo $patient->District; ?>"/></div>
                                </div>
                                <div class="div_info_name">
                                    <p id="text_phone" class="text_contact">Country/Region<br /></p>
                                    <div><input name="Country" type="text" class="form-control-sm input_contact" placeholder="Country" value="<?php echo $patient->Country; ?>"/></div>
                                </div>
                                <div>
                                    <p class="text_address">Emergency contact<br /></p>
                                    <div>
                                        <input name="EmergencyContactName" type="text" class="form-control-sm address input_emergency" placeholder="Name" value="<?php echo $emergencycontact->EmergencyContactName ?>"/>
                                        <input name="EmergencyContactPhone" type="text" class="form-control-sm address input_emergency" placeholder="Phone" value="<?php echo $emergencycontact->EmergencyPhoneNumber ?>"/>
                                        <input name="EmergencyContactRelationship" type="text" class="form-control-sm address input_emergency"
                                        placeholder="Relationship" value="<?php echo $emergencycontact->RelationShip ?>"/></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div role="tabpanel" class="tab-pane" id="tab-3">
                        <div>
                            <p id="text_name_insurance">Insurace</p>
                            <div>
                                <div class="div_insurance_name">
                                    <p class="text_insurance">Health Insurance Card Code</p>
                                    <input name="HealthInsuranceCode" type="text" class="form-control-sm input_insurance" placeholder="Health Insurance Card Code" value="<?php echo $healthinsurance->HealthInsuranceCardCode; ?>"/>
                                </div>
                                <div class="div_info_name">
                                    <p class="text_insurance">Hospital Register</p>
                                    <input name="HospitalRegister" type="text" class="form-control-sm input_insurance" placeholder="Hopital" value="<?php echo $healthinsurance->HospitalRegister; ?>"/>
                                </div>
                                <div class="div_insurance_name">
                                    <p class="text_insurance">Health Insurance MFD</p>
                                    <input name="HealthInsuranceMfd" type="text" class="form-control-sm input_insurance" placeholder="Year/Month/Day" value="<?php echo $healthinsurance->HealthInsuranceMFD; ?>"/>
                                </div>
                                <div class="div_insurance_name">
                                    <p class="text_insurance">Health Insurance EXP<br/></p>
                                    <input name="HealthInsuranceExp" type="text" class="form-control-sm input_insurance" placeholder="Year/Month/Day" value="<?php echo $healthinsurance->HealthInsuranceEXP; ?>"/>
                                </div>
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
                    <button class="btn btn-primary" type="submit" style="margin-top:5%; margin-left:40%; margin-bottom:5%;">Save</button>
                </div>
            </form>
        </div>
    </div>
</div>
@stop