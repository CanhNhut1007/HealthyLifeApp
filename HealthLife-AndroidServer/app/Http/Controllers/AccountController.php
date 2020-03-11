<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Model\EmployeeModel;
use App\Model\PatientModel;

class AccountController extends Controller
{
    /// Doctor
    public function GetDoctorName($accountid)
    {
        $employeename = EmployeeModel::where('UserID', $accountid)->value('EmployeeName');
        echo $employeename;
    }

    /// Patient
    public function GetPatientName($accountid)
    {
        $patientname = PatientModel::where('UserID', $accountid)->value('PatientName');
        echo $patientname;
    }
}
