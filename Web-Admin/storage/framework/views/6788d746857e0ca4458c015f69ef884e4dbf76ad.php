<?php $__env->startSection('content'); ?>

<div class="divcarousel">
    <div data-ride="carousel" class="carousel slide text-center" id="carousel-1">
        <div role="listbox" class="carousel-inner">
            <div class="carousel-item active">
			    <h4>Conveniently</h4>
			    <p>Can access from anywhere</p>
		    </div>
        <div class="carousel-item">
			<h4>Easily</h4>
			<p>Simple interface, easy to manipulation</p>
		</div>
        <div class="carousel-item">
			<h4>Help</h4>
		</div>
    </div>
    <div>
        <a href="#carousel-1" role="button" data-slide="prev" class="carousel-control-prev">
            <span aria-hidden="true" class="carousel-control-prev-icon sr-only"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a href="#carousel-1" role="button" data-slide="next" class="carousel-control-next sr-only">
            <span aria-hidden="true" class="carousel-control-next-icon"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
    <ul class="carousel-indicators">
        <li data-target="#carousel-1" data-slide-to="0" class="active"></li>
        <li data-target="#carousel-1" data-slide-to="1"></li>
        <li data-target="#carousel-1" data-slide-to="2"></li>
    </ul>
    <div class="divbutton">
        <div class="button">
            <a id="btnlogin" class="btn color depth" href="<?php echo e(('login')); ?>'">Log in</a>
            <a id="signup" class="btn color depth" href="<?php echo e(route('signup')); ?>">Sign up</a>
        </div>
    </div>
    <div class="orsignup">Already member? <a href="<?php echo e(route('login')); ?>">Log in</a></div>
</div>
<?php $__env->stopSection(); ?>
<?php echo $__env->make('member.layouts.layout', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?><?php /**PATH C:\xampp\htdocs\learncode\TestLaravel\resources\views/member/welcome.blade.php ENDPATH**/ ?>