<?php

namespace App\Model;

use Illuminate\Database\Eloquent\Model;

class EmergencyContact extends Model
{
    protected $table = 'emergencycontact';
    protected $primaryKey = 'EmergencyContactID';
    public $timestamps = false;

    protected $fillable = [
        'EmergencyContactName', 'EmergencyPhoneNumber','RelationShip'
    ];
}
