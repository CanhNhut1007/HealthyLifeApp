<?php

namespace App\Model;

use Illuminate\Database\Eloquent\Model;

class Hospital extends Model
{
    protected $table = 'hospitalaffiliation';
    protected $primaryKey = 'HospitalID';
    public $timestamps = false;

    protected $fillable = [
        'HospitalID', 'HospitalName', 'City','Country','Start_Date','End_Date'
    ];
    
}
