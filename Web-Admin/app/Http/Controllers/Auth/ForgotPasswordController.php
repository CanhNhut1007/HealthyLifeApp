<?php

namespace App\Http\Controllers\Auth;

use App\Http\Controllers\Controller;
use Illuminate\Foundation\Auth\SendsPasswordResetEmails;
use Illuminate\Support\Facades\Validator;
use App\User;
use App\Password_reset;
use Illuminate\Http\Request;
use App\Mail\SendMailable;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\Mail;
use Illuminate\Support\Str;
use Illuminate\Support\Facades\Hash;


class ForgotPasswordController extends Controller
{
    /*
    |--------------------------------------------------------------------------
    | Password Reset Controller
    |--------------------------------------------------------------------------
    |
    | This controller is responsible for handling password reset emails and
    | includes a trait which assists in sending these notifications from
    | your application to your users. Feel free to explore this trait.
    |
    */

    use SendsPasswordResetEmails;

    protected function create(array $data)
    {
        $password_resets= Password_reset::create([
            'email' => $data['email'],
            'codeverify' => rand(100000,999999),
        ]);

        return $password_resets;
    }

    protected function validator(array $data)
    {
        return Validator::make($data, [
            'email' => 'required|email',
        ]);
    }

    public function resetpassword(Request $request){
        // $this->validator($request->all())->validate();
        // $email = $request->get('email');
        // $active = User::ACTIVE;
        // if(Auth::attempt(['email'=>$email])){
            // if(Auth::attempt(['active'=>$active])) {              
            //     $password_resets = $this->create($request->all());
            //     $view = 'emailverifyresetpassword';
            //     Mail::to($password_resets->email)->send(new SendMailable($password_resets,$view));

            //     return redirect()->route('resetpasswordverify')//,['email'=> $user->email])//,array('email' =>  $user->email,'success' => 'Congratulations! Your account has been made, an email has been sent to your email. Please enter your code in this email message to verify your account and complete registration.'));
            //                     ->with([ 'email' => $password_resets->email ]) 
            //                     ->with(['success' => "Check your inbox! We've sent a verification code, please enter code and you will be reset password."]);
            // }
        //     else {
        //         return view('showresetpassword')->with(['error'=>'The account you are trying to login is not activated or it has been disabled.']);
        //     }
        // } 
        // else {
        //     return view('showresetpassword')->with(['error'=>'Invalid email and password combination. Please try again.']);
        // }
        $this->validate($request, [
            'email'   => 'required|email'
        ]);
      
        $user = User::where('email',$request->get('email'))
                        ->where('active',User::ACTIVE)
                        ->first();
        if(!empty($user)){
            $password_resets = $this->create($request->all());
            $view = 'emailverifyresetpassword';
            Mail::to($password_resets->email)->send(new SendMailable($password_resets,$view));

            return redirect()->route('resetpasswordverify')//,['email'=> $user->email])//,array('email' =>  $user->email,'success' => 'Congratulations! Your account has been made, an email has been sent to your email. Please enter your code in this email message to verify your account and complete registration.'));
                            ->with([ 'email' => $password_resets->email ]) 
                            ->with(['success' => "Check your inbox! We've sent a verification code, please enter code and you will be reset password."]);
        }
        else{
            return back()->with('error', 'Invalid email or your account not active!');
        }
    }

    public function verifycoderesetpassword(Request $request){
        
        $this->validate($request, [
            'email'   => 'required|email',
            'codeverify'  => 'required'
        ]);

        $verify = array (
            'email' => $request->get('email'),
            'codeverify' => $request->get('codeverify')
        );

        $passwordreset = Password_reset::where('email', $verify["email"])
                    ->where('codeverify', $verify["codeverify"])->first();

        if (empty($passwordreset)) {
            return back()->with(['error' => 'Your code reset password is either expired or invalid.']);
        }

        $passwordreset->codeverify = 0;
        $passwordreset->save();

        $new_password = Str::random(6);
        User::where('email',$verify["email"])
            ->update(['password' => Hash::make($new_password)]);
        $view = 'emailsendnewpassword';
        $new_user = array ('email' => $verify["email"],
                            'password'=> $new_password);

        Mail::to($verify["email"])->send(new SendMailable($new_user,$view));
        return redirect()->route("login")
        ->with(['success' => 'Congratulations! Your password is reseted.']);
    }
    
    public function ShowResetPasswordForm(){
        return view('showresetpassword');
    }

    public function Showverifyresetpassword(){
        return view('showverifyresetpassword');
    }
}