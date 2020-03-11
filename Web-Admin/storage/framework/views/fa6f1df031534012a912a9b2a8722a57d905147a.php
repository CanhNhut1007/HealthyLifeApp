<?php $__env->startSection('content'); ?>
<br/>
<div>
    <div class="content_div">
        <div id="content_home"><small class="form-text text-muted name_table" id="text_name_table">Health Record Detail</small>
            <div id="table_last_result">
                <div class="col-4" id="column_name">
                    <p class="text_name">Health Record ID<br /></p>
                    <p class="text_name">Time<br /></p>
                    <p class="text_name">Employee Name<br /></p>
                    <p class="text_name">Description<br /></p>
                    <p class="text_name">Diagnosis<br /></p>
                    <p class="text_name">Result<br /></p>
                    <p class="text_name">Notes<br /></p>
                    <p class="text_name">TotalFee<br /></p>
                </div>
                <div class="col" id="column_detail">
                    <p class="text_detail" style="border:none; width:100%; border-radius:20px; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;"><?php echo e($healthrecord->HealthRecordID); ?></p>
                    <p class="text_detail" style="border:none; width:100%; border-radius:20px; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;"><?php echo e($healthrecord->HealthRecorDateTime); ?></p>
                    <p class="text_detail" style="border:none; width:100%; border-radius:20px; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;"><?php echo e($healthrecord->EmployeeName); ?></p>
                    <p class="text_detail" style="border:none; width:100%; border-radius:20px; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;"><?php echo e($healthrecord->Description); ?></p>
                    <p class="text_detail" style="border:none; width:100%; border-radius:20px; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;"><?php echo e($healthrecord->Diagnosis); ?></p>
                    <p class="text_detail" style="border:none; width:100%; border-radius:20px; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;"><?php echo e($healthrecord->Result); ?></p>
                    <p class="text_detail" style="border:none; width:100%; border-radius:20px; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;"><?php echo e($healthrecord->Notes); ?></p>
                    <p class="text_detail" style="border:none; width:100%; border-radius:20px; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;"><?php echo e($healthrecord->TotalFee); ?></p>
                </div>
            </div>
        </div>
    </div>
</div>
<?php $__env->stopSection(); ?>
<?php echo $__env->make('member.main.layouts.layout_home', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?><?php /**PATH C:\xampp\htdocs\learncode\TestLaravel\resources\views/member/main/healthrecorddetail.blade.php ENDPATH**/ ?>