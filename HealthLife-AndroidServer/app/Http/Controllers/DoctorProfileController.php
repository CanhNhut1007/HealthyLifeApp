<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Model\EmployeeModel;

class DoctorProfileController extends Controller
{
    public function GetDoctorProfile($accountid)
    {
        $employee = EmployeeModel::where('UserID', $accountid)->first();
        echo json_encode($employee);
    }
}
