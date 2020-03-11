<?php

namespace App\Http\Controllers\Admin;

use Illuminate\Routing\Controller;
use App\Model\User;
use App\Model\HealthRecord;
use App\Model\Role;
use App\Charts\UserChart;

class HomeController extends Controller {
    public function index()
    {
        $roleID = Role::where('RoleName','user')->value('RoleID');
        $numbernewuser = User::whereDate('created_at', '=', date("Y-m-d"))->where('active',1)->where('RoleID',$roleID)->count();
        $numbernewhealthrecord = HealthRecord::whereDate('HealthRecorDateTime','=',date("Y-m-d"))->count();
        $summoney = HealthRecord::whereDate('HealthRecorDateTime','=',date("Y-m-d"))->sum('TotalFee');

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
        $usersChart->dataset('Total Fee Health Record', 'line', [$summoneymonth1, $summoneymonth2,$summoneymonth3])
            ->color("rgb(255, 99, 132)")
            ->backgroundcolor("rgb(255, 99, 132)");
        return view('admin/dashboard')->with(['numbernewuser' => $numbernewuser,'numbernewhealthrecord'=> $numbernewhealthrecord,'summoney'=>$summoney,'usersChart' => $usersChart]);;
    }

    public function redirect()
    {
        return redirect('admin/dashboard');
    }
}