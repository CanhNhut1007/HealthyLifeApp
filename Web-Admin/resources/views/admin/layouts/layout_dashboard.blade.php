<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>HealthLife Admin - Dashboard</title>

  <!-- Custom fonts for this template-->
  <link href="{{url('vendor/fontawesome-free/css/all.min.css')}}" rel="stylesheet" type="text/css">

  <!-- Page level plugin CSS-->
  <link href="{{url('vendor/datatables/dataTables.bootstrap4.css')}}" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="{{url('css/admin/sb-admin.css')}}" rel="stylesheet">
  <link href="{{url('css/admin/colReorder.bootstrap.min.css')}}" rel="stylesheet">
  <link href="{{url('css/admin/sb-admin.min.css')}}" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
  @include('admin.layouts.layout_navbar_dashboard')
  <div id="wrapper">
    @include('admin.layouts.layout_sidebar_dashboard')
    @yield('content')
  </div>
  <!-- /#wrapper -->

  @include('admin.layouts.layout_dashboard_logout')

  <!-- Bootstrap core JavaScript-->
  <script src="{{url('vendor/jquery/jquery.min.js')}}"></script>

  <script src="{{url('vendor/bootstrap/js/bootstrap.bundle.min.js')}}"></script>

  <!-- Core plugin JavaScript-->
  <script src="{{url('vendor/jquery-easing/jquery.easing.min.js')}}"></script>

  <!-- Page level plugin JavaScript-->
  <script src="{{url('vendor/chart.js/Chart.min.js')}}"></script>
  <script src="{{url('vendor/datatables/jquery.dataTables.js')}}"></script>
  <script src="{{url('vendor/datatables/dataTables.bootstrap4.js')}}"></script>

  <!-- Custom scripts for all pages-->
  <script src="{{url('js/admin/sb-admin.min.js')}}"></script>
  <!-- Demo scripts for this page-->
  <script src="{{url('js/admin/demo/datatables-demo.js')}}"></script>
  <script src="{{url('js/admin/demo/chart-area-demo.js')}}"></script>
</body>

</html>
