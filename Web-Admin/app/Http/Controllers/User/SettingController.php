<?php

namespace App\Http\Controllers\User;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\Hash;
use App\Model\User;

class SettingController extends Controller
{
    function index(){
        $user = Auth::user();
        $email = $user ->email;
        $id = Auth::id();
        return view('member/main/setting', ['accountid'=>$id, 'accountemail'=>$email]);
    }

    function updateemail(Request $request)
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
        return view('member/main/setting', ['accountid'=>$id, 'accountemail'=>$email]);
    }

    function updatepassword(Request $request)
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
        return view('member/main/setting', ['accountid'=>$id, 'accountemail'=>$email]);
    }
}
