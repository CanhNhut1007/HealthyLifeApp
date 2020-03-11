<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Model\PatientModel;
use App\Model\HealthRecordModel;

class PatientRecordController extends Controller
{
    /// Doctor
    public function DoctorViewRecord($accountid)
    {
        $patientid = PatientModel::where('UserID', $accountid)->value('PatientID');
        $healthrecord = HealthRecordModel::where('PatientID', $patientid)->get();
        echo json_encode($healthrecord);
    }

    /// Patient
    public function ViewMyRecord($accountid)
    {
        $patientid = PatientModel::where('UserID', $accountid)->value('PatientID');
        $healthrecord = HealthRecordModel::where(['PatientID'=>$patientid, 'PatientView'=>"Yes"])->get();
        echo json_encode($healthrecord);
    }
}
