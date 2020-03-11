$(document).ready(function() {
                $("#nameNN").change(function(){

                    val = $("#nameNN").val();

                    $.post("ds.php", {
                            mann:val
                    },function(data, status){
                    if (status == "success"){
                            $("#data").html(data);
                        }
                    }
                });
            });