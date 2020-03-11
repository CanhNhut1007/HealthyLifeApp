<?php

namespace App\Http\Controllers\Doctor;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Model\HealthRecord;
use App\Model\Patient;

class PatientRecordController extends Controller
{
    public function index($patientid)
    {
        $PatientName = Patient::where('PatientID',$patientid)->value('PatientName');
        $healthrecord = HealthRecord::join('employee', 'employee.EmployeeID', '=', 'healthrecord.EmployeeID')->where('PatientID', $patientid)->get();
        return view('doctor/main/patientrecord')->with(['patientid'=>$patientid, 'PatientName'=>$PatientName, 'healthrecord'=>$healthrecord]);
    }
    
}
