<?php

namespace App\Http\Controllers\User;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use App\Model\HealthRecord;
use App\Model\Patient;
use App\Model\Employee;

class HealthRecordController extends Controller
{
    public function index()
    {
        $id = Auth::id();
        $PatientID = Patient::where('UserID',$id)->value('PatientID');
        $healthrecord = HealthRecord::join('employee', 'employee.EmployeeID', '=', 'healthrecord.EmployeeID')->where(['PatientID'=> $PatientID, 'PatientView'=>"Yes"])->get();
        return view('member/main/myhealthrecord')->with(['id' => $id,'healthrecord'=>$healthrecord]);
    }
}
