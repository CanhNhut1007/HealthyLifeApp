<?php

namespace App\Model;

use Illuminate\Database\Eloquent\Model;

class EmergencyContactModel extends Model
{
    protected $table = 'emergencycontact';
    protected $primaryKey = 'EmergencyContactID';
    public $timestamps = false;

    protected $fillable = [
        'EmergencyContactName', 'EmergencyPhoneNumber','RelationShip'
    ];
}
