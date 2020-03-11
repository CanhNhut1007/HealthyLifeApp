<?php $__env->startSection('content'); ?>
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
    <form method="POST" action="<?php echo e(route('user.login')); ?>">
        <?php echo e(csrf_field()); ?>

        <div class="Input_Info">
            <div class="textinput">
                <div class="label">Email</div>
                    <input type="email" name="email" value="<?php echo e(old('email')); ?>">
                <div>
                    <?php if($errors->has('email')): ?>
                        <span class='text-danger'>
                            <p><?php echo e($errors->first('email')); ?></p>
                        </span>
                    <?php endif; ?>
                </div>   
            </div>          
        </div>
        <div class="forgotpassword"><a href="<?php echo e(route('forgotpassword')); ?>">Forgot Password?</a></div>
            <div class="Input_Info">
                <div class="textinput">
                    <div class="label">Password</div>
                    <input type="password" class="inputPW" name="password" value="">
                <div>
                    <?php if($errors->has('password')): ?>
                        <span class='text-danger'>
                            <p><?php echo e($errors->first('password')); ?></p>
                        </span>
                    <?php endif; ?>
                </div>
            </div>
        </div>
        <div class="button"><input class="form-control btn color depth" type="submit" value="Log in"/></div>
        <div class="orsignup">or <a href="<?php echo e(route('signup')); ?>">Sign up</a></div>
    </form>
</div>
<?php $__env->stopSection(); ?>
<?php echo $__env->make('member.auth.layouts.layout', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?><?php /**PATH C:\xampp\htdocs\learncode\TestLaravel\resources\views/member/auth/login.blade.php ENDPATH**/ ?>