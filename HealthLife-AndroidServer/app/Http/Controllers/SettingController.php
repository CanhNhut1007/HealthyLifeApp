<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Model\UserModel;

class SettingController extends Controller
{
     /// Doctor
     public function GetDoctorEmail($accountid)
     {
         $email = UserModel::where('UserID', $accountid)->value('email');
         echo $email;
     }
 
     /// Patient
     public function GetPatientEmail($accountid)
     {
         $email = UserModel::where('UserID', $accountid)->value('email');
         echo $email;
     }

    public function UpdateEmail(Request $request, $accountid)
    {
        $user = UserModel::where('UserID', $accountid)->first();
        UserModel::where('email', $user->email)->update(['email'=> $request->get('NewEmail')]);
        echo "Update Success";
    }

    public function UpdatePassword(Request $request, $accountid)
    {
        $user = UserModel::where('UserID', $accountid)->first();
        $pass = Hash::make($request->get('NewPassword'));
        UserModel::where('email', $user->email)->update(['password'=> $pass]);
        echo "Update Success";
    }
}
