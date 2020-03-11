<?php

namespace App\Http\Controllers\Admin;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Model\Hospital;

class HospitalController extends Controller
{
    public function ShowListHospital()
    {
        $listrole = Hospital::get();
        $number = 1;
        return view('admin/hospital')->with(['listhospitals' => $listrole,'number' => $number]);
    }

    public function ShowAddHospital()
    {
        return view('admin/addhospital');
    }

    public function AddHospital(Request $request)
    {
        $hospital = Hospital::create([
            'HospitalName' => $request->get('hospitalname'),
            'City' => $request->get('city'),
            'Country' =>  $request->get('country')
        ]);
        return redirect()->route('admin.showaddhospital')->with(['success' => 'Create hospital success!!']);    
    }

}