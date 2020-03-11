<?php

namespace App\Http\Controllers\User;

use App\Mail\SendMailable;

use Illuminate\Support\Facades\Mail;

use Illuminate\Http\Request;
use App\Model\User;
use Illuminate\Support\Facades\Auth;
use Validator;

class MainController extends Controller
{
    function index() {
        return view('member/login');
    }

    protected function ShowLoginHome(){
        return view('member/login');
    }

    protected function validator(array $data)
    {
        return Validator::make($data, [
            'email' => 'required|string|email|max:255|unique:users',
            'password' => 'required|string|min:6|confirmed',
        ]);
    }

    function checksignup(Request $request){
        $this->validator($request->all())->validate();

        return redirect()->route('login')
            ->with(['success' => 'Congratulations! Your account is registered, you will shortly receive an email to activate your account.']);
    }

    function checklogin(Request $request){
        $this->validate($request, [
            'email'   => 'required|email',
            'password'  => 'required|min:3'
        ]);
      
           $user_data = array(
            'email'  => $request->get('email'),
            'password' => $request->get('password'),
            'active' => User::ACTIVE
           );
      
           if(Auth::attempt($user_data))
           {
               return view('Account');
           }
           else
           {
                return back()->with('error', 'Invalid email and password combination. Please try again.');
           }
    }
}
