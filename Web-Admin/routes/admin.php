<?php

// Route::group(['prefix' => 'admin','middleware' => 'prevent-back-history'], function () {
//     Route::namespace('Admin')->group(function () {
//         Route::get('/', 'LoginController@showLoginForm');
//         Route::get('login', 'LoginController@showLoginForm');
//         Route::post('login', 'LoginController@login')->name('admin.login');
//         Route::post('logout', 'LoginController@logout')->name('admin.logout');
//         Route::group(['middleware' => ['auth:admin']], function () {
//             Route::get('home', 'HomeController@index')->name('admin.home');
//             Route::get('/','HomeController@redirect');
//         });
//     });
// });
Route::group(['middleware' => 'prevent-back-history'], function () {
    Route::namespace('Admin')->group(function () {
        Route::get('/', 'LoginController@showLoginForm');
        Route::get('login', 'LoginController@showLoginForm');
        Route::post('login', 'LoginController@login')->name('admin.login');
        Route::post('logout', 'LoginController@logout')->name('admin.logout');
        Route::group(['middleware' => ['auth:admin']], function () {
            Route::get('dashboard', 'HomeController@index')->name('admin.dashboard');
            Route::get('/','HomeController@redirect');

            Route::get('newuser','UserController@ShowNewUser')->name('admin.shownewuser');
            Route::get('newhealthrecord','HealthRecordController@ShowNewHealthRecord')->name('admin.shownewhealthrecord');
            Route::get('moneygrossrevenue','HealthRecordController@MoneyGrossRevenue')->name('admin.showmoneygrossrevenue');


            Route::get('doctors','DoctorController@ShowListDoctor')->name('admin.showlistdoctor');
            Route::get('users','UserController@ShowListUser')->name('admin.showlistuser');
            Route::get('healthrecords','HealthRecordController@ShowListHealthRecord')->name('admin.showlisthealthrecord');
            Route::get('patients','PatientController@ShowListPatient')->name('admin.showlistpatient');
            Route::get('roles','RoleController@ShowListRole')->name('admin.showlistrole');
            Route::get('hospitals','HospitalController@ShowListHospital')->name('admin.showlisthospital');


            Route::get('adddoctor','DoctorController@ShowAddDoctor')->name('admin.showadddoctor');
            Route::get('addpatient','PatientController@ShowAddPatient')->name('admin.showaddpatient');
            Route::get('adduser','UserController@ShowAddUser')->name('admin.showadduser');
            Route::get('addrole','RoleController@ShowAddRole')->name('admin.showaddrole');
            Route::get('addhospital','HospitalController@ShowAddHospital')->name('admin.showaddhospital');

            Route::post('adddoctor','DoctorController@AddDoctor')->name('admin.adddoctor');
            Route::post('addpatient','PatientController@AddPatient')->name('admin.addpatient');
            Route::post('adduser','UserController@AddUser')->name('admin.adduser');
            Route::post('addrole','RoleController@AddRole')->name('admin.addrole');
            Route::post('addhospital','HospitalController@AddHospital')->name('admin.addhospital');

            Route::get('editdoctor','DoctorController@ShowEditDoctor')->name('admin.showeditdoctor');
            Route::get('editpatient','PatientController@ShowEditPatient')->name('admin.showeditpatient');
            Route::get('edituser','UserController@ShowEditUser')->name('admin.showedituser');
            Route::get('editrole','RoleController@ShowEditRole')->name('admin.showeditrole');

            Route::post('editdoctor','DoctorController@EditDoctor')->name('admin.editdoctor');
            Route::post('edituser','UserController@EditUser')->name('admin.edituser');
            Route::post('editpatient','UserController@EditPatient')->name('admin.editpatient');
            Route::post('editrole','RoleController@EditRole')->name('admin.editrole');
        });
    });
});
