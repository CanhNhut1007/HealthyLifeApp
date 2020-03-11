<?php

namespace App\Http\Controllers\User;
use Illuminate\Support\Facades\Auth;
use Illuminate\Routing\Controller;
use Illuminate\Http\Request;

use App\Model\Patient;
use App\Model\Employee;

class HomeController extends Controller {

    public function index()
    {
        $id = Auth::id();
        $patientname = Patient::where('UserID', $id)->value('PatientName');
        $employee = Employee::all();
        return view('member/main/home')->with([ 'id' => $id, 'patientname'=> $patientname, 'employee'=>$employee, 'mess'=>""]);
    }

    function search(Request $request)
    {
        $id = Auth::id();
        $patientname = Patient::where('UserID', $id)->value('PatientName');
        $employee = Employee::where( 'EmployeeName', 'like', '%' . $request->q . '%' )->orWhere ( 'Speciality', 'like', '%' . $request->q . '%' )->orWhere ( 'EmployeeID', 'like', '%' . $request->q . '%' )->get ();
        if (count ( $employee ) > 0)
            return view('member/main/home')->with([ 'id' => $id, 'patientname'=> $patientname, 'employee'=>$employee, 'mess'=>""]);
        else
            return view ('member/main/home')->with([ 'id' => $id, 'patientname'=> $patientname, 'employee'=>$employee, 'mess'=>"No Result found. Try to search again!"]);
    }

    public function redirect()
    {
        // The '/admin' route is not to be used as a page, because it breaks the menu's active state.
        //return redirect(backpack_url('dashboard'));
        return redirect('member/home');
    }
}