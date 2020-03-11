<?php $__env->startSection('content'); ?>
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
    <?php echo $usersChart->container(); ?>

  </div>

    <?php if(session()->has('success')): ?>  
    <div class="text-success" role="alert">
        <p><?php echo e(session('success')); ?></p>
    </div>
    <?php elseif(session()->has('error')): ?>
    <div class='text-danger' role="alert">
        <p><?php echo e(session('error')); ?></p>
    </div>
    <?php endif; ?>
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
  <?php echo $usersChart->script(); ?>

</div>
    <!-- /.content-wrapper -->
<?php $__env->stopSection(); ?>
<?php echo $__env->make('admin.layouts.layout_dashboard', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?><?php /**PATH C:\xampp\htdocs\learncode\TestLaravel\resources\views/admin/newhealthrecord.blade.php ENDPATH**/ ?>