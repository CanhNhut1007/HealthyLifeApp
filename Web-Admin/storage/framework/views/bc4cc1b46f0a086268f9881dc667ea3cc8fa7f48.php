<?php $__env->startSection('content'); ?>
<!-- Page Content -->
<div id="content-wrapper" style="padding:20px;">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Hospital
                    <small>Add</small>
                </h1>
            </div>
            <!-- /.col-lg-12 -->
            <div class="col-lg-7" style="padding-bottom:120px">
            <?php if(session()->has('success')): ?>
            <div class="text-success" role="alert">
                <p><?php echo e(session('success')); ?></p>
            </div>
            <?php elseif(session()->has('error')): ?>
            <div class='text-danger' role="alert">
                <p><?php echo e(session('error')); ?></p>
            </div>
            <?php endif; ?>
                <form action="<?php echo e(route('admin.addhospital')); ?>" method="POST">
                    
                    <div class="form-group">
                        <label>Hospital Name</label>
                        <input type="text" name="hospitalname" class="form-control" value="" required autofocus>
                    </div>
                    <div class="form-group">
                        <label>City</label>
                        <input type="text" class="form-control" name="city" value="" required>
                    </div>
                    <div class="form-group">
                        <label>Country</label>
                        <input type="text"  class="form-control" name="country" value="" required>
                    </div>
                    
                    <input type="submit" value="Add Hospital">
                    <input type="reset" value="Reset">
                <form>
            </div>
        </div>
        <!-- /.row -->
    </div>
    <!-- /.container-fluid -->
</div>
<!-- /#page-wrapper -->
<?php $__env->stopSection(); ?>
<?php echo $__env->make('admin.layouts.layout_dashboard', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?><?php /**PATH C:\xampp\htdocs\learncode\TestLaravel\resources\views/admin/addhospital.blade.php ENDPATH**/ ?>