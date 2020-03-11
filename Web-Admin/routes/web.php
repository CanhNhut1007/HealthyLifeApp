<?php

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/



Route::get('/', function () {
    return view('index');
});



Route::group(['prefix' => 'member','middleware' => 'prevent-back-history'], function () {
    Route::namespace('User')->group(function () {

        Route::get('welcome','SignupController@ShowWelcomeForm')->name('welcome');

        Route::get('signup','SignupController@ShowSignupForm')->name('signup');

        Route::post('signup','SignupController@signup')->name('user.signup');

        Route::get('login','LoginController@ShowLoginHome')->name('login');

        Route::post('login','LoginController@checklogin')->name('user.login');

        Route::get('verify','VerifyController@ShowVerify')->name('verify');

        Route::post('verify', 'VerifyController@activate')->name('user.verify');

        Route::get('information', 'InformationController@index')->name('information');

        Route::post('information', 'InformationController@update')->name('user.information');

        Route::get('/forgotpassword','ForgotPasswordController@ShowResetPasswordForm')->name('forgotpassword');

        Route::post('resetpassword','ForgotPasswordController@resetpassword')->name('user.forgotpassword');

        Route::get('/resetpasswordverify','ForgotPasswordController@Showverifyresetpassword')->name('verifyresetpassword');

        Route::post('verifyresetpassword','ForgotPasswordController@verifycoderesetpassword')->name('user.verifyresetpassword');
        
        Route::get('logout', 'LoginController@logout')->name('user.logout');
        
        Route::group(['middleware' => ['auth']], function () {

            Route::get('home', 'HomeController@index')->name('user.home');

            Route::get('/','HomeController@redirect');
           
            Route::get('account', 'AccountController@index')->name('user.account');

            Route::get('profile', 'ProfileController@index')->name('user.profile');

            Route::get('support', 'SupportController@index')->name('user.support');

            Route::get('setting', 'SettingController@index')->name('user.setting');

            Route::get('notification', 'NotificationController@index')->name('user.notification');

            Route::get('doctorprofile/{userid}', 'DoctorProfileController@index')->name('user.doctorprofile');

            Route::get('search','HomeController@search')->name('user.search');

            Route::get('healthrecorddetail/{healthrecordid}','HealthRecordDetailController@index')->name('user.healthrecorddetail');

            Route::post('setting-email','SettingController@updateemail')->name('user.updateemail');

            Route::post('setting-password','SettingController@updatepassword')->name('user.updatepassword');

            Route::post('profile', 'ProfileController@UpdatePatientProfile')->name('user.updateprofile');

            Route::get('healthrecord', 'HealthRecordController@index')->name('user.healthrecord');
        });
    });
});





