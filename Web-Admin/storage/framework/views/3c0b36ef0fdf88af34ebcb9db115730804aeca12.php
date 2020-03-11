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
        <div id="content_home"><small class="form-text text-muted name_table" id="text_name_table">Health Record Detail</small>
            <?php if($errors->any()): ?>
                <div class="alert alert-danger" text-align="right" style="margin-left:5%; margin-right:5%;">
                <?php $__currentLoopData = $errors->all(); $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $err): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                    <li><?php echo e($err); ?></li>
                <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
                    </div>
            <?php endif; ?>
            <form action="<?php echo e(route('doctor.healthrecordedit', [$patientid, $healthrecordid])); ?>" method="POST">
                <?php echo csrf_field(); ?>
                <div id="table_last_result">
                    <div class="col-4" id="column_name">
                        <p class="text_name">Health Record ID<br /></p>
                        <p class="text_name">Date<br /></p>
                        <p class="text_name">Employee Name<br /></p>
                        <p class="text_name">Description<br /></p>
                        <p class="text_name">Diagnosis<br /></p>
                        <p class="text_name">Result<br /></p>
                        <p class="text_name">Notes<br /></p>
                        <p class="text_name">Patient View<br /></p>
                        <p class="text_name">TotalFee<br /></p>
                    </div>
                    <div class="col" id="column_detail">
                        <p style="border:none; width:100%; border-radius:20px; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;"><?php echo e($healthrecord->HealthRecordID); ?></p>
                        <p style="border:none; width:100%; border-radius:20px; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;"><?php echo e($healthrecord->HealthRecorDateTime); ?></p>
                        <p style="border:none; width:100%; border-radius:20px; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;"><?php echo e($healthrecord->EmployeeName); ?></p>
                        <input name="Description" type="text" class="text_edit_detail_record" style="border:none; width:100%; border-radius:20px; margin-bottom:2.1%; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;" value="<?php echo e($healthrecord->Description); ?>"/><br>
                        <input name="Diagnosis" type="text" class="text_edit_detail_record" style="border:none; width:100%; border-radius:20px; margin-bottom:2.1%; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;" value="<?php echo e($healthrecord->Diagnosis); ?>"/><br>
                        <input name="Result" type="text" class="text_edit_detail_record" style="border:none; width:100%; border-radius:20px; margin-bottom:2.1%; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;" value="<?php echo e($healthrecord->Result); ?>"/><br>
                        <input name="Notes" type="text" class="text_edit_detail_record" style="border:none; width:100%; border-radius:20px; margin-bottom:2.1%; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;" value="<?php echo e($healthrecord->Notes); ?>"/><br>
                        <input name="PatientView" type="text" class="text_edit_detail_record" style="border:none; width:100%; border-radius:20px; margin-bottom:2.1%; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;" value="<?php echo e($healthrecord->PatientView); ?>"/><br>
                        <input name="TotalFee" type="text" class="text_edit_detail_record" style="border:none; width:100%; border-radius:20px; margin-bottom:2.1%; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;" value="<?php echo e($healthrecord->TotalFee); ?>"/><br>
                    </div>
                </div>
                <div>
                    <button class="btn btn-primary btn_save_record" type="submit" style="margin-top:4%; margin-left:45%;">Save</button>
                </div>
            </form>
        </div>
    </div>
<?php $__env->stopSection(); ?>
<?php echo $__env->make('doctor.main.layouts.layout_doctor', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?><?php /**PATH C:\xampp\htdocs\learncode\TestLaravel\resources\views/doctor/main/healthrecordedit.blade.php ENDPATH**/ ?>