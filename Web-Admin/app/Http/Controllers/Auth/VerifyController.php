<?php

namespace App\Http\Controllers\Auth;

use App\Http\Controllers\Controller;
use App\Notifications\UserActive;
use App\User;
use Illuminate\Auth\Events\Registered;
use Illuminate\Foundation\Auth\RegistersUsers;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Hash;
use Illuminate\Support\Facades\Validator;

class VerifyController extends Controller
{
    public function __construct()
    {
        $this->middleware('guest')->except('logout');
    }
    
    public function ShowVerify(Request $request){
        return view('user/verify');
    }

    public function activate(Request $request)
    {
        $this->validate($request, [
            'email'   => 'required|email',
            'codeverify'  => 'required'
        ]);
        $verify = array (
            'email' => $request->get('email'),
            'codeverify' => $request->get('codeverify')
        );

        $user = User::where('email', $verify["email"])
                    ->where('codeverify', $verify["codeverify"])->first();
                    
        if (empty($user)) {
            return redirect()->to('/')
                ->with(['error' => 'Your activation code is either expired or invalid.']);
        }
        $user->codeverify = 0;
        $user->active = User::ACTIVE;

        $user->save();
        return redirect()->route("login")
        ->with(['success' => 'Congratulations! Your account is actived.']);
    }
}
