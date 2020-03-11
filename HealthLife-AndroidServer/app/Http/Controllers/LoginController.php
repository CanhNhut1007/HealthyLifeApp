<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Model\UserModel;
use Illuminate\Foundation\Auth\AuthenticatesUsers;
use Illuminate\Support\Facades\Validator;
use Illuminate\Support\Facades\Auth;


class LoginController extends Controller
{
    use AuthenticatesUsers;

    public function Login(Request $request)
    {
        $user_data = array(
            'email'  => $request->get('email'),
            'RoleID' => 820000000,
            'password' => $request->get('pass'),
            'active' => UserModel::ACTIVE
        );

        $user_data1 = array(
            'email'  => $request->get('email'),
            'RoleID' => 820000002,
            'password' => $request->get('pass'),
            'active' => UserModel::ACTIVE
        );
      
        if((Auth::attempt($user_data)) || (Auth::attempt($user_data1))){
            $user = UserModel::where('email',$request->get('email'))->first();
            echo json_encode($user);
        }
        else{
            echo "Loi";
        }
    }
}
