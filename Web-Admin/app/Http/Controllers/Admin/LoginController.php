<?php
namespace App\Http\Controllers\Admin;

use Illuminate\Foundation\Auth\AuthenticatesUsers;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use App\Http\Controllers\Controller;
use App\Model\Role;
use App\Model\Admin;

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
        $this->middleware('guest:admin')->except('logout');
    }

    public function guard()
    {
        return Auth::guard('admin');
    }

    public function showLoginForm()
    {
        return view('admin/auth/login');
    }
    public function login(Request $request){
        $roleID = Role::where('RoleName','admin')->value('RoleID');

        $user_data = array(
            'email'  => $request->get('email'),
            'RoleID' => $roleID,
            'password' => $request->get('password'),
            'active' => Admin::ACTIVE,
        );
        
        if(Auth::guard('admin')->attempt($user_data)){
            $request->session()->put('email',$request->get('email'));
            return redirect('admin/dashboard');
        }
        else{
             return back()->with('error', 'Invalid email and password combination. Please try again.');
        }
    }

    public function logout(Request $request){
        $request->session()->flush();
        Auth::logout();
        return redirect('admin/login');
    }

}