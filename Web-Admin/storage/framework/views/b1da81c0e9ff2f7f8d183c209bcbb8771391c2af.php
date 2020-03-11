<?php $__env->startSection('content'); ?>

<div class="container box" >
    <div class="panel panel-default">
        <div class="table-responsive">
            <h3><span id="total_records"></span></h3>
            <p class="form-text text-muted name_table" id="text_name_table">My Patient</p>
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
<?php $__env->stopSection(); ?>
<?php echo $__env->make('doctor.main.layouts.layout_doctor', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?><?php /**PATH C:\xampp\htdocs\learncode\TestLaravel\resources\views/doctor/main/patients.blade.php ENDPATH**/ ?>