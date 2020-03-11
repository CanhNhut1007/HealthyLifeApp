<?php

namespace App\Http\Controllers\User;

use App\Http\Controllers\Controller;
use Illuminate\Foundation\Auth\SendsPasswordResetEmails;
use Illuminate\Support\Facades\Validator;
use App\Model\User;
use App\Model\Password_resets;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Str;
use Illuminate\Support\Facades\Hash;
Use App\Jobs\SendEmail;


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

    public function resetpassword(Request $request){

        $this->validate($request, [
            'email'   => 'required|email'
        ]);
      
        $UserID = User::where('email',$request->get('email'))
                    ->where('active',User::ACTIVE)
                    ->value('UserID');

        if(!empty($UserID)){
            $password_reset = Password_resets::create([
                'UserID' => $UserID,
                'codeverify' => rand(100000,999999),
            ]);

            $password_resets = array (
                'email' => $request->get('email'),
                'codeverify' => $password_reset->codeverify
            );    

            $view = 'member/auth/email/emailverifyresetpassword';
            $subject = '[HealthLife] Reset your account';
            $this->dispatch(new SendEmail($password_resets,$view, $subject));

            return redirect()->route('verifyresetpassword')//,['email'=> $user->email])//,array('email' =>  $user->email,'success' => 'Congratulations! Your account has been made, an email has been sent to your email. Please enter your code in this email message to verify your account and complete registration.'));
                            ->with([ 'email' => $request->get('email')]) 
                            ->with(['success' => "Check your inbox! We've sent a verification code, please enter code and you will be reset password."]);
        }
        else{
            return redirect()->route('forgotpassword')->with('error', 'Invalid email or your account not active!');
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

        $UserID = User::where('email',$request->get('email'))
                        ->where('active',User::ACTIVE)
                        ->value('UserID');
        $passwordreset = Password_resets::where('UserID',$UserID)
                    ->where('codeverify', $verify["codeverify"])->first();

        if (empty($passwordreset)) {
            return redirect()->route('verifyresetpassword')->with(['error' => 'Your code reset password is either expired or invalid.'])
            ->with([ 'email' => $request->get('email')]) ;
        }

        $passwordreset->codeverify = 0;
        $passwordreset->save();

        $new_password = Str::random(6);
        User::where('email',$verify["email"])
            ->update(['password' => Hash::make($new_password)]);

        $view = "member/auth/email/emailsendnewpassword";
        $new_user = array ('email' => $verify["email"],
                            'password'=> $new_password);
        $subject = '[HealthLife] Your new password from HealthLife';
        dispatch(new SendEmail($new_user,$view,$subject));

        return redirect()->route("login")
        ->with(['success' => 'Congratulations! Your password is reseted.']);
    }
    
    public function ShowResetPasswordForm(){
        return view('member/auth/showresetpassword');
    }

    public function Showverifyresetpassword(){
        return view('member/auth/showverifyresetpassword');
    }
}