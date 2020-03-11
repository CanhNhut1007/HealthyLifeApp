<?php

namespace App\Model;
use Illuminate\Notifications\Notifiable;
use Illuminate\Foundation\Auth\User as Authenticatable;

class Doctor extends Authenticatable
{
    use Notifiable;
    const ACTIVE = 1;
    const INACTIVE = 0;

    protected $table = 'users';
    protected $primaryKey = 'UserID';
    public $timestamps = false;

    protected $guard = 'doctor';

    protected $fillable = [
        'email', 'RoleID','password','codeverify','active',
    ];

    protected $hidden = [
        'password', 'codeverify',
    ];
}
