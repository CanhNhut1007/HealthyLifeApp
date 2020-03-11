<?php

namespace App\Http\Controllers\Doctor;

use App\Http\Controllers\Controller;
use Illuminate\Support\Facades\Auth;
use Illuminate\Http\Request;
use App\Model\Employee;
use App\Model\Patient;
use App\Model\HealthRecord;

class PatientController extends Controller
{
    public function index(){
        $UserID = Auth::id();
        $employeeid = Employee::where('UserID', $UserID)->value('EmployeeID');
        $patients = HealthRecord::join('patient', 'patient.PatientID', '=', 'healthrecord.PatientID')->select('patient.PatientID', 'patient.PatientName', 'patient.IdentifyCard', 'patient.UserID', 'healthrecord.EmployeeID')->where('EmployeeID', $employeeid)->distinct()->get();
        return view('doctor/main/patients', ['accountid'=>$UserID, 'patients'=>$patients]);
    }

}
