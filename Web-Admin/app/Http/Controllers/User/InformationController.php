<?php

namespace App\Http\Controllers\User;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Model\User;
use App\Model\Patient;
use App\Model\HealthInsurance;
use App\Model\EmergencyContact;


class InformationController extends Controller
{
    public function index()
    {
        return view('member/main/information');
    }

    public function update(Request $request)
    {
        $request->validate([
            'Name'=>'required',
            'IdentifyCard'=>'required',
            'Gender'=>'required'
        ]);
        $UserID = User::where('email', $request->email)->value('UserID');
        $Patient = new Patient;
        $Patient->UserID = $UserID;
        $Patient->PatientName = $request->Name;
        $Patient->IdentifyCard = $request->IdentifyCard;
        $Patient->Gender = $request->Gender;
        $Patient->save();

        $PatientID = Patient::where('UserID', $UserID)->value('PatientID');

        $HealthInsurance = new HealthInsurance;
        $HealthInsurance->PatientID = $PatientID;
        $HealthInsurance->save();

        $Emergency = new EmergencyContact;
        $Emergency->PatientID = $PatientID;
        $Emergency->save();

        return redirect()->route('login')->with(['success' => 'Your account is actived.']);
    }
}
