<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Model\EmployeeModel;
use App\Model\PatientModel;
use App\Model\HealthInsuranceModel;
use App\Model\EmergencyContactModel;
use App\Model\UserModel;

class ProfileController extends Controller
{
    /// Doctor
    public function GetDoctorProfile($accountid)
    {
        $employee = EmployeeModel::where('UserID', $accountid)->first();
        echo json_encode($employee);
    }
    
    public function GetDoctorEmail($accountid)
    {
        $email = UserModel::where('UserID', $accountid)->value('email');
        echo $email;
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
            EmployeeModel::where('UserID', $accountid)->update(['EmployeeName'=>$name]);
        }

        if ($birthday != "")
        {
            EmployeeModel::where('UserID', $accountid)->update(['DayOfBirth'=>$birthday]);
        }

        if ($identifycard != "")
        {
            EmployeeModel::where('UserID', $accountid)->update(['IdentifyCard'=>$identifycard]);
        }

        if ($gender != "")
        {
            EmployeeModel::where('UserID', $accountid)->update(['Gender'=>$gender]);
        }

        if ($phone != "")
        {
            EmployeeModel::where('UserID', $accountid)->update(['PhoneNumber'=>$phone]);
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
            EmployeeModel::where('UserID', $accountid)->update(['Degree'=>$Degree]);
        }

        if ($Speciality != "")
        {
            EmployeeModel::where('UserID', $accountid)->update(['Speciality'=>$Speciality]);
        }

        if ($MedicalSchool != "")
        {
            EmployeeModel::where('UserID', $accountid)->update(['MedicalSchool'=>$MedicalSchool]);
        }

        if ($YearDegree != "")
        {
            EmployeeModel::where('UserID', $accountid)->update(['YearOfDegree'=>$YearDegree]);
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
            EmployeeModel::where('UserID', $accountid)->update(['LicenseNumber'=>$LicenseNumber]);
        }

        if ($LicenseCountry != "")
        {
            EmployeeModel::where('UserID', $accountid)->update(['LicenseCountry'=>$LicenseCountry]);
        }

        if ($LicenseEXP != "")
        {
            EmployeeModel::where('UserID', $accountid)->update(['LicenseEXP'=>$LicenseEXP]);
        }

        echo "Update Success!";
    }

    /// Patient
    public function GetPatientEmail($accountid)
    {
        $email = UserModel::where('UserID', $accountid)->value('email');
        echo $email;
    }

    public function GetPatientProfile($accountid)
    {
        $patient = PatientModel::where('UserID', $accountid)->first();
        echo json_encode($patient);
    }

    public function GetEmergency($accountid)
    {
        $patient = PatientModel::where('UserID', $accountid)->first();
        $emergencycontact = EmergencyContactModel::where('PatientID', $patient->PatientID)->first();
        echo json_encode($emergencycontact);
    }

    public function GetInsurance($accountid)
    {
        $patient = PatientModel::where('UserID', $accountid)->first();
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
            PatientModel::where('UserID', $accountid)->update(['PatientName'=>$PatientName]);
        }

        if ($DayOfBirth != "")
        {
            PatientModel::where('UserID', $accountid)->update(['DayOfBirth'=>$DayOfBirth]);
        }

        if ($IdentifyCard != "")
        {
            PatientModel::where('UserID', $accountid)->update(['IdentifyCard'=>$IdentifyCard]);
        }

        if ($Gender != "")
        {
            PatientModel::where('UserID', $accountid)->update(['Gender'=>$Gender]);
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
            PatientModel::where('UserID', $accountid)->update(['PhoneNumber'=>$PhoneNumber]);
        }

        if ($Address != "")
        {
            PatientModel::where('UserID', $accountid)->update(['Address'=>$Address]);
        }

        if ($District != "")
        {
            PatientModel::where('UserID', $accountid)->update(['District'=>$District]);
        }

        if ($City != "")
        {
            PatientModel::where('UserID', $accountid)->update(['City'=>$City]);
        }

        if ($Country != "")
        {
            PatientModel::where('UserID', $accountid)->update(['Country'=>$Country]);
        }

        echo "Update Success!";
    }

    public function UpdateEmergencyPatientProfile(Request $request, $accountid)
    {
        $EmergencyContactName = $request->EmergencyContactName;
        $EmergencyPhoneNumber = $request->EmergencyPhoneNumber;
        $RelationShip = $request->RelationShip;
        $patientid = PatientModel::where('UserID', $accountid)->value('PatientID');
        $emergency  = EmergencyContactModel::where('PatientID', $patientid)->first();

        if ($emergency == "")
        {
            EmergencyContactModel::insert(['PatientID'=>$patientid, 'EmergencyContactName'=>$EmergencyContactName, 'EmergencyPhoneNumber'=>$EmergencyPhoneNumber, 'RelationShip'=>$RelationShip]);
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
        $patientid = PatientModel::where('UserID', $accountid)->value('PatientID');
        $health  = HealthInsuranceModel::where('PatientID', $patientid)->first();

        if ($health == "")
        {
            HealthInsuranceModel::insert(['PatientID'=>$patientid, 'HealthInsuranceCardCode'=>$HealthInsuranceCardCode, 'HospitalRegister'=>$HospitalRegister, 'HealthInsuranceMFD'=>$HealthInsuranceMFD, 'HealthInsuranceEXP'=>$HealthInsuranceEXP]);
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
