<?php $__env->startSection('content'); ?>
<!-- Page Content -->
<div id="content-wrapper" style="padding:20px;">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Doctor
                    <small>Add</small>
                </h1>
            </div>
            <!-- /.col-lg-12 -->
            <div class="col-lg-7" style="padding-bottom:120px">
            <?php if(session()->has('success')): ?>
            <div class="text-success" role="alert">
                <p><?php echo e(session('success')); ?></p>
            </div>
            <?php elseif(session()->has('error')): ?>
            <div class='text-danger' role="alert">
                <p><?php echo e(session('error')); ?></p>
            </div>
            <?php endif; ?>
                <form action="<?php echo e(route('admin.adddoctor')); ?>" method="POST">
                <?php echo e(csrf_field()); ?>

                    <div class="form-group">
                    <select id="myselect">
                        <option value="" selected="selected">Please select email</option>
                        <?php $__currentLoopData = $listemail; $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $email): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                        <option name='email' value="<?php echo $email->email ?>"><?php echo e($email->email); ?></option>  
                        <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
                    </select>
                    <select id="myselect1">
                        <option value="" selected="selected">Please select Hospital</option>
                        <?php $__currentLoopData = $listhospital; $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $hospital): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                        <option name='hospital' value="<?php echo $hospital->HospitalID ?>"><?php echo e($hospital->HospitalName); ?></option>  
                        <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
                    </select>
                    <input type="hidden" id="email" name="email" value="">
                    <input type="hidden" id="hospital" name="hospital" value="">
                    <script> 
                        $(document).ready(function(){
                            $("#myselect").change(function(){
                                
                                $("#email").val($(this).val());
                            });
                            $("#myselect1").change(function(){
                                
                                $("#hospital").val($(this).val());
                            });
                        });
                    </script>
                    </div>
                    <div class="form-group">
                        <label>Doctor Name</label>
                        <input type="text" name="EmployeeName" class="form-control" value="" required autofocus>
                    </div>
                    <div class="form-group">
                        <label>Gender: </label>
                        <input type="text" name="Gender" class="form-control" value="" required>
                    </div>
                    <div class="form-group">
                        <label>Phone Number</label>
                        <input type="text"  class="form-control" name="PhoneNumber" value="" required>
                    </div>
                    <div class="form-group">
                        <label>Day of Birth</label>
                        <input type="date"  class="form-control" name="DayofBirth" value="" required pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}">
                    </div>
                    <div class="form-group">
                        <label>Degree</label>
                        <input type="text"  class="form-control" name="Degree" value="" required>
                    </div>
                    <div class="form-group">
                        <label>Speciality</label>
                        <input type="text"  class="form-control" name="Speciality" value="" required>
                    </div>
                    <div class="form-group">
                        <label>Medical School</label>
                        <input type="text"  class="form-control" name="MedicalSchool" value="" required>
                    </div>
                    <div class="form-group">
                        <label>YearOfDegree</label>
                        <input type="text"  class="form-control" name="YearOfDegree" value="" required>
                    </div>
                    <div class="form-group">
                        <label>LicenseNumber</label>
                        <input type="text"  class="form-control" name="LicenseNumber" value="" required>
                    </div>	
                    <div class="form-group">
                        <label>LicenseCountry</label>
                        <input type="text"  class="form-control" name="LicenseCountry" value="" required>
                    </div>
                    <div class="form-group">
                        <label>LicenseEXP</label>
                        <input type="date"  class="form-control" name="LicenseEXP" value="" required>
                    </div>
                    <div class="form-group">
                        <label>IdentifyCard</label>
                        <input type="text"  class="form-control" name="IdentifyCard" value="" required>
                    </div>	
                    <input type="submit" value="AddDoctor">
                    <input type="reset" value="Reset">
                <form>
            </div>
        </div>
        <!-- /.row -->
    </div>
    <!-- /.container-fluid -->
</div>
<!-- /#page-wrapper -->
<?php $__env->stopSection(); ?>
<?php echo $__env->make('admin.layouts.layout_dashboard', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?><?php /**PATH C:\xampp\htdocs\learncode\TestLaravel\resources\views/admin/adddoctor.blade.php ENDPATH**/ ?>