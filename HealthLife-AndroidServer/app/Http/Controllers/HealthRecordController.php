<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Model\HealthRecordModel;

class HealthRecordController extends Controller
{
    /// Patient & Doctor
    public function GetHealthRecordDetail($healthrecordid)
    {
        $healthrecordetail = HealthRecordModel::where('HealthRecordID', $healthrecordid)->first();
        echo json_encode($healthrecordetail);
    }
    

    /// Doctor
    public function UpdateHealthRecord(Request $request, $healthrecordid)
    {
        $Description = $request->Description;
        $Diagnosis = $request->Diagnosis;
        $Result = $request->Result;
        $Notes = $request->Notes;
        $PatientView = $request->PatientView;
        $TotalFee = $request->TotalFee;

        if ($Description != "")
        {
            HealthRecordModel::where('HealthRecordID', $healthrecordid)->update(['Description'=>$Description]);
        }

        if ($Diagnosis != "")
        {
            HealthRecordModel::where('HealthRecordID', $healthrecordid)->update(['Diagnosis'=>$Diagnosis]);
        }

        if ($Result != "")
        {
            HealthRecordModel::where('HealthRecordID', $healthrecordid)->update(['Result'=>$Result]);
        }

        if ($Notes != "")
        {
            HealthRecordModel::where('HealthRecordID', $healthrecordid)->update(['Notes'=>$Notes]);
        }

        if ($PatientView != "")
        {
            HealthRecordModel::where('HealthRecordID', $healthrecordid)->update(['PatientView'=>$PatientView]);
        }

        if ($TotalFee != "")
        {
            HealthRecordModel::where('HealthRecordID', $healthrecordid)->update(['TotalFee'=>$TotalFee]);
        }

        echo "Update Health Record Success!";
    }

    /// Doctor
    public function GetEmployeeID($healthrecordid)
    {
        $employeeid = HealthRecordModel::where('HealthRecordID', $healthrecordid)->value('EmployeeID');
        echo $employeeid;
    }
}
