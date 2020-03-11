<?php

namespace App\Http\Controllers\Admin;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Model\Role;

class RoleController extends Controller
{
    public function ShowListRole()
    {
        $listrole = Role::get();
        $number = 1;
        return view('admin/role')->with(['listrole' => $listrole,'number' => $number]);;
    }
}
