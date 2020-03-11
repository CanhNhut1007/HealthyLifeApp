<?php

namespace App\Http\Controllers\User;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use App\Model\HealthRecord;


class HealthRecordDetailController extends Controller
{
    public function index($healthrecordid)
    {
        $id = Auth::id();
        $healthrecord = HealthRecord::join('employee', 'employee.EmployeeID', '=', 'healthrecord.EmployeeID')->where('HealthRecordID', $healthrecordid)->first();
        return view('member/main/healthrecorddetail')->with(['id' => $id,'healthrecord'=>$healthrecord]);
    }
}
