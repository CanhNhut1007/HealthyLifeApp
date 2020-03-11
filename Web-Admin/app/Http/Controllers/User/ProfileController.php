<?php

namespace App\Http\Controllers\User;

use App\Http\Controllers\Controller;
use Illuminate\Support\Facades\Auth;
use Illuminate\Http\Request;
use App\Model\Patient;
use App\Model\HealthInsurance;
use App\Model\EmergencyContact;
use App\Model\User;

class ProfileController extends Controller
{
    public function index()
    {
        $UserID = Auth::id();
        $Patient = Patient::where('UserID',$UserID)->first();
        $HealthInsurance = HealthInsurance::where('PatientID',$Patient->PatientID)->first();
        $emergencycontact = EmergencyContact::where('PatientID', $Patient->PatientID)->first();
        $accountemail = User::where('UserID', $UserID)->value('email');
        return view('member/main/profile')->with(['patient' => $Patient, 'accountemail'=>$accountemail, 'healthinsurance'=>$HealthInsurance, 'emergencycontact'=>$emergencycontact]);
    }

    public function UpdatePatientProfile(Request $request)
    {
        $request->validate([
            'PatientName'=>'required',
            'IdentifyCard'=>'required',
            'DayOfBirth'=>'required',
            'Gender'=>'required',
            'Phone'=>'required',
            'Address'=>'required',
            'City'=>'required',
            'District'=>'required',
            'Country'=>'required',
            'EmergencyContactName'=>'required',
            'EmergencyContactPhone'=>'required',
            'EmergencyContactRelationship'=>'required',
            'HealthInsuranceCode'=>'required',
            'HospitalRegister'=>'required',
            'HealthInsuranceMfd'=>'required',
            'HealthInsuranceExp'=>'required'
        ]);
        $UserID = Auth::id(); 
        $Patient = Patient::where('UserID', $UserID)->first();
        Patient::where('UserID', $UserID)->update(['PatientName'=>$request->PatientName, 'IdentifyCard'=>$request->IdentifyCard, 'DayOfBirth'=>$request->DayOfBirth, 'Gender'=>$request->Gender, 
                                                        'PhoneNumber'=>$request->Phone, 'Address'=>$request->Address, 'City'=>$request->City, 'District'=>$request->District, 'Country'=>$request->Country]);
        EmergencyContact::where('PatientID', $Patient->PatientID)->update(['EmergencyContactName'=>$request->EmergencyContactName, 'EmergencyPhoneNumber'=>$request->EmergencyContactPhone, 'RelationShip'=>$request->EmergencyContactRelationship]);
        HealthInsurance::where('PatientID', $Patient->PatientID)->update(['HealthInsuranceCardCode'=>$request->HealthInsuranceCode, 'HospitalRegister'=>$request->HospitalRegister, 'HealthInsuranceMFD'=>$request->HealthInsuranceMfd, 'HealthInsuranceEXP'=>$request->HealthInsuranceExp]);
        
        $Patient = Patient::where('UserID', $UserID)->first();
        $emergencycontact = EmergencyContact::where('PatientID', $Patient->PatientID)->first();
        $HealthInsurance = HealthInsurance::where('PatientID', $Patient->PatientID)->first();
          
        $accountemail = User::where('UserID', $UserID)->value('email');     
        return view('member/main/profile')->with(['patient' => $Patient, 'accountemail'=>$accountemail, 'healthinsurance'=>$HealthInsurance, 'emergencycontact'=>$emergencycontact]);
    }
}
