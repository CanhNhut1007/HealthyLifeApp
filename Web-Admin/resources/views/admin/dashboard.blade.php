@extends('admin.layouts.layout_dashboard')
@section('content')
<div id="content-wrapper">

  <div class="container-fluid">

    <!-- Breadcrumbs-->
    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="#">Dashboard</a>
      </li>
      <li class="breadcrumb-item active">Overview</li>
    </ol>
    <!-- Icon Cards-->
    <div class="row">
      <div class="col-xl-3 col-sm-6 mb-3">
        <div class="card text-white bg-warning o-hidden h-100">
          <div class="card-body">
            <div class="card-body-icon">
              <i class="fa fa-user-circle"></i>
            </div>
            <div class="mr-5" id="id_number_new_user"><?php echo $numbernewuser ?> new user today!</div>
          </div>
          <a class="card-footer text-white clearfix small z-1" href="{{route('admin.shownewuser')}}">
            <span class="float-left">View More</span>
            <span class="float-right">
              <i class="fas fa-angle-right"></i>
            </span>
          </a>
        </div>
      </div>
      <div class="col-xl-3 col-sm-6 mb-3">
        <div class="card text-white bg-success o-hidden h-100">
          <div class="card-body">
            <div class="card-body-icon">
              <i class="fa fa-plus-square"></i>
            </div>
            <div class="mr-5" id="id_number_medical_examinations"><?php echo $numbernewhealthrecord ?> new healthrecord today!</div>
          </div>
          <a class="card-footer text-white clearfix small z-1" href="{{route('admin.shownewhealthrecord')}}">
            <span class="float-left">View More</span>
            <span class="float-right">
              <i class="fas fa-angle-right"></i>
            </span>
          </a>
        </div>
      </div>
      <div class="col-xl-3 col-sm-6 mb-3">
        <div class="card text-white bg-danger o-hidden h-100">
          <div class="card-body">
            <div class="card-body-icon">
              <i class="fa fa-university"></i>
            </div>
            <div class="mr-5" id="id_money_Gross_revenue"><?php echo "$". $summoney ?> today!</div>
          </div>
          <a class="card-footer text-white clearfix small z-1" href="{{route('admin.showmoneygrossrevenue')}}">
            <span class="float-left">View More</span>
            <span class="float-right">
              <i class="fas fa-angle-right"></i>
            </span>
          </a>
        </div>
      </div>
    </div>

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