<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Model\EmployeeModel;
use App\Model\HealthRecordModel;

class PatientController extends Controller
{
    /// Doctor
    public function ViewListPatient($accountid)
    {
        $employeeid = EmployeeModel::where('UserID', $accountid)->value('EmployeeID');
        $patients = HealthRecordModel::join('patient', 'patient.PatientID', '=', 'healthrecord.PatientID')->select('patient.PatientID', 'patient.PatientName', 'patient.IdentifyCard', 'patient.UserID', 'healthrecord.EmployeeID')->where('EmployeeID', $employeeid)->distinct()->get();
        echo json_encode($patients);
    }
}
