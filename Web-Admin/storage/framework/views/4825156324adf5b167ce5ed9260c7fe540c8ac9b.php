<?php $__env->startSection('content'); ?>
<div class="container box" >
    <div class="panel panel-default">
        <div class="panel-heading"></div>
            <div class="panel-body">
                <div class="form-group">
                    <div id="main_div">
                        <div id="main_home">
                            <div class="container">
                                <div class="row">
                                    <div class="col"><small class="form-text text-muted" id="text_username">Hi <?php echo e($EmployeeName); ?> </small>
                                        <form action="<?php echo e(route('doctor.searchpatient')); ?>" method="GET" role="search">
                                        
                                        <div class="input-group">
                                            <input type="text" class="form-control" name="q" placeholder="Search users"> 
                                            <span class="input-group-btn">
                                                <button type="submit" class="btn btn-default">
                                                    <span class="glyphicon glyphicon-search"></span>
                                                </button>
                                            </span>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="table-responsive">
                <h3><span id="total_records"></span></h3>
                <p class="form-text text-muted name_table" id="text_name_table">Search Result: <?php echo e($mess); ?></p>
                <table class="table table-striped table-bordered">
                    <thead>
                        <tr>
                            <th>Patient ID</th>
                            <th>Patient Name</th>
                            <th>Identify Card</th>
                            <th>Heath Record</th>  
                        </tr>
                    </thead>
                    <tbody id="tbody">
                        <?php $__currentLoopData = $patients; $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $patient): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                            <tr>
                                <td><?php echo e($patient->PatientID); ?></td>
                                <td><?php echo e($patient->PatientName); ?></td>
                                <td><?php echo e($patient->IdentifyCard); ?></td>
                                <td><a class="nav-link active" href="<?php echo e(route('doctor.patientrecord',  $patient->PatientID)); ?>">ViewHealthRecord</a></td>
                            </tr>
                        <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
                        </tbody>   
                </table>
            </div>
        </div>    
    </div>
</div>
<?php $__env->stopSection(); ?>
<?php echo $__env->make('doctor.main.layouts.layout_doctor', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?><?php /**PATH C:\xampp\htdocs\learncode\TestLaravel\resources\views/doctor/main/home.blade.php ENDPATH**/ ?>