<?php $__env->startSection('content'); ?>
<div class="text-center content">
    <h4>Verify Reset Password</h4>
    <p>Please enter the code was sent to your email to reset the your password.</p>
    <?php if(session()->has('success')): ?>
        <div class="alert alert-success" role="alert">
            <?php echo e(session('success')); ?>

        </div>
    <?php elseif(session()->has('error')): ?>
        <div class="alert alert-danger" role="alert">
            <?php echo e(session('error')); ?>

        </div>
    <?php endif; ?>
    <div class="Input_Info">
        <div class="textinput">
            <div class="label">Code</div>
            <form method="POST" action="<?php echo e(route('verifyresetpassword')); ?>">
                <?php echo e(csrf_field()); ?>

                <input type="hidden" name="email" value="<?php echo session()->get( 'email' ); ?>" />
                <input type="text" name="codeverify" maxlength="6" value="" required>
                <div class="divbutton">
                    <div class="button">
                        <input class="form-control btn color depth" type="submit" value="Verify"/>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<?php $__env->stopSection(); ?>
<?php echo $__env->make('layouts.layout', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?><?php /**PATH C:\xampp\htdocs\Laravel\TestLaravel\resources\views/showverifyresetpassword.blade.php ENDPATH**/ ?>