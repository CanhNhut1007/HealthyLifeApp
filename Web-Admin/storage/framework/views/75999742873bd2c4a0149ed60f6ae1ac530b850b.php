<?php $__env->startSection('content'); ?>
<div class="content_div">
    <div id="content_home">
        <div class="div_search"><small class="form-text text-muted name_table" id="text_name_table">Health Record</small></div>
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
                            <td><a class="nav-link active" href="<?php echo e(route('user.healthrecorddetail', $record->HealthRecordID)); ?>">ViewDetail</a></td>                               
                        </tr>
                        <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<?php $__env->stopSection(); ?>
<?php echo $__env->make('member.main.layouts.layout_home', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?><?php /**PATH C:\xampp\htdocs\learncode\TestLaravel\resources\views/member/main/myhealthrecord.blade.php ENDPATH**/ ?>