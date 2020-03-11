<?php

namespace App\Http\Controllers\User;
use Illuminate\Support\Facades\Auth;
use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Model\Patient;

class AccountController extends Controller
{
    public function index()
    {
        $UserID = Auth::id();
        $PatientName = Patient::where('UserID',$UserID)->value('PatientName');
        return view('member/main/account')->with(['PatientName' => $PatientName ]);
    }
}
