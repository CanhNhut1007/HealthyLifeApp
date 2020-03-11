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

Route::post('/login', 'LoginController@Login');

Route::post('/register', 'SignupController@Register');

Route::post('/addprofile/{accountid}', 'SignupController@AddProfile');

Route::post('/update-email/{accountid}', 'SettingController@UpdateEmail');

Route::post('/update-pass/{accountid}', 'SettingController@UpdatePassword');


///////////////////////////////// Doctor
Route::get('/doctor-get-patient', 'HomeController@GetPatient');

Route::post('/doctor-search-patient', 'HomeController@SearchPatient');

Route::get('/doctor-name/{accountid}', 'HomeController@GetDoctorName');

////// Profile
Route::get('/doctor-get-profile/{accountid}', 'ProfileController@GetDoctorProfile');

Route::post('/doctor-profile-update-about/{accountid}', 'ProfileController@UpdateAboutDoctorProfile');

Route::post('/doctor-profile-update-educational/{accountid}', 'ProfileController@UpdateEducationalDoctorProfile');

Route::post('/doctor-profile-update-lisence/{accountid}', 'ProfileController@UpdateLisenceDoctorProfile');

///// PatientRecord
Route::get('/doctor-view-patient/{accountid}', 'PatientController@ViewListPatient');

Route::get('/doctor-get-email/{accountid}', 'SettingController@GetDoctorEmail');

Route::get('/doctor-get-healthrecord-detail/{healthrecordid}', 'HealthRecordController@GetHealthRecordDetail');

Route::post('/doctor-add-healthrecord/{accountemployeeid}/{accountpatientid}', 'AddHealthRecordController@AddHealthRecord');

Route::post('/doctor-edit-healthrecord/{healthrecordid}', 'HealthRecordController@UpdateHealthRecord');

Route::get('/doctor-get-employeeid/{healthrecordid}', 'HealthRecordController@GetEmployeeID');

Route::get('/doctor-view-healthrecord/{accountid}', 'PatientRecordController@DoctorViewRecord');




//////////////////////////////////// Patient
Route::get('/patient-get-doctor', 'HomeController@GetDoctor');

Route::post('/patient-search-doctor', 'HomeController@SearchDoctor');

Route::get('/patient-name/{accountid}', 'HomeController@GetPatientName');

Route::get('/patient-view-healthrecord/{accountid}', 'PatientRecordController@ViewMyRecord');

Route::get('/patient-get-email/{accountid}', 'SettingController@GetPatientEmail');

Route::get('/patient-get-doctorprofile/{accountid}', 'DoctorProfileController@GetDoctorProfile');

//// Profile

Route::get('/patient-profile/{accountid}', 'ProfileController@GetPatientProfile');

Route::get('/patient-emergency/{accountid}', 'ProfileController@GetEmergency');

Route::get('/patient-insurance/{accountid}', 'ProfileController@GetInsurance');

Route::post('/patient-profile-update-about/{accountid}', 'ProfileController@UpdateAboutPatientProfile');

Route::post('/patient-profile-update-contact/{accountid}', 'ProfileController@UpdateContactPatientProfile');

Route::post('/patient-profile-update-emergency/{accountid}', 'ProfileController@UpdateEmergencyPatientProfile');

Route::post('/patient-profile-update-insurance/{accountid}', 'ProfileController@UpdateInsurancePatientProfile');