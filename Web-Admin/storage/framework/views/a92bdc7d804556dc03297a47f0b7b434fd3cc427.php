<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <form method="POST" action="<?php echo e(route('admin.logout')); ?>">
                <?php echo e(csrf_field()); ?>

                    <input type='submit' id="admin_logout"class="btn btn-primary" value="Logout">
                </form>
            </div>
        </div>
    </div>
</div><?php /**PATH E:\xampp\htdocs\TestLaravel\resources\views/admin/layouts/layout_dashboard_logout.blade.php ENDPATH**/ ?>