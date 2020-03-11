<?php $__env->startSection('content'); ?>

<div class="divbutton">
    <h4>Forgot your password?</h4>
    <p>No worries! Let us know your email and we'll send you a code to reset it.</p>
    <form method="POST" action="<?php echo e(('resetpassword')); ?>">
        <?php echo e(csrf_field()); ?>

	    <div class="Input_Info">
			<div class="textinput">
                <div class="label">Email</div>
                <input type="email" name="email" value="" required>
            </div>
		</div>
        <div class="button"><input class="form-control btn color depth" type="submit" value="Send"/></div>
    </form>
</div>
<?php $__env->stopSection(); ?>
<?php echo $__env->make('layouts.layout', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?><?php /**PATH C:\xampp\htdocs\Laravel\TestLaravel\resources\views/forgotpassword.blade.php ENDPATH**/ ?>