<?php $__env->startSection('content'); ?>
<div class="loginAdminPage">
    <div class="head"><img src="<?php echo e(url('img/health_life.png')); ?>"></div>
    <div class="content">
        <div class="contentheader"><div>Admin login</div></div>
        <div class="login">
            <div class="divform">
                <div class="divbutton">
                    <?php if(session()->has('success')): ?>
                    <div class="text-success" role="alert">
                        <p><?php echo e(session('success')); ?></p>
                    </div>
                    <?php elseif(session()->has('error')): ?>
                    <div class='text-danger' role="alert">
                        <p><?php echo e(session('error')); ?></p>
                    </div>
                    <?php endif; ?>
                    <form method="POST" action="<?php echo e(route('admin.login')); ?>">
                    <?php echo e(csrf_field()); ?>

                        <div class="Input_Info">
                            <div class="textinput"><div class="label">Email</div><input type="email" name="email" value="" /></div>
                            <div></div>
                        </div>
                        <div class="forgotpassword"><a href="forgotpassword.html">Forgot Password?</a></div>
                        <div class="Input_Info">
                            <div class="textinput"><div class="label">Password</div><input type="password" class="inputPW" name="password" value="" /></div>
                            <div></div>
                        </div>
                        <div class="button"><input class="form-control btn color depth" type="submit" value="Log in"/></div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<?php $__env->stopSection(); ?>
<?php echo $__env->make('admin.layouts.layout_login', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?><?php /**PATH C:\xampp\htdocs\learncode\TestLaravel\resources\views/admin/auth/login.blade.php ENDPATH**/ ?>