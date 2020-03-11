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
  <link href="<?php echo e(url('vendor/fontawesome-free/css/all.min.css')); ?>" rel="stylesheet" type="text/css">

  <!-- Page level plugin CSS-->
  <link href="<?php echo e(url('vendor/datatables/dataTables.bootstrap4.css')); ?>" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="<?php echo e(url('css/admin/sb-admin.css')); ?>" rel="stylesheet">
  <link href="<?php echo e(url('css/admin/colReorder.bootstrap.min.css')); ?>" rel="stylesheet">
  <link href="<?php echo e(url('css/admin/sb-admin.min.css')); ?>" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
  <?php echo $__env->make('admin.layouts.layout_navbar_dashboard', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?>
  <div id="wrapper">
    <?php echo $__env->make('admin.layouts.layout_sidebar_dashboard', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?>
    <?php echo $__env->yieldContent('content'); ?>
  </div>
  <!-- /#wrapper -->

  <?php echo $__env->make('admin.layouts.layout_dashboard_logout', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?>

  <!-- Bootstrap core JavaScript-->
  <script src="<?php echo e(url('vendor/jquery/jquery.min.js')); ?>"></script>

  <script src="<?php echo e(url('vendor/bootstrap/js/bootstrap.bundle.min.js')); ?>"></script>

  <!-- Core plugin JavaScript-->
  <script src="<?php echo e(url('vendor/jquery-easing/jquery.easing.min.js')); ?>"></script>

  <!-- Page level plugin JavaScript-->
  <script src="<?php echo e(url('vendor/chart.js/Chart.min.js')); ?>"></script>
  <script src="<?php echo e(url('vendor/datatables/jquery.dataTables.js')); ?>"></script>
  <script src="<?php echo e(url('vendor/datatables/dataTables.bootstrap4.js')); ?>"></script>

  <!-- Custom scripts for all pages-->
  <script src="<?php echo e(url('js/admin/sb-admin.min.js')); ?>"></script>
  <!-- Demo scripts for this page-->
  <script src="<?php echo e(url('js/admin/demo/datatables-demo.js')); ?>"></script>
  <script src="<?php echo e(url('js/admin/demo/chart-area-demo.js')); ?>"></script>
</body>

</html>
<?php /**PATH E:\xampp\htdocs\TestLaravel\resources\views/admin/layouts/layout_dashboard.blade.php ENDPATH**/ ?>