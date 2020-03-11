<?php $__env->startSection('content'); ?>
<div id="main_div">
        <div id="main_home">
            <div class="container">
                <div class="row">
                    <div class="col">
                        <p id="text_username">Patient: <?php echo e($patientname); ?></p>
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
            <div id="table_last_result">
                <div class="col-4" id="column_name">
                    <p class="text_name">Date<br /></p>
                    <p class="text_name">Patient ID<br /></p>
                    <p class="text_name">Employee ID<br /></p>
                    <p class="text_name">Description<br /></p>
                    <p class="text_name">Diagnosis<br /></p>
                    <p class="text_name">Result<br /></p>
                    <p class="text_name">Notes<br /></p>
                    <p class="text_name">Patient View<br /></p>
                    <p class="text_name">TotalFee<br /></p>
                </div>
                <div class="col" id="column_detail">
                    <form action="<?php echo e(route('doctor.record', $patientid)); ?>" method="POST">
                        <?php echo csrf_field(); ?>
                        <input type="text" class="text_edit_detail_record" id="id_date" name="HealthRecorDateTime" style="border:none; width:100%; border-radius:20px; margin-bottom:2.1%; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;"/><br>
                        <input type="text" class="text_edit_detail_record" id="id_patientid" name="PatientID" style="border:none; width:100%; border-radius:20px; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;" value="<?php echo e($patientid); ?>"><br>
                        <input type="text" class="text_edit_detail_record" id="id_employeeid" name="EmployeeID" style="border:none; width:100%; border-radius:20px; margin-bottom:2.1%; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;" value="<?php echo e($employeeid); ?>"/><br>
                        <input type="text" class="text_edit_detail_record" id="id_description" name="Description" style="border:none; width:100%; border-radius:20px; margin-bottom:2.1%; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;"/><br>
                        <input type="text" class="text_edit_detail_record" id="id_diagnosis" name="Diagnosis" style="border:none; width:100%; border-radius:20px; margin-bottom:2.1%; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;"/><br>
                        <input type="text" class="text_edit_detail_record" id="id_result" name="Result" style="border:none; width:100%; border-radius:20px; margin-bottom:2.1%; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;"/><br>
                        <input type="text" class="text_edit_detail_record" id="id_notes" name="Notes" style="border:none; width:100%; border-radius:20px; margin-bottom:2.1%; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;"/><br>
                        <input type="text" class="text_edit_detail_record" id="id_patientview" name="PatientView" style="border:none; width:100%; border-radius:20px; margin-bottom:2.1%; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;"/><br>
                        <input type="text" class="text_edit_detail_record" id="id_totalfee" name="TotalFee" style="border:none; width:100%; border-radius:20px; margin-bottom:2.1%; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;"/><br>
                        <div style="display:flex;">
                            <button class="btn btn-primary btn_save" type="submit" style="margin-top:4%; margin-left:0%;">Save</button>
                            <button class="btn btn-primary" type="button" style="margin-top:4%; margin-left:20%;" id="btn_cancel">Cancel</button>
                        </div>
                    </form>
                </div>
            </div>
            
        </div>
    </div>
<?php $__env->stopSection(); ?>

<script>
        $(document).ready(function() {
            $('#btn_cancel').click(function() {
                $('#id_date').val("");
                $('#id_description').val("");
                $('#id_diagnosis').val("");
                $('#id_result').val("");
                $('#id_notes').val("");
                $('#id_patientview').val("");
                $('#id_totalfee').val("");
            });
        });
    </script>
<?php echo $__env->make('doctor.main.layouts.layout_doctor', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?><?php /**PATH C:\xampp\htdocs\learncode\TestLaravel\resources\views/doctor/main/addhealthrecord.blade.php ENDPATH**/ ?>