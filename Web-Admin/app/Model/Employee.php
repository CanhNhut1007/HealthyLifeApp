<?php

namespace App\Model;

use App\Model\Hospital;
use Illuminate\Database\Eloquent\Model;

class Employee extends Model
{
    protected $table = 'employee';
    protected $primaryKey = 'EmployeeID';
    public $timestamps = false;

    protected $fillable = [
        'EmployeeID', 'UserID','EmployeeName','Gender','PhoneNumber','DayofBirth','Degree','Speciality','MedicalSchool',
        'YearOfDegree','PersonalImage','HospitalID'
    ];
    
    public function Hospital(){
        return $this->hasOne('App\Model\Hospital','HospitalID');
    }
}
