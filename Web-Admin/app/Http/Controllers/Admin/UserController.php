<?php

namespace App\Http\Controllers\Admin;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Model\Role;
use App\Model\User;
use App\Charts\UserChart;
use Illuminate\Support\Facades\Validator;
use Illuminate\Support\Facades\Hash;

class UserController extends Controller
{
    public function ShowNewUser(){
        $roleID = Role::where('RoleName','user')->value('RoleID');
        $arraymonth = array (
                array(0,'Jan'),
                array(1,'Feb'),
                array(2,'Mar'),
                array(3,'Apr'),
                array(4,'May'),
                array(5,'Jun'),
                array(6,'July'),
                array(7,'Aug'),
                array(8,'Sep'),
                array(9,'Oct'),
                array(10,'Nov'),
                array(11,'Dec')
        );

        $month =date('m')-3;

        if($month == -2){
            $month1 = 10;
            $month2 = 11;
            $month3 = 0;
        }elseif($month == -1) {
            $month1 = 11;
            $month2 = 0;
            $month3 = 1;
        }
        else {
            $month1 = $arraymonth[$month++][0];
            $month2 =$arraymonth[$month++][0];
            $month3 = $arraymonth[$month][0];
        }

        $newusermonth1 =  User::whereMonth('created_at', '=', $month1+1)->where('active',1)->where('RoleID',$roleID)->count();
        $newusermonth2 = User::whereMonth('created_at', '=', $month2+1)->where('active',1)->where('RoleID',$roleID)->count();
        $newusermonth3 = User::whereMonth('created_at', '=', $month3+1)->where('active',1)->where('RoleID',$roleID)->count();

        $usersChart = new UserChart;
        $usersChart->labels([$arraymonth[$month1][1], $arraymonth[$month2][1], $arraymonth[$month3][1]]);
        $usersChart->dataset('New User in 3 Month', 'line', [$newusermonth1,  $newusermonth2, $newusermonth3])
            ->color("rgb(255, 99, 132)")
            ->backgroundcolor("rgb(255, 99, 132)");
        return view('admin/newuser')->with(['usersChart' => $usersChart]);
    }

    public function ShowListUser()
    {
        $listusers = User::join('role', 'role.RoleID', '=', 'users.RoleID')->select('users.UserID','users.email','role.RoleName','users.active')->get();
        return view('admin/user')->with(['listusers' => $listusers]);
    }

    public function ShowAddUser()
    {
        return view('admin/adduser');
    }

    public function ShowEditUser()
    {

    }

    protected function validator(array $data)
    {
        return Validator::make($data, [
            'email' => 'required|string|email|max:255',
            'password' => 'required|string|min:6|confirmed',
            'role' => 'required'
        ]);
    }

    public function AddUser(Request $request)
    {
        $this->validator($request->all())->validate();

        $role = $request->get('role');

        if($role == 1){
            $roleID = Role::where('RoleName','admin')->value('RoleID');
            $user = User::create([
                'email' => $request->get('email'),
                'RoleID' => $roleID,
                'password' => Hash::make($request->get('password')),
                'codeverify' => 0,
                'active' => 1
            ]);
            
        }else {
            $roleID = Role::where('RoleName','doctor')->value('RoleID');
            $user = User::create([
                'email' => $request->get('email'),
                'RoleID' => $roleID,
                'password' => Hash::make($request->get('password')),
                'codeverify' => 0,
                'active' => 0
            ]);
        }
        return redirect()->route('admin.showadduser')->with(['success' => 'Create user success!!']);    
    }

}
