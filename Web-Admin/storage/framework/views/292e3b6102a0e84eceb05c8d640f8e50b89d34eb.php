<?php $__env->startSection('content'); ?>
<br/>
<div class="container box" >
    <div class="panel panel-default">
        <div class="panel-heading"></div>
            <div class="panel-body">
                <div class="form-group">
                    <div id="main_div">
                        <div id="main_home">
                            <div class="container">
                                <div class="row">
                                    <div class="col"><small class="form-text text-muted" id="text_username">Employee: <?php echo e($employee->EmployeeName); ?></small>                            
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div>
    <div class="content_div">
        <div id="content_home"><small class="form-text text-muted name_table" id="text_name_table">Employee Profile</small>
            <div id="table_last_result">
                <div class="col-4" id="column_name">
                    <p class="text_name">Employee ID<br /></p>
                    <p class="text_name">Employee Name<br /></p>
                    <p class="text_name">Gender<br /></p>
                    <p class="text_name">Birthday<br /></p>
                    <p class="text_name">Degree<br /></p>
                    <p class="text_name">Speciality<br /></p>
                    <p class="text_name">Medical School<br /></p>
                    <p class="text_name">Year Of Degree<br /></p>
                    <p class="text_name">License Country<br /></p>
                    <p class="text_name">License EXP<br /></p>
                </div>
                <div class="col" id="column_detail">
                    <p class="text_detail" style="border:none; width:100%; border-radius:20px; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;"><?php echo e($employee->EmployeeID); ?></p>
                    <p class="text_detail" style="border:none; width:100%; border-radius:20px; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;"><?php echo e($employee->EmployeeName); ?></p>
                    <p class="text_detail" style="border:none; width:100%; border-radius:20px; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;"><?php echo e($employee->Gender); ?></p>
                    <p class="text_detail" style="border:none; width:100%; border-radius:20px; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;"><?php echo e($employee->DayofBirth); ?></p>
                    <p class="text_detail" style="border:none; width:100%; border-radius:20px; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;"><?php echo e($employee->Degree); ?></p>
                    <p class="text_detail" style="border:none; width:100%; border-radius:20px; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;"><?php echo e($employee->Speciality); ?></p>
                    <p class="text_detail" style="border:none; width:100%; border-radius:20px; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;"><?php echo e($employee->MedicalSchool); ?></p>
                    <p class="text_detail" style="border:none; width:100%; border-radius:20px; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;"><?php echo e($employee->YearOfDegree); ?></p>
                    <p class="text_detail" style="border:none; width:100%; border-radius:20px; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;"><?php echo e($employee->LicenseCountry); ?></p>
                    <p class="text_detail" style="border:none; width:100%; border-radius:20px; font-size:18px; background-color:#ffffff; padding-left:5%; text-align:center;"><?php echo e($employee->LicenseEXP); ?></p>
                </div>
            </div>
        </div>
    </div>
</div>
<?php $__env->stopSection(); ?>
<?php echo $__env->make('member.main.layouts.layout_home', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?><?php /**PATH C:\xampp\htdocs\learncode\TestLaravel\resources\views/member/main/doctorprofile.blade.php ENDPATH**/ ?>