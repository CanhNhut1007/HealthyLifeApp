<?php

namespace App\Http\Controllers\Auth;

use App\Http\Controllers\Controller;
use App\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Hash;
use Illuminate\Support\Facades\Validator;
use App\Mail\SendMailable;

use Illuminate\Support\Facades\Mail;


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
    protected $redirectTo = 'user/signup';

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

    /**
     * Create a new user instance after a valid registration.
     *
     * @param  array  $data
     * @return \App\User
     */
    protected function create(array $data)
    {
        $user= User::create([
            'email' => $data['email'],
            'password' => Hash::make($data['password']),
            'codeverify' => rand(100000,999999),
        ]);
        return $user;
    }

    public function signup(Request $request)
    {
        $this->validator($request->all())->validate();

        $user = $this->create($request->all());
        $view = 'emailverifyaccount';

        Mail::to($user->email)->send(new SendMailable($user,$view));
        
        return redirect()->route('verify')//,['email'=> $user->email])//,array('email' =>  $user->email,'success' => 'Congratulations! Your account has been made, an email has been sent to your email. Please enter your code in this email message to verify your account and complete registration.'));
                ->with([ 'email' => $user->email ]) 
                ->with(['success' => 'Congratulations! Your account has been made, an email has been sent to your email. Please enter your code in this email message to verify your account and complete registration.']);
    }

    public function ShowSignupForm(){
        return view('user/signup');
    }
}