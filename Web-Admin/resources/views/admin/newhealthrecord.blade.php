@extends('admin.layouts.layout_dashboard')
@section('content')
<div id="content-wrapper">

  <div class="container-fluid">

    <!-- Breadcrumbs-->
    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="#">Dashboard</a>
      </li>
      <li class="breadcrumb-item active">New Health Record</li>
    </ol>
    <!-- Area Chart Example-->
    <div style="width: 100%">
    {!! $usersChart->container() !!}
  </div>

    @if(session()->has('success'))  
    <div class="text-success" role="alert">
        <p>{{ session('success') }}</p>
    </div>
    @elseif(session()->has('error'))
    <div class='text-danger' role="alert">
        <p>{{ session('error') }}</p>
    </div>
    @endif
  </div>

  <!-- Sticky Footer -->
  <footer class="sticky-footer">
    <div class="container my-auto">
      <div class="copyright text-center my-auto">
        <span>Copyright © Healthtech 2019</span>
      </div>
    </div>
  </footer>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.min.js" charset="utf-8"></script>
  {!! $usersChart->script() !!}
</div>
    <!-- /.content-wrapper -->
@endsection