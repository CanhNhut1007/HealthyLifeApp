<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>HealthLife</title>
    <link rel="stylesheet" href="{{URL::asset('bootstrap/css/bootstrap.min.css')}}">
    <link rel="stylesheet" href="{{URL::asset('fonts/font-awesome.min.css')}}">
    <link rel="stylesheet" href="{{URL::asset('css/doctor/main/styles.min.css')}}">
    <link rel="stylesheet" href="{{URL::asset('css/doctor/main/styles.css')}}">
 </head>
 <body>

    @include('doctor.main.layouts.layout_navbar')

    @yield('content')

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="{{URL::asset('js/member/script.js')}}"></script>
    <script src="{{URL::asset('bootstrap/js/bootstrap.min.js')}}"></script>
</body>

</html>