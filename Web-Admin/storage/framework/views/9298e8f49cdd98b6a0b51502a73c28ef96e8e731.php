<?php $__env->startSection('content'); ?>
<div id="main_div">
        <div id="main_home">
            <div class="container">
                <div class="row">
                    <div class="col">
                        <p id="text_username">Patient: <?php echo e($PatientName); ?></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="content_div">
        <div id="content_home">
        <div class="div_search"><small class="form-text text-muted name_table" id="text_name_table">Health Record</small><a class="text-right link_add_edit" href="<?php echo e(route('doctor.addrecord', $patientid)); ?>">Add</a></div>
            <div id="table_last_result">
                <div class="table-responsive">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Date</th>
                                <th>Employee Name</th>
                                <th>Description</th>
                                <th>Result</th>
                                <th>Detail</th>
                            </tr>
                        </thead>
                        <tbody>
                        <?php $__currentLoopData = $healthrecord; $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $record): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                            <tr>
                                <td><?php echo e($record->HealthRecorDateTime); ?></td>
                                <td><?php echo e($record->EmployeeName); ?></td>
                                <td><?php echo e($record->Description); ?></td>
                                <td><?php echo e($record->Result); ?></td>
                                <td><a style="text-decoration:none;" href="<?php echo e(route('doctor.healthrecord',[$record->PatientID, $record->HealthRecordID])); ?>">ViewDetail</a></td>
                            </tr>
                        <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
<?php $__env->stopSection(); ?>
<?php echo $__env->make('doctor.main.layouts.layout_doctor', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?><?php /**PATH C:\xampp\htdocs\learncode\TestLaravel\resources\views/doctor/main/patientrecord.blade.php ENDPATH**/ ?>