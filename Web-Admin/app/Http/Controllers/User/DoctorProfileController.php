<?php

namespace App\Http\Controllers\User;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;

use App\Model\Patient;
use App\Model\Employee;

class DoctorProfileController extends Controller
{
    public function index($userid)
    {
        $id = Auth::id();
        $employee = Employee::where('UserID', $userid)->first();
        return view('member/main/doctorprofile')->with([ 'id' => $id, 'employee'=> $employee ]);
    }
}
