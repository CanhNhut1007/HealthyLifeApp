<?php

namespace App\Model;

use Illuminate\Database\Eloquent\Model;

class Password_resets extends Model
{
     /**
     * The attributes that are mass assignable.
     *
     * @var array
     */
    protected $table = 'password_resets';
    protected $primaryKey = 'PRID';
    public $timestamps = false;

    protected $fillable = [
         'UserID','codeverify'
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