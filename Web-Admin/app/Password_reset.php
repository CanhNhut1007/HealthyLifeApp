<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Password_reset extends Model
{
    public $timestamps = false;
    protected $fillable = [
        'email', 'codeverify'
     ];
 
     /**
      * The attributes that should be hidden for arrays.
      *
      * @var array
      */
     protected $hidden = [
        'codeverify',
     ];
}
