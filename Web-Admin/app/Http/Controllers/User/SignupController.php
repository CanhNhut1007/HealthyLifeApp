<?php

namespace App\Http\Controllers\User;

use App\Http\Controllers\Controller;
use App\Model\User;
use App\Model\Role;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Hash;
use Illuminate\Support\Facades\Validator;
Use App\Jobs\SendEmail;


class SignupController extends Controller
{
    /*
    |--------------------------------------------------------------------------
    | Register Controller
    |--------------------------------------------------------------------------
    |
    | This controller handles the registration of new users as well as their
    | validation and creation. By default this controller uses a trait to
    | provide this functionality without requiring any additional code.
    |
    */

    /**
     * Where to redirect users after registration.
     *
     * @var string
     */
    protected $redirectTo = 'member/auth/signup';

    /**
     * Create a new controller instance.
     *
     * @return void
     */
    public function __construct()
    {
        $this->middleware('guest');
    }

    /**
     * Get a validator for an incoming registration request.
     *
     * @param  array  $data
     * @return \Illuminate\Contracts\Validation\Validator
     */
    protected function validator(array $data)
    {
        return Validator::make($data, [
            'email' => 'required|string|email|max:255|unique:users',
            'password' => 'required|string|min:6|confirmed',
        ]);
    }

    public function signup(Request $request)
    {
        $this->validator($request->all())->validate();

        $roleID = Role::where('RoleName','user')->value('RoleID');

        $userexist = User::where('email',$request->get('email'))
                    ->where('RoleID',$roleID)->first();
        if(empty($userexist)){
            $user = User::create([
                'email' => $request->get('email'),
                'RoleID' => $roleID,
                'password' => Hash::make($request->get('password')),
                'codeverify' => rand(100000,999999),
                'active' => 0
            ]);
    
            $newuser  = array (
                'email' => $request->get('email'),
                'RoleID' => $roleID,
                'codeverify' => $user->codeverify,
            );
    
            $view = 'member/auth/email/emailverifyaccount';
            $subject = '[HealthLife] Please verify your account';
            $this->dispatch(new SendEmail($newuser,$view,$subject));
            
            return redirect()->route('verify')
                    ->with([ 'email' => $user->email ]) 
                    ->with(['success' => 'Congratulations! Your account has been made, an email has been sent to your email. Please enter your code in this email message to verify your account and complete registration.']);    
        }
        else {
            return back()->with('errors_email', 'The email has already been taken.');
        }
    }

    public function ShowSignupForm(){
        return view('member/auth/signup');
    }

    public function ShowWelcomeForm(){
        return view('member/auth/welcome');
    }
}