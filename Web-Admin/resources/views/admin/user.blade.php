@extends('admin.layouts.layout_dashboard')
@section('content')
<div id="content-wrapper">

    <div class="container-fluid">

        <!-- Breadcrumbs-->
        <ol class="breadcrumb">
          <li class="breadcrumb-item">
            <a href="#">Dashboard</a>
          </li>
          <li class="breadcrumb-item active">User</li>
        </ol>

        <!-- DataTables Example -->
        <div class="card mb-3">
          <div class="card-header">
            <i class="fas fa-table"></i>
            Table User</div>
          <div class="card-body">
            <div class="table-responsive">
              <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                  <tr>
                    <th>Email</th>
                    <th>Role</th>
                    <th>Active</th>
                  </tr>
                </thead>
                <tbody>
                  @foreach ($listusers as $user)
                    <tr>
                        <td>{{$user->email}}</td>
                        <td>{{$user->RoleName}}</td> 
                        <td>{{$user->active}}</td>                             
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