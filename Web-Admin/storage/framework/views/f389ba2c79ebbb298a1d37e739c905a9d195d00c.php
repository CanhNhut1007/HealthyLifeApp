<!-- Sidebar -->
<ul class="sidebar navbar-nav">
    <li class="nav-item active">
        <a class="nav-link" href="<?php echo e(('dashboard')); ?>">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>Dashboard</span>
        </a>
    </li>
    <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>Charts</span>
        </a>
        <div class="dropdown-menu" aria-labelledby="pagesDropdown">
            <!-- <h6 class="dropdown-header">Login Screens:</h6> -->
            <a class="dropdown-item" href="<?php echo e(route('admin.shownewuser')); ?>">New Users</a>
            <a class="dropdown-item" href="<?php echo e(route('admin.shownewhealthrecord')); ?>">New HealthRecord</a>
            <a class="dropdown-item" href="<?php echo e(route('admin.showmoneygrossrevenue')); ?>">Gross Revenue</a>
        </div>
    </li>
    <!-- <li class="nav-item">
        <a class="nav-link" href="charts.html">
            <i class="fas fa-fw fa-chart-area"></i>
            <span>Charts</span>
        </a>
    </li> -->
    
    <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fa fa-user-md"></i>
          <span>Doctor</span>
        </a>
        <div class="dropdown-menu" aria-labelledby="pagesDropdown">
            <!-- <h6 class="dropdown-header">Login Screens:</h6> -->
            <a class="dropdown-item" href="<?php echo e(route('admin.showlistdoctor')); ?>">List Doctor</a>
            <a class="dropdown-item" href="<?php echo e(route('admin.showadddoctor')); ?>">Add Doctor</a>
        </div>
    </li>
    <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fa fa-wheelchair"></i>
          <span>Patient</span>
        </a>
        <div class="dropdown-menu" aria-labelledby="pagesDropdown">
            <a class="dropdown-item" href="<?php echo e(route('admin.showlistpatient')); ?>">List Patient</a>
        </div>
    </li>
    <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fa fa-users fa-fw"></i>
          <span>User</span>
        </a>
        <div class="dropdown-menu" aria-labelledby="pagesDropdown">
            <!-- <h6 class="dropdown-header">Login Screens:</h6> -->
            <a class="dropdown-item" href="<?php echo e(route('admin.showlistuser')); ?>">List User</a>
            <a class="dropdown-item" href="<?php echo e(route('admin.showadduser')); ?>">Add User</a>
        </div>
    </li>
    <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fa fa-book"></i>
          <span>Role</span>
        </a>
        <div class="dropdown-menu" aria-labelledby="pagesDropdown">
            <a class="dropdown-item" href="<?php echo e(route('admin.showlistrole')); ?>">List Role</a>
            <a class="dropdown-item" href="#">Add Role</a>
        </div>
    </li>
    <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fa fa-medkit"></i>
          <span>Health Record</span>
        </a>
        <div class="dropdown-menu" aria-labelledby="pagesDropdown">
            <a class="dropdown-item" href="<?php echo e(route('admin.showlisthealthrecord')); ?>">List HealthRecord</a>
        </div>
    </li>

    <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fas fa-hospital" aria-hidden="true"></i>
          <span>Hospital</span>
        </a>
        <div class="dropdown-menu" aria-labelledby="pagesDropdown">
            <a class="dropdown-item" href="<?php echo e(route('admin.showlisthospital')); ?>">List Hospital</a>
            <a class="dropdown-item" href="<?php echo e(route('admin.showaddhospital')); ?>">Add Hospital</a>
        </div>
    </li>
</ul><?php /**PATH C:\xampp\htdocs\learncode\TestLaravel\resources\views/admin/layouts/layout_sidebar_dashboard.blade.php ENDPATH**/ ?>