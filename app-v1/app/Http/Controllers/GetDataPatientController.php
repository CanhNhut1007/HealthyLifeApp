<?php

namespace App\Http\Controllers;

use App\Model\AccountModel;
use App\Model\PatientModel;
use App\Model\EmployeeModel;
use App\Model\HealthRecordModel;
use App\Model\EmergencyContactModel;
use App\Model\HealthInsuranceModel;

use Illuminate\Http\Request;

class GetDataPatientController extends Controller
{

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
        $patientname = PatientModel::where('AccountID', $accountid)->value('PatientName');
        echo $patientname;
    }

    public function ViewMyRecord($accountid)
    {
        $patientid = PatientModel::where('AccountID', $accountid)->value('PatientID');
        $healthrecord = HealthRecordModel::where(['PatientID'=>$patientid, 'PatientView'=>"Yes"])->get();
        echo json_encode($healthrecord);
    }

    public function GetPatientEmail($accountid)
    {
        $email = AccountModel::where('AccountID', $accountid)->value('AccountEmail');
        echo $email;
    }

    public function GetDoctorProfile($accountid)
    {
        $employee = EmployeeModel::where('AccountID', $accountid)->first();
        echo json_encode($employee);
    }

    public function GetProfile($accountid)
    {
        $patient = PatientModel::where('AccountID', $accountid)->first();
        echo json_encode($patient);
    }

    public function GetEmergency($accountid)
    {
        $patient = PatientModel::where('AccountID', $accountid)->first();
        $emergencycontact = EmergencyContactModel::where('PatientID', $patient->PatientID)->first();
        echo json_encode($emergencycontact);
    }

    public function GetInsurance($accountid)
    {
        $patient = PatientModel::where('AccountID', $accountid)->first();
        $healthinsurance = HealthInsuranceModel::where('PatientID', $patient->PatientID)->first();
        echo json_encode($healthinsurance);
    }

    public function UpdateAboutPatientProfile(Request $request, $accountid)
    {
        $PatientName = $request->PatientName;
        $DayOfBirth = $request->DayOfBirth;
        $IdentifyCard = $request->IdentifyCard;
        $Gender = $request->Gender;

        if ($PatientName != "")
        {
            PatientModel::where('AccountID', $accountid)->update(['PatientName'=>$PatientName]);
        }

        if ($DayOfBirth != "")
        {
            PatientModel::where('AccountID', $accountid)->update(['DayOfBirth'=>$DayOfBirth]);
        }

        if ($IdentifyCard != "")
        {
            PatientModel::where('AccountID', $accountid)->update(['IdentifyCard'=>$IdentifyCard]);
        }

        if ($Gender != "")
        {
            PatientModel::where('AccountID', $accountid)->update(['Gender'=>$Gender]);
        }

        echo "Update Success!";
    }

    public function UpdateContactPatientProfile(Request $request, $accountid)
    {
        $PhoneNumber = $request->PhoneNumber;
        $Address = $request->Address;
        $District = $request->District;
        $City = $request->City;
        $Country = $request->Country;

        if ($PhoneNumber != "")
        {
            PatientModel::where('AccountID', $accountid)->update(['PhoneNumber'=>$PhoneNumber]);
        }

        if ($Address != "")
        {
            PatientModel::where('AccountID', $accountid)->update(['Address'=>$Address]);
        }

        if ($District != "")
        {
            PatientModel::where('AccountID', $accountid)->update(['District'=>$District]);
        }

        if ($City != "")
        {
            PatientModel::where('AccountID', $accountid)->update(['City'=>$City]);
        }

        if ($Country != "")
        {
            PatientModel::where('AccountID', $accountid)->update(['Country'=>$Country]);
        }

        echo "Update Success!";
    }

    public function UpdateEmergencyPatientProfile(Request $request, $accountid)
    {
        $EmergencyContactName = $request->EmergencyContactName;
        $EmergencyPhoneNumber = $request->EmergencyPhoneNumber;
        $RelationShip = $request->RelationShip;
        $patientid = PatientModel::where('AccountID', $accountid)->value('PatientID');
        $emergency  = EmergencyContactModel::where('PatientID', $patientid)->first();

        if ($emergency == "")
        {
            EmergencyContactModel::insert(['EmergencyContactID'=>'EC00000002', 'PatientID'=>$patientid, 'EmergencyContactName'=>$EmergencyContactName, 'EmergencyPhoneNumber'=>$EmergencyPhoneNumber, 'RelationShip'=>$RelationShip]);
        }
        else 
        {
            if ($EmergencyContactName != "")
            {
                EmergencyContactModel::where('PatientID', $patientid)->update(['EmergencyContactName'=>$EmergencyContactName]);
            }

            if ($EmergencyPhoneNumber != "")
            {
                EmergencyContactModel::where('PatientID', $patientid)->update(['EmergencyPhoneNumber'=>$EmergencyPhoneNumber]);
            }

            if ($RelationShip != "")
            {
                EmergencyContactModel::where('PatientID', $patientid)->update(['RelationShip'=>$RelationShip]);
            }
        }

        echo "Update Success!";
    }

    public function UpdateInsurancePatientProfile(Request $request, $accountid)
    {
        $HealthInsuranceCardCode = $request->HealthInsuranceCardCode;
        $HospitalRegister = $request->HospitalRegister;
        $HealthInsuranceMFD = $request->HealthInsuranceMFD;
        $HealthInsuranceEXP = $request->HealthInsuranceEXP;
        $patientid = PatientModel::where('AccountID', $accountid)->value('PatientID');
        $health  = HealthInsuranceModel::where('PatientID', $patientid)->first();

        if ($health == "")
        {
            HealthInsuranceModel::insert(['HealthInsuranceID'=>'HI00000002', 'PatientID'=>$patientid, 'HealthInsuranceCardCode'=>$HealthInsuranceCardCode, 'HospitalRegister'=>$HospitalRegister, 'HealthInsuranceMFD'=>$HealthInsuranceMFD, 'HealthInsuranceEXP'=>$HealthInsuranceEXP]);
        }
        else 
        {
            if ($HealthInsuranceCardCode != "")
            {
                HealthInsuranceModel::where('PatientID', $patientid)->update(['HealthInsuranceCardCode'=>$HealthInsuranceCardCode]);
            }

            if ($HospitalRegister != "")
            {
                HealthInsuranceModel::where('PatientID', $patientid)->update(['HospitalRegister'=>$HospitalRegister]);
            }

            if ($HealthInsuranceMFD != "")
            {
                HealthInsuranceModel::where('PatientID', $patientid)->update(['HealthInsuranceMFD'=>$HealthInsuranceMFD]);
            }

            if ($HealthInsuranceEXP != "")
            {
                HealthInsuranceModel::where('PatientID', $patientid)->update(['HealthInsuranceEXP'=>$HealthInsuranceEXP]);
            }
        }

        

        echo "Update Success!";
    }

}
