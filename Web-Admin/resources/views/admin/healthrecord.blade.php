@extends('admin.layouts.layout_dashboard')
@section('content')
<div id="content-wrapper">

    <div class="container-fluid">

        <!-- Breadcrumbs-->
        <ol class="breadcrumb">
          <li class="breadcrumb-item">
            <a href="#">Dashboard</a>
          </li>
          <li class="breadcrumb-item active">Health Record</li>
        </ol>

        <!-- DataTables Example -->
        <div class="card mb-3">
          <div class="card-header">
            <i class="fas fa-table"></i>
            Table HealthRecord</div>
          <div class="card-body">
            <div class="table-responsive">
              <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                  <tr>
                    <th>Date</th>
                    <th>Patient Name</th>
                    <th>Doctor Name</th>
                    <th>Result</th>
                    <th>Total Fee</th>
                  </tr>
                </thead>
                <tbody>
                  @foreach ($listhealthrecords as $healthrecord)
                    <tr>
                        <td>{{$healthrecord->HealthRecorDateTime}} </td>
                        <td>{{$healthrecord->PatientName}}</td>
                        <td>{{$healthrecord->EmployeeName}}</td>
                        <td>{{$healthrecord->Result}}</td>
                        <td>{{$healthrecord->TotalFee}}</td>                             
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