<?php

namespace App\Http\Controllers\Doctor;

use App\Http\Controllers\Controller;
use Illuminate\Support\Facades\Auth;
use Illuminate\Http\Request;
use App\Model\Employee;

class AccountController extends Controller
{
    public function index()
    {
        $UserID = Auth::id();
        $EmployeeName = Employee::where('UserID',$UserID)->value('EmployeeName');
        return view('doctor/main/account')->with(['employeename' => $EmployeeName ]);
    }
}
