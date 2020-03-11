<?php

namespace App\Http\Controllers\Admin;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Model\Employee;
use App\Model\Role;
use App\Model\User;
use App\Model\Hospital;

class DoctorController extends Controller
{
    public function ShowListDoctor()
    {
        $listdoctors = Employee::join('users', 'users.UserID', '=', 'Employee.UserID')->join('hospitalaffiliation', 'hospitalaffiliation.HospitalID', '=', 'Employee.HospitalID')->select('employee.EmployeeID','employee.EmployeeName','users.email', 'employee.Speciality','hospitalaffiliation.HospitalName')->get();
        return view('admin/doctor')->with(['listdoctors' => $listdoctors]);
    }

    public function ShowAddDoctor()
    {
        $roleID = Role::where('RoleName','doctor')->value('RoleID');
        $listemail = User::where('RoleID',$roleID)->where('active',0)->get();
        $listhospital = Hospital::get();
        return view('admin/adddoctor')->with(['listemail' => $listemail,'listhospital'=>$listhospital]);
    }

    public function AddDoctor(Request $request)
    {

        try {
            $UserID = User::where('email',$request->email)->value('UserID');
            Employee::insert(['UserID'=> $UserID,'EmployeeName'=>$request->EmployeeName, 'IdentifyCard'=>$request->IdentifyCard, 'DayOfBirth'=>$request->DayofBirth, 'Gender'=>$request->Gender, 'PhoneNumber'=>$request->PhoneNumber,
                                                                    'Degree'=>$request->Degree, 'Speciality'=>$request->Speciality, 'MedicalSchool'=>$request->MedicalSchool, 'YearOfDegree'=>$request->YearOfDegree,
                                                                    'LicenseNumber'=>$request->LicenseNumber, 'LicenseCountry'=>$request->LicenseCountry, 'LicenseEXP'=>$request->LicenseEXP,'HospitalID' => $request->hospital]);    
        } catch (\Illuminate\Database\QueryException $e) {
            return redirect()->route('admin.showadddoctor')->with(['error' => 'You need to create user before create doctor!!']);

        }
        User::where('UserID', $UserID)->update(['active' => 1]);
        return redirect()->route('admin.showadddoctor')->with(['success' => 'Create doctor success!!']);
    }
}