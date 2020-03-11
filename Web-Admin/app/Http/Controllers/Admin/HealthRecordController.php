<?php

namespace App\Http\Controllers\Admin;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Charts\UserChart;
use App\Model\HealthRecord;

class HealthRecordController extends Controller
{
    public function ShowListHealthRecord()
    {
        $listhealthrecords = HealthRecord::join('patient', 'patient.PatientID', '=', 'healthrecord.PatientID')->join('employee', 'employee.EmployeeID', '=', 'healthrecord.EmployeeID')->select('patient.PatientName','employee.EmployeeName','healthrecord.HealthRecorDateTime','healthrecord.Result','healthrecord.TotalFee')->get();
        return view('admin/healthrecord')->with(['listhealthrecords' => $listhealthrecords]);
    }

    public function ShowNewHealthRecord(){
        $arraymonth = array (
            array(0,'Jan'),
            array(1,'Feb'),
            array(2,'Mar'),
            array(3,'Apr'),
            array(4,'May'),
            array(5,'Jun'),
            array(6,'July'),
            array(7,'Aug'),
            array(8,'Sep'),
            array(9,'Oct'),
            array(10,'Nov'),
            array(11,'Dec')
        );

        $month =date('m')-3;

        if($month == -2){
            $month1 = 10;
            $month2 = 11;
            $month3 = 0;
        }elseif($month == -1) {
            $month1 = 11;
            $month2 = 0;
            $month3 = 1;
        }
        else {
            $month1 = $arraymonth[$month++][0];
            $month2 =$arraymonth[$month++][0];
            $month3 = $arraymonth[$month][0];
        }

        $newhealthrecordmonth1 = HealthRecord::whereMonth('HealthRecorDateTime', '=', $month1+1)->count();
        $newhealthrecordmonth2 = HealthRecord::whereMonth('HealthRecorDateTime', '=', $month2+1)->count();
        $newhealthrecordmonth3 = HealthRecord::whereMonth('HealthRecorDateTime', '=', $month3+1)->count();

        $usersChart = new UserChart;
        $usersChart->labels([$arraymonth[$month1][1], $arraymonth[$month2][1], $arraymonth[$month3][1]]);
        $usersChart->dataset('New Health Record in 3 month', 'line', [$newhealthrecordmonth1,  $newhealthrecordmonth2, $newhealthrecordmonth3])
            ->color("rgb(255, 99, 132)")
            ->backgroundcolor("rgb(255, 99, 132)");
        return view('admin/newhealthrecord')->with(['usersChart' => $usersChart]);
    }

    public function MoneyGrossRevenue()
    {
        $arraymonth = array (
                array(0,'Jan'),
                array(1,'Feb'),
                array(2,'Mar'),
                array(3,'Apr'),
                array(4,'May'),
                array(5,'Jun'),
                array(6,'July'),
                array(7,'Aug'),
                array(8,'Sep'),
                array(9,'Oct'),
                array(10,'Nov'),
                array(11,'Dec')
        );

        $month =date('m')-3;

        if($month == -2){
            $month1 = 10;
            $month2 = 11;
            $month3 = 0;
        }elseif($month == -1) {
            $month1 = 11;
            $month2 = 0;
            $month3 = 1;
        }
        else {
            $month1 = $arraymonth[$month++][0];
            $month2 =$arraymonth[$month++][0];
            $month3 = $arraymonth[$month][0];
        }

        $summoneymonth1 = HealthRecord::whereMonth('HealthRecorDateTime','=',$month1+1)->sum('TotalFee');
        $summoneymonth2 = HealthRecord::whereMonth('HealthRecorDateTime','=',$month2+1)->sum('TotalFee');
        $summoneymonth3 = HealthRecord::whereMonth('HealthRecorDateTime','=',$month3+1)->sum('TotalFee');

        $usersChart = new UserChart;
        $usersChart->labels([$arraymonth[$month1][1], $arraymonth[$month2][1], $arraymonth[$month3][1]]);
        $usersChart->dataset('Total Fee Health Record in 3 month', 'line', [$summoneymonth1, $summoneymonth2,$summoneymonth3])
            ->color("rgb(255, 99, 132)")
            ->backgroundcolor("rgb(255, 99, 132)");
        return view('admin/moneygrossrevenue')->with(['usersChart' => $usersChart]);;
    }
}
