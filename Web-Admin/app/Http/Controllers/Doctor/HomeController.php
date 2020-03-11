<?php

namespace App\Http\Controllers\Doctor;
use Illuminate\Support\Facades\Auth;
use Illuminate\Routing\Controller;
use App\Model\Employee;
use App\Model\Patient;
use Illuminate\Http\Request;

class HomeController extends Controller {
    public function index()
    {
        $UserID = Auth::id();
        $EmployeeName = Employee::where('UserID',$UserID)->value('EmployeeName');
        $Patients = Patient::all();
        return view('doctor/main/home')->with(['EmployeeName' => $EmployeeName, 'patients' => $Patients, 'mess'=>""]);
    }

    function search(Request $request)
    {
        $UserID = Auth::id();
        $EmployeeName = Employee::where('UserID',$UserID)->value('EmployeeName');        
        $patients = Patient::where( 'PatientName', 'like', '%' . $request->q . '%' )->orWhere ( 'IdentifyCard', 'like', '%' . $request->q . '%' )->orWhere ( 'PatientID', 'like', '%' . $request->q . '%' )->get ();
        
        if (count ( $patients ) > 0)
            return view('doctor/main/home')->with([ 'id' => $UserID, 'EmployeeName'=> $EmployeeName, 'patients'=>$patients, 'mess'=>""]);
        else
            return view ('doctor/main/home')->with([ 'id' => $UserID, 'EmployeeName'=> $EmployeeName, 'patients'=>$patients, 'mess'=>"No Result found. Try to search again!"]);
    }

    public function redirect()
    {
        // The '/admin' route is not to be used as a page, because it breaks the menu's active state.
        //return redirect(backpack_url('dashboard'));
        return redirect('doctor/home');
    }
}