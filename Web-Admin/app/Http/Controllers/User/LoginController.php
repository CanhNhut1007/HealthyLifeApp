<?php

namespace App\Http\Controllers\User;
use App\Model\User;
use App\Model\Role;
use App\Http\Controllers\Controller;
use Illuminate\Foundation\Auth\AuthenticatesUsers;
use Illuminate\Support\Facades\Validator;
use Illuminate\Support\Facades\Auth;
use Illuminate\Http\Request;
use Illuminate\Http\Response;

class LoginController extends Controller
{
    /*
    |--------------------------------------------------------------------------
    | Login Controller
    |--------------------------------------------------------------------------
    |
    | This controller handles authenticating users for the application and
    | redirecting them to your home screen. The controller uses a trait
    | to conveniently provide its functionality to your applications.
    |
    */

    use AuthenticatesUsers;

    /**
     * Where to redirect users after login.
     *
     * @var string
     */
    protected $redirectTo = 'member/login';

    /**
     * Create a new controller instance.
     *
     * @return void
     */
    public function __construct()
    {
        $this->middleware('guest')->except('logout');
    }

    function checklogin(Request $request){
        $this->validate($request, [
            'email'   => 'required|email',
            'password'  => 'required|min:6'
        ]);

        $roleID = Role::where('RoleName','user')->value('RoleID');

        $user_data = array(
            'email'  => $request->get('email'),
            'RoleID' => $roleID,
            'password' => $request->get('password'),
            'active' => User::ACTIVE
        );
      
        if(Auth::attempt($user_data)){
            return redirect()->route('user.home');
        }
        else{
            return back()->with('error', 'Invalid email and password combination. Please try again.');
        }
    }

    /**
     * Validate the user login request.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return void
     */

    
    public function logout(Request $request){
        $request->session()->flush();
        Auth::logout();
        return redirect()->route('user.login');
    }

    protected function ShowLoginHome(){
        return view('member/auth/login');
    }
}
