<?php

namespace App\Http\Controllers\Doctor;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use App\Model\Employee;
use App\Model\Patient;
use App\Model\HealthRecord;

class AddHealthRecordController extends Controller
{
    public function index($patientid)
    {
        { $UserID = Auth::id(); 
            $employeeid = Employee::where('UserID', $UserID)->value('EmployeeID'); 
            $patientname = Patient::where('PatientID', $patientid)->value('PatientName'); 
            return view('doctor/main/addhealthrecord')->with(['patientid'=>$patientid, 'employeeid'=>$employeeid, 'patientname'=>$patientname]); }
    }

    public function add(Request $request, $patientid)
    {
        $request->validate([
            'HealthRecorDateTime'=>'required|date',
            'PatientID'=>'required',
            'EmployeeID'=>'required',
            'Description'=>'required',
            'Diagnosis'=>'required',
            'Result'=>'required',
            'Notes'=>'required',
            'PatientView'=>'required',
            'TotalFee'=>'required'
        ]);
        $healthrecord = new HealthRecord;
        $healthrecord->HealthRecorDateTime = $request->HealthRecorDateTime;
        $healthrecord->PatientID = $request->PatientID;
        $healthrecord->EmployeeID = $request->EmployeeID;
        $healthrecord->Description = $request->Description;
        $healthrecord->Diagnosis = $request->Diagnosis;
        $healthrecord->Result = $request->Result;
        $healthrecord->Notes = $request->Notes;
        $healthrecord->PatientView = $request->PatientView;
        $healthrecord->TotalFee = $request->TotalFee;
        $healthrecord->save();
        $healthrecord = HealthRecord::join('employee', 'employee.EmployeeID', '=', 'healthrecord.EmployeeID')->where('PatientID', $patientid)->get();
        $PatientName = Patient::where('PatientID', $patientid)->value('PatientName');
        //return view('welcome');
        return view('doctor/main/patientrecord')->with(['patientid'=>$patientid, 'PatientName'=>$PatientName, 'healthrecord'=>$healthrecord]);    
    }
}
