<?php

namespace App\Model;

use Illuminate\Database\Eloquent\Model;
use App\Model\HealthInsurance;
use App\Model\EmergencyContact;

class Patient extends Model
{
    protected $table = 'patient';
    protected $primaryKey = 'PatientID';
    public $timestamps = false;

    protected $fillable = [
        'PatientName', 'IdentifyCard','DayofBirth','PhoneNumber','Gender','Address',
        'District','City','Country','PersonalImage','HealthInsuranceID','EmergencyContactID'
    ];

}
