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
                                    <div class="col"><small class="form-text text-muted" id="text_username">Hi <?php echo e($patientname); ?></small>
                                        <form action="<?php echo e(route('user.search')); ?>" method="GET" role="search">
                                    
                                        <div class="input-group">
                                            <input type="text" class="form-control" style="width:100%; border-radius:20px;" name="q" placeholder="Search users"> 
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
                            <th>Employee ID</th>
                            <th>Employee Name</th>
                            <th>Speciality</th>
                            <th>MedicalSchool</th>
                            <th>Detail</th>     
                        </tr>
                    </thead>
                    <tbody id="tbody">
                        <?php $__currentLoopData = $employee; $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $user): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                            <tr>
                                <td><?php echo e($user->EmployeeID); ?></td>
                                <td><?php echo e($user->EmployeeName); ?></td>
                                <td><?php echo e($user->Speciality); ?></td>
                                <td><?php echo e($user->MedicalSchool); ?></td>
                                <td><a class="nav-link active" href="<?php echo e(route('user.doctorprofile', $user->UserID)); ?>">ViewDoctorProfile</a></td>
                            </tr>
                        <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
                        </tbody>   
                </table>
            </div>
        </div>    
    </div>
</div>
<?php $__env->stopSection(); ?>
<?php echo $__env->make('member.main.layouts.layout_home', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?><?php /**PATH C:\xampp\htdocs\learncode\TestLaravel\resources\views/member/main/home.blade.php ENDPATH**/ ?>