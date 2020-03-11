<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Model\EmployeeModel;
use App\Model\PatientModel;
use App\Model\HealthRecordModel;

class AddHealthRecordController extends Controller
{
    public function AddHealthRecord(Request $request, $accountemployeeid, $accountpatientid)
    {
        $HealthRecorDateTime = $request->HealthRecorDateTime;
        $Description = $request->Description;
        $Diagnosis = $request->Diagnosis;
        $Result = $request->Result;
        $Notes = $request->Notes;
        $PatientView = $request->PatientView;
        $TotalFee = $request->TotalFee;

        if($HealthRecorDateTime == "" || $Description == "" || $Diagnosis == "" || $Result == "" || $Notes == "" || $PatientView == "" || $TotalFee == "")
        {
            echo "Add Health Record Error! Please Enter All Row!";
        }
        else
        {
            $employeeid = EmployeeModel::where('UserID', $accountemployeeid)->value('EmployeeID');
            $patientid = PatientModel::where('UserID', $accountpatientid)->value('PatientID');
            HealthRecordModel::insert(['PatientID'=>$patientid, 'EmployeeID'=>$employeeid, 'HealthRecorDateTime'=>$HealthRecorDateTime, 'Description'=>$Description, 'Diagnosis'=>$Diagnosis, 'Result'=>$Result, 'Notes'=>$Notes, 'PatientView'=>$PatientView, 'TotalFee'=>$TotalFee]);
        
            echo "Add Health Record Success!";
        }

        
    }
}
