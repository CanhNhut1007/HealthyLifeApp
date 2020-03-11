<?php

namespace App\Http\Controllers\Doctor;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use App\Model\Employee;

class ProfileController extends Controller
{
    public function index()
    {
        $UserID = Auth::id();
        $employee = Employee::where('UserID', $UserID)->first();
        return view('doctor/main/profile')->with(['employee' => $employee]);
    }
    
    public function UpdateProfile(Request $request){
        $request->validate([
            'EmployeeName'=>'required|string|max:30',
            'IdentifyCard'=>'required',
            'DayOfBirth'=>'required',
            'Gender'=>'required',
            'Phonenumber'=>'required',
            'Degree'=>'required',
            'Speciality'=>'required',
            'MedicalSchool'=>'required',
            'YearOfDegree'=>'required',
            'LicenseNumber'=>'required',
            'LicenseCountry'=>'required',
            'LicenseExp'=>'required'
        ]);
        $UserID = Auth::id();
        Employee::where('UserID', $UserID)->update(['EmployeeName'=>$request->EmployeeName, 'IdentifyCard'=>$request->IdentifyCard, 'DayOfBirth'=>$request->DayOfBirth, 'Gender'=>$request->Gender, 'PhoneNumber'=>$request->Phonenumber,
                                                                'Degree'=>$request->Degree, 'Speciality'=>$request->Speciality, 'MedicalSchool'=>$request->MedicalSchool, 'YearOfDegree'=>$request->YearOfDegree,
                                                                'LicenseNumber'=>$request->LicenseNumber, 'LicenseCountry'=>$request->LicenseCountry, 'LicenseEXP'=>$request->LicenseExp]);
        $employee = Employee::where('UserID', $UserID)->first();
        return redirect('doctor/profile');
    }
}
