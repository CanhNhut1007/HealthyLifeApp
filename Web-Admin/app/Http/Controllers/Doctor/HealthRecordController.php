<?php

namespace App\Http\Controllers\Doctor;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use App\Model\HealthRecord;
use App\Model\Patient;
use App\Model\Employee;

class HealthRecordController extends Controller
{
    public function index($patientid, $healthrecordid)
    {
        $UserID = Auth::id();
        $EmployeeID = Employee::where('UserID', $UserID)->value('EmployeeID');
        $PatientName = Patient::where('PatientID',$patientid)->value('PatientName');
        $healthrecord = HealthRecord::join('employee', 'employee.EmployeeID', '=', 'healthrecord.EmployeeID')->where('HealthRecordID', $healthrecordid)->first();
        if ($EmployeeID == $healthrecord->EmployeeID)
        {
            return view('doctor/main/healthrecordedit')->with(['patientid'=>$patientid, 'PatientName'=>$PatientName, 'healthrecord'=>$healthrecord, 'healthrecordid'=>$healthrecordid]);
        }
        else 
        {
            return view('doctor/main/healthrecord')->with(['patientid'=>$patientid, 'PatientName'=>$PatientName, 'healthrecord'=>$healthrecord, 'healthrecordid'=>$healthrecordid]);
        }  
    }

    public function update(Request $request, $patientid, $healthrecordid)
    {
        $request->validate([
            'Description'=>'required',
            'Diagnosis'=>'required',
            'Result'=>'required',
            'Notes'=>'required',
            'PatientView'=>'required',
            'TotalFee'=>'required'
        ]);

        HealthRecord::where('HealthRecordID', $healthrecordid)->update(['Description'=>$request->Description, 'Diagnosis'=>$request->Diagnosis, 'Result'=>$request->Result, 'Notes'=>$request->Notes, 'PatientView'=>$request->PatientView, 'TotalFee'=>$request->TotalFee]);
        $healthrecord = HealthRecord::where('HealthRecordID', $healthrecordid)->first();
        $PatientName = Patient::where('PatientID',$patientid)->value('PatientName');
        return view('doctor/main/healthrecordedit')->with(['patientid'=>$patientid, 'PatientName'=>$PatientName, 'healthrecord'=>$healthrecord, 'healthrecordid'=>$healthrecordid]);
    }
}
