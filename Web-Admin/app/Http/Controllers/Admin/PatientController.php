<?php

namespace App\Http\Controllers\Admin;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Model\Patient;

class PatientController extends Controller
{
    public function ShowListPatient()
    {
        $listpatients = Patient::join('users', 'users.UserID', '=', 'Patient.UserID')->select('patient.PatientID','patient.PatientName','users.email','patient.IdentifyCard')->get();
        return view('admin/patient')->with(['listpatients' => $listpatients]);
    }
}
