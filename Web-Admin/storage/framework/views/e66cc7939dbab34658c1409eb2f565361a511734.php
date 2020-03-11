<?php $__env->startSection('content'); ?>
<div class="divbutton">
    <form method="POST" action="<?php echo e(('signup')); ?>">
        <?php echo e(csrf_field()); ?>

        <div class="Input_Info">
            <div class="textinput">
                <div class="label">Email</div>
                <input type="email" name="email" class="<?php echo e($errors->has('email') ? 'form-control is-invalid' : ''); ?>" value="<?php echo e(old('email')); ?>" required autofocus>
                <div>
                    <?php if($errors->has('email')): ?>
                        <span class='text-danger'>
                            <strong><?php echo e($errors->first('email')); ?></strong>
                        </span>
                    <?php endif; ?>
                </div>
            </div>
        </div>
        <div class="Input_Info">
            <div class="textinput">
                <div class="label">Password</div>
                <input type="password" class="inputPW <?php echo e($errors->has('password') ? 'form-control is-invalid' : ''); ?>" name="password" value="" required>
                <div>
                    <?php if($errors->has('password')): ?>
                        <span class='text-danger'>
                            <strong><?php echo e($errors->first('password')); ?></strong>
                        </span>
                    <?php endif; ?>
                </div>
            </div>
        </div>
        <div class="Input_Info">
            <div class="textinput">
                <div class="label">Confirm Password</div>
                <input type="password" class="inputCPW" name="password_confirmation" value="" required>
            </div>
        </div>
        <div class="button"><input class="form-control btn color depth" type="submit" value="Sign up"></div>
    </form>
</div>
<?php $__env->stopSection(); ?>
<?php echo $__env->make('layouts.layout', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?><?php /**PATH C:\xampp\htdocs\Laravel\TestLaravel\resources\views/signup.blade.php ENDPATH**/ ?>