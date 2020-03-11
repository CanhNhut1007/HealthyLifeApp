<?php

namespace App\Http\Controllers\Doctor;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\Hash;
use App\Model\User;

class SettingController extends Controller
{
    public function index()
    {
        $UserID = Auth::id();
        $email = User::where('UserID',$UserID)->value('email');
        return view('doctor/main/setting')->with(['email' => $email ]);
    }

    public function updateemail(Request $request)
    {
        $this->validate($request, [
            'NewEmail'   => 'required|email',
            'Password'  => 'required|min:6'
        ]);

        $user_data = array(
            'email'  => $request->get('email'),
            'password' => $request->get('Password'),
        );
      
        if(Auth::attempt($user_data)){
            User::where('email', $request->get('email'))->update(['email'=> $request->get('NewEmail')]);
        }

        $id = Auth::id();
        $email = User::where('UserID', $id)->value('email');
        return view('doctor/main/setting', ['accountid'=>$id, 'email'=>$email]);
    }

    public function updatepassword(Request $request)
    {
        $this->validate($request, [
            'Password'  => 'required|min:6',
            'NewPassword'  => 'required_with:password_confirmation|same:password_confirmation|min:6',
            'password_confirmation' => 'required|min:6'
        ]);

        $user_data = array(
            'email'  => $request->get('email'),
            'password' => $request->get('Password'),
        );
      
        if(Auth::attempt($user_data)){
            $pass = Hash::make($request->get('NewPassword'));
            User::where('email', $request->get('email'))->update(['password'=> $pass]);
        }

        $id = Auth::id();
        $email = User::where('UserID', $id)->value('email');
        return view('doctor/main/setting', ['accountid'=>$id, 'email'=>$email]);
    }
}
