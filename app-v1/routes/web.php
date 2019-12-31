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
    return view('welcome');
});

Route::get('/getdata', 'GetDataDoctorController@GetAccount');

Route::post('/register', 'GetDataDoctorController@Register');
Route::any('/whyerror', 'GetDataDoctorController@WhyError');

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

Route::post('/doctor-profile-update-about/{accountid}', 'GetDataDoctorController@UpdateAboutDoctorProfile');

Route::post('/doctor-profile-update-educational/{accountid}', 'GetDataDoctorController@UpdateEducationalDoctorProfile');

Route::post('/doctor-profile-update-lisence/{accountid}', 'GetDataDoctorController@UpdateLisenceDoctorProfile');


Route::get('/doctor-get-patient', 'GetDataDoctorController@GetPatient');

Route::post('/doctor-search-patient', 'GetDataDoctorController@SearchPatient');

Route::get('/doctor-name/{accountid}', 'GetDataDoctorController@GetDoctorName');

Route::get('/doctor-view-patient/{accountid}', 'GetDataDoctorController@ViewListPatient');

Route::get('/doctor-get-email/{accountid}', 'GetDataDoctorController@GetDoctorEmail');

Route::get('/doctor-get-healthrecord-detail/{healthrecordid}', 'GetDataDoctorController@GetHealthRecordDetail');

Route::get('/doctor-get-profile/{accountid}', 'GetDataDoctorController@GetProfile');

Route::post('/doctor-add-healthrecord/{accountemployeeid}/{accountpatientid}', 'GetDataDoctorController@AddHealthRecord');

Route::post('/doctor-edit-healthrecord/{healthrecordid}', 'GetDataDoctorController@UpdateHealthRecord');

Route::get('/doctor-get-employeeid/{healthrecordid}', 'GetDataDoctorController@GetEmployeeID');

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

Route::get('/patient-get-doctor', 'GetDataPatientController@GetDoctor');

Route::post('/patient-search-doctor', 'GetDataPatientController@SearchDoctor');

Route::get('/patient-name/{accountid}', 'GetDataPatientController@GetPatientName');

Route::get('/patient-view-healthrecord/{accountid}', 'GetDataPatientController@ViewMyRecord');

Route::get('/patient-get-email/{accountid}', 'GetDataPatientController@GetPatientEmail');

Route::get('/patient-get-doctorprofile/{accountid}', 'GetDataPatientController@GetDoctorProfile');

Route::get('/patient-profile/{accountid}', 'GetDataPatientController@GetProfile');

Route::get('/patient-emergency/{accountid}', 'GetDataPatientController@GetEmergency');

Route::get('/patient-insurance/{accountid}', 'GetDataPatientController@GetInsurance');

Route::post('/patient-profile-update-about/{accountid}', 'GetDataPatientController@UpdateAboutPatientProfile');

Route::post('/patient-profile-update-contact/{accountid}', 'GetDataPatientController@UpdateContactPatientProfile');

Route::post('/patient-profile-update-emergency/{accountid}', 'GetDataPatientController@UpdateEmergencyPatientProfile');

Route::post('/patient-profile-update-insurance/{accountid}', 'GetDataPatientController@UpdateInsurancePatientProfile');
