<?php $__env->startSection('content'); ?>
<!-- Page Content -->
<div id="content-wrapper" style="padding:20px;">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">User
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
                <form action="<?php echo e(route('admin.adduser')); ?>" method="POST">
                    
                    <div class="form-group">
                        <label>Email</label>
                        <input type="email" name="email" class="form-control <?php echo e($errors->has('email') ? 'is-invalid' : ''); ?>" value="<?php echo e(old('email')); ?>" required autofocus>
                        <?php if($errors->has('email')): ?>
                        <span class='text-danger'>
                            <p><?php echo e($errors->first('email')); ?></p>
                        </span>
                        <?php endif; ?>
                    </div>
                    <div class="form-group">
                        <label>Password</label>
                        <input type="password" class="form-control <?php echo e($errors->has('password') ? 'is-invalid' : ''); ?>" name="password" value="" required>
                        <?php if($errors->has('password')): ?>
                        <span class='text-danger'>
                            <p><?php echo e($errors->first('password')); ?></p>
                        </span>
                        <?php endif; ?>
                    </div>
                    <div class="form-group">
                        <label>RePassword</label>
                        <input type="password"  class="form-control" name="password_confirmation" value="" required>
                    </div>
                    <div class="form-group">
                        <label>Role: </label>
                        <label class="radio-inline" style="padding:10px;">
                            <input name="role" value="1" checked="" type="radio">admin
                        </label>
                        <label class="radio-inline" style="padding:10px;">
                            <input name="role" value="2" type="radio">doctor
                        </label>
                    </div>
                    <input type="submit" value="AddUser">
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
<?php echo $__env->make('admin.layouts.layout_dashboard', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?><?php /**PATH C:\xampp\htdocs\learncode\TestLaravel\resources\views/admin/adduser.blade.php ENDPATH**/ ?>