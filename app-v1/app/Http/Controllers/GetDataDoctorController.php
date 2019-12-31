<?php

namespace App\Http\Controllers;
use App\Model\AccountModel;
use App\Model\PatientModel;
use App\Model\EmployeeModel;
use App\Model\HealthRecordModel;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Hash;

class GetDataDoctorController extends Controller
{
    function GetAccount()
    {
        $account = AccountModel::where('AccountEmail', "nguyet98@gmail.com")->first();
        echo json_encode($account);
    }

    function Register(Request $request)
    {
        $email = $request->email;
        $pass = $request->pass;
        $accountid = "ID00000007";
        $typeaccount = "TYPEID03";
        $hashpass = Hash::make($pass);
        AccountModel::insert(['AccountID'=>$accountid, 'AccountEmail'=>$email, 'TypeOfAccountID'=>$typeaccount, 'HashPassword'=>$hashpass, 'Salt'=>'']);
        $account = AccountModel::where('AccountEmail', $email)->first();
        //$account = AccountModel::where('AccountEmail', "nguyet98@gmail.com")->first();
        echo json_encode($account);
    }

    public function WhyError(Request $request)
    {
        $email = $request->email;
        //echo json_encode($email);
        return response()->json($email);
    }

    public function UpdateAboutDoctorProfile(Request $request, $accountid)
    {
        $name = $request->Name;
        $birthday = $request->Birthday;
        $identifycard = $request->IdentifyCard;
        $gender = $request->Gender;
        $phone = $request->Phone;

        if ($name != "")
        {
            EmployeeModel::where('AccountID', $accountid)->update(['EmployeeName'=>$name]);
        }

        if ($birthday != "")
        {
            EmployeeModel::where('AccountID', $accountid)->update(['DayOfBirth'=>$birthday]);
        }

        if ($identifycard != "")
        {
            EmployeeModel::where('AccountID', $accountid)->update(['IdentifyCard'=>$identifycard]);
        }

        if ($gender != "")
        {
            EmployeeModel::where('AccountID', $accountid)->update(['Gender'=>$gender]);
        }

        if ($phone != "")
        {
            EmployeeModel::where('AccountID', $accountid)->update(['PhoneNumber'=>$phone]);
        }

        echo "Update Success!";

    }

    public function UpdateEducationalDoctorProfile(Request $request, $accountid)
    {
        $Degree = $request->Degree;
        $Speciality = $request->Speciality;
        $MedicalSchool = $request->MedicalSchool;
        $YearDegree = $request->YearDegree;

        if ($Degree != "")
        {
            EmployeeModel::where('AccountID', $accountid)->update(['Degree'=>$Degree]);
        }

        if ($Speciality != "")
        {
            EmployeeModel::where('AccountID', $accountid)->update(['Speciality'=>$Speciality]);
        }

        if ($MedicalSchool != "")
        {
            EmployeeModel::where('AccountID', $accountid)->update(['MedicalSchool'=>$MedicalSchool]);
        }

        if ($YearDegree != "")
        {
            EmployeeModel::where('AccountID', $accountid)->update(['YearOfDegree'=>$YearDegree]);
        }

        echo "Update Success!";
    }

    public function UpdateLisenceDoctorProfile(Request $request, $accountid)
    {
        $LicenseNumber = $request->LicenseNumber;
        $LicenseCountry = $request->LicenseCountry;
        $LicenseEXP = $request->LicenseEXP;

        if ($LicenseNumber != "")
        {
            EmployeeModel::where('AccountID', $accountid)->update(['LicenseNumber'=>$LicenseNumber]);
        }

        if ($LicenseCountry != "")
        {
            EmployeeModel::where('AccountID', $accountid)->update(['LicenseCountry'=>$LicenseCountry]);
        }

        if ($LicenseEXP != "")
        {
            EmployeeModel::where('AccountID', $accountid)->update(['LicenseEXP'=>$LicenseEXP]);
        }

        echo "Update Success!";
    }

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
        $employeename = EmployeeModel::where('AccountID', $accountid)->value('EmployeeName');
        echo $employeename;
    }

    public function ViewListPatient($accountid)
    {
        $employeeid = EmployeeModel::where('AccountID', $accountid)->value('EmployeeID');
        $patients = HealthRecordModel::join('patient', 'patient.PatientID', '=', 'healthrecord.PatientID')->select('patient.PatientID', 'patient.PatientName', 'patient.IdentifyCard', 'patient.AccountID', 'healthrecord.EmployeeID')->where('EmployeeID', $employeeid)->distinct()->get();
        echo json_encode($patients);
    }

    public function GetDoctorEmail($accountid)
    {
        $email = AccountModel::where('AccountID', $accountid)->value('AccountEmail');
        echo $email;
    }

    public function GetHealthRecordDetail($healthrecordid)
    {
        $healthrecordetail = HealthRecordModel::where('HealthRecordID', $healthrecordid)->first();
        echo json_encode($healthrecordetail);
    }

    public function GetProfile($accountid)
    {
        $employee = EmployeeModel::where('AccountID', $accountid)->first();
        echo json_encode($employee);
    }

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
            $employeeid = EmployeeModel::where('AccountID', $accountemployeeid)->value('EmployeeID');
            $patientid = PatientModel::where('AccountID', $accountpatientid)->value('PatientID');
            HealthRecordModel::insert(['HealthRecordID'=>'HR00000002', 'PatientID'=>$patientid, 'EmployeeID'=>$employeeid, 'HealthRecorDateTime'=>$HealthRecorDateTime, 'Description'=>$Description, 'Diagnosis'=>$Diagnosis, 'Result'=>$Result, 'Notes'=>$Notes, 'PatientView'=>$PatientView, 'TotalFee'=>$TotalFee]);
        
            echo "Add Health Record Success!";
        }

        
    }

    public function UpdateHealthRecord(Request $request, $healthrecordid)
    {
        $Description = $request->Description;
        $Diagnosis = $request->Diagnosis;
        $Result = $request->Result;
        $Notes = $request->Notes;
        $PatientView = $request->PatientView;
        $TotalFee = $request->TotalFee;

        //HealthRecordModel::where('HealthRecordID', $healthrecordid)->update(['Description'=>$Description, 'Diagnosis'=>$Diagnosis, 'Result'=>$Result, 'Notes'=>$Notes, 'PatientView'=>$PatientView, 'TotalFee'=>$TotalFee]);

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

    public function GetEmployeeID($healthrecordid)
    {
        $employeeid = HealthRecordModel::where('HealthRecordID', $healthrecordid)->value('EmployeeID');
        echo $employeeid;
    }
}