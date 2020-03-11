<?php

namespace App\Model;

use Illuminate\Database\Eloquent\Model;
use App\Model\Employee;

class HealthRecord extends Model
{
    protected $table = 'healthrecord';
    protected $primaryKey = 'HealthRecordID';
    public $timestamps = false;

    protected $fillable = [
        'PatientID', 'EmployeeID','HealthRecorDateTime','Diagnosis','Result','Notes','TotalFee'
    ];
    public function Employee(){
        return $this->hasOne('App\Model\Employee','EmployeeID');
    }
}
