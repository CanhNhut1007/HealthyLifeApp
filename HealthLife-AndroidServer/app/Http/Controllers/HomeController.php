<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Model\PatientModel;
use App\Model\EmployeeModel;

class HomeController extends Controller
{
    /// Doctor
    public function GetPatient()
    {
        $listpatient = PatientModel::all();
        echo json_encode($listpatient);
    }

    public function SearchPatient(Request $request)
    {
        $patient = PatientModel::where( 'PatientName', 'like', '%' . $request->q . '%' )->orWhere ( 'IdentifyCard', 'like', '%' . $request->q . '%' )->orWhere ( 'PatientID', 'like', '%' . $request->q . '%' )->get ();
        if (count ( $patient ) > 0)
        {
            echo json_encode($patient);
        }
        else 
        {
            echo "No Patient Found!";
        }

    }

    public function GetDoctorName($accountid)
    {
        $employeename = EmployeeModel::where('UserID', $accountid)->value('EmployeeName');
        echo $employeename;
    }

    /// Patient
    public function GetDoctor()
    {
        $employee = EmployeeModel::all();
        echo json_encode($employee);
    }

    public function SearchDoctor(Request $request)
    {
        $employee = EmployeeModel::where( 'EmployeeName', 'like', '%' . $request->q . '%' )->orWhere ( 'Speciality', 'like', '%' . $request->q . '%' )->orWhere ( 'EmployeeID', 'like', '%' . $request->q . '%' )->get ();
        if (count ( $employee ) > 0)
        {
            echo json_encode($employee);
        }
        else 
        {
            echo "No Patient Found!";
        }

    }

    public function GetPatientName($accountid)
    {
        $patientname = PatientModel::where('UserID', $accountid)->value('PatientName');
        echo $patientname;
    }
}
