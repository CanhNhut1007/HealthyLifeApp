<?php

namespace App\Http\Controllers\Auth;
use App\User;
use App\Http\Controllers\Controller;
use Illuminate\Foundation\Auth\AuthenticatesUsers;
use Illuminate\Support\Facades\Validator;
use Illuminate\Support\Facades\Auth;
use Illuminate\Http\Request;

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
    protected $redirectTo = 'user/login';

    /**
     * Create a new controller instance.
     *
     * @return void
     */
    public function __construct()
    {
        $this->middleware('guest')->except('logout');
    }
    
    public function field(Request $request)
    {
        $email = $this->email();

        return filter_var($request->get($email), FILTER_VALIDATE_EMAIL) ? $email : '';
    }

    protected function credentials(Request $request)
    {
        return [
            'email' => $request->get('email'),
            'password' => $request->get('password'),
            'active' => User::ACTIVE,
        ];
    }

    /**
     * Validate the user login request.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return void
     */

    protected function validateLogin(Request $request)
    {
       // $userdata = credentials($request);
        
       // $messages = ["{"this.email()""}.exists" => ''];

        // $this->validate($this.email()request, [The account you are trying to login is not activated or it has been disabled.
        //      => "required|exists:users",
        //     'active'=> User::ACTIVE,
        //     'password' => 'required',
        // ], $messages);

        // if (Auth::attempt($userdata)){
        //     return redirect()->intended('Account');
        // }
        $email = $request->get('email');
        $password = $request->get('password');
        $active = User::ACTIVE;
        if(Auth::attempt(['email'=>$email,'password'=>$password])){
            if(Auth::attempt(['active'=>$active])) {
                return redirect()->route('profile');
            }
            else {
                return view('user/login')->with(['error'=>'The account you are trying to login is not activated or it has been disabled.']);
            }
        } 
        else {
            return view('user/login')->with(['error'=>'Invalid email and password combination. Please try again.']);
        }

    }
    
    public function logout(Request $request){
        $request ->session()->flush();
        return redirect('admin/login');
    }

    protected function ShowLoginHome(){
        return view('user/Login');
    }
}
