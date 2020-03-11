<?php
namespace App\Http\Controllers\Doctor;

use Illuminate\Foundation\Auth\AuthenticatesUsers;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use App\Http\Controllers\Controller;
use App\Model\User;
use App\Model\Role;

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
    /**
     * Create a new controller instance.
     *
     * @return void
     */

    public function __construct()
    {
        $this->middleware('guest:doctor')->except('logout');
    }

    public function guard()
    {
        return Auth::guard('doctor');
    }

    public function showLoginForm()
    {
        return view('doctor/auth/login');
    }
    public function login(Request $request){

        $this->validate($request, [
            'email'   => 'required|email',
            'password'  => 'required|min:6'
        ]);

        $roleID = Role::where('RoleName','doctor')->value('RoleID');

        $user_data = array(
            'email'  => $request->get('email'),
            'RoleID' => $roleID,
            'password' => $request->get('password'),
            'active' => User::ACTIVE
        );
      
        if(Auth::guard('doctor')->attempt($user_data)){
            $request->session()->put('email',$request->get('email'));
            return redirect('doctor/home');
        }
        else{
            return back()->with('error', 'Invalid email and password combination. Please try again.');
        }
    }

    public function logout(Request $request){
        $request->session()->flush();
        Auth::logout();
        return redirect('doctor/login');
    }

}