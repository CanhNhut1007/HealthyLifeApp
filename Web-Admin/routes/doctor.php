<?php
Route::group(['middleware' => 'prevent-back-history'], function () {
    Route::namespace('Doctor')->group(function () {

        Route::get('/', 'LoginController@showLoginForm');

        Route::get('login', 'LoginController@showLoginForm');

        Route::post('login', 'LoginController@login')->name('doctor.login');

        Route::get('logout', 'LoginController@logout')->name('doctor.logout');

        Route::group(['middleware' => ['auth:doctor']], function () {

            Route::get('home', 'HomeController@index')->name('doctor.home');

            Route::get('/','HomeController@redirect');  

            Route::get('account', 'AccountController@index')->name('doctor.account');

            Route::get('profile', 'ProfileController@index')->name('doctor.profile');

            Route::get('notification', 'NotificationController@index')->name('doctor.notification');

            Route::get('setting', 'SettingController@index')->name('doctor.setting');

            Route::get('support', 'SupportController@index')->name('doctor.support');

            Route::get('patients', 'PatientController@index')->name('doctor.patient');

            //Route::get('patients/{PatientID}', 'PatientController@PatientRecord')->name('doctor.recordpatientdetail');
            
            //Route::get('recorddetail', 'HomeController@RecordDetail')->name('doctor.recorddetail'); doctor.healthrecord

            ////////
            Route::get('search', 'HomeController@search')->name('doctor.searchpatient');

            Route::get('patientrecord/{patientid}', 'PatientRecordController@index')->name('doctor.patientrecord');

            Route::get('healthrecord/{patientid}/{healthrecordid}', 'HealthRecordController@index')->name('doctor.healthrecord');

            Route::post('healthrecord/{patientid}/{healthrecordid}', 'HealthRecordController@update')->name('doctor.healthrecordedit');

            Route::get('addrecord/{patientid}', 'AddHealthRecordController@index')->name('doctor.addrecord');

            Route::post('record/{patientid}', 'AddHealthRecordController@add')->name('doctor.record');

            //Route::get('addhealthrecord/{$patientid}', 'AddHealthRecordController@index')->name('doctor.addhealthrecord');

            
            //Route::post('/doctor-patientrecord/{accountid}/{accountpatientid}', 'GetDataDoctorController@SaveHealthRecord')->name('doctor-patientrecord1');
            
            Route::post('profile/update', 'ProfileController@UpdateProfile')->name('doctor.updateprofile');

            Route::post('setting-email','SettingController@updateemail')->name('user.updateemail');

            Route::post('setting-password','SettingController@updatepassword')->name('user.updatepassword');

            
            //Route::post('/doctor-setting/{accountid}', 'GetDataDoctorController@DoctorSetting')->name('update-email');
            
            //Route::get('/doctor-mypatient/{accountid}', 'GetDataDoctorController@ViewListPatient')->name('doctor.patientrecord');
            
            
        });
    });
});