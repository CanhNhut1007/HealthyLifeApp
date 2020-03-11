@extends('admin.layouts.layout_dashboard')
@section('content')
<div id="content-wrapper">

    <div class="container-fluid">

        <!-- Breadcrumbs-->
        <ol class="breadcrumb">
          <li class="breadcrumb-item">
            <a href="#">Dashboard</a>
          </li>
          <li class="breadcrumb-item active">Doctor</li>
        </ol>

        <!-- DataTables Example -->
        <div class="card mb-3">
          <div class="card-header">
            <i class="fas fa-table"></i>
            Table Doctor</div>
          <div class="card-body">
            <div class="table-responsive">
              <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                  <tr>
                    <th>Name</th>
                    <td>Email</td>
                    <th>Speciality</th>
                    <th>Hospital Name</th>
                  </tr>
                </thead>
                <tbody>
                  @foreach ($listdoctors as $doctor)
                    <tr>
                        <td>{{$doctor->EmployeeName}}</td>
                        <td>{{$doctor->email}}</td>
                        <td>{{$doctor->Speciality}}</td>
                        <td>{{$doctor->HospitalName}}</td>                             
                    </tr>
                  @endforeach
                </tbody>
                
              </table>
            </div>
          </div>
        </div>

    </div>
</div>
<script>
$(document).ready(function() {
    $('#dataTables-example').DataTable({
            responsive: true
    });
});
</script>
@stop