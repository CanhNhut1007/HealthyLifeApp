<?php $__env->startSection('content'); ?>
<div class="loginDoctorPage">
    <div class="head"><img src="<?php echo e(url('img/health_life.png')); ?>"></div>
    <div class="content">
        <div class="login">
            <h3 class="text-center">Please enter your login doctor info.</h3>
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
                    <form method='POST' action="<?php echo e(route('doctor.login')); ?>">
                    <?php echo e(csrf_field()); ?>

                        <div class="Input_Info">
                            <div class="textinput">
                                <div class="label">Email</div>
                                <input type="email" name="email" value="<?php echo e(old('email')); ?>" />
                            </div>
                            <?php if($errors->has('email')): ?>
                            <span class='text-danger'>
                                <p><?php echo e($errors->first('email')); ?></p>
                            </span>
                            <?php endif; ?>
                        </div>
                        <div class="forgotpassword"><a href="forgotpassword.html">Forgot Password?</a></div>
                        <div class="Input_Info">
                            <div class="textinput"><div class="label">Password</div><input type="password" class="inputPW" name="password" value="" /></div>
                            <div></div>
                            <?php if($errors->has('password')): ?>
                                <span class='text-danger'>
                                    <p><?php echo e($errors->first('password')); ?></p>
                                </span>
                            <?php endif; ?>
                        </div>
                        <div class="button"><input class="form-control btn color depth" type="submit" value="Log in"/></div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<?php $__env->stopSection(); ?>
<?php echo $__env->make('doctor.auth.layouts.layout_login', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?><?php /**PATH E:\xampp\htdocs\TestLaravel\resources\views/doctor/auth/login.blade.php ENDPATH**/ ?>