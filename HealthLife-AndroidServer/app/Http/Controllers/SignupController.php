<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Hash;
use App\Model\UserModel;
use App\Model\PatientModel;
use App\Model\HealthInsuranceModel;
use App\Model\EmergencyContactModel;

class SignupController extends Controller
{
    public function Register(Request $request)
    {
        $user = UserModel::create([
            'email' => $request->get('email'),
            'RoleID' => 820000000,
            'password' => Hash::make($request->get('pass')),
            'codeverify' => rand(100000,999999),
            'active' => 1
        ]);

        echo json_encode($user);
    }

    public function AddProfile(Request $request, $accountid)
    {
        $Patient = new PatientModel;
        $Patient->UserID = $accountid;
        $Patient->PatientName = $request->Name;
        $Patient->IdentifyCard = $request->IdentifyCard;
        $Patient->Gender = $request->Gender;
        $Patient->save();

        $PatientID = PatientModel::where('UserID', $accountid)->value('PatientID');

        $HealthInsurance = new HealthInsuranceModel;
        $HealthInsurance->PatientID = $PatientID;
        $HealthInsurance->save();

        $Emergency = new EmergencyContactModel;
        $Emergency->PatientID = $PatientID;
        $Emergency->save();

        echo "Add Profile Success!";
    }
}
