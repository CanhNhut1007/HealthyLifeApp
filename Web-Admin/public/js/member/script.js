$(document).ready(function() {
    $('#btn_cancel1').click(function() {
        $('#id_loginemail').val("");
        $('#id_emailpass').val("");
    });

    $('#btn_cancel2').click(function() {
        $('#id_currentpass').val("");
        $('#id_newpass').val("");
        $('#id_confirmpass').val("");
    });
});