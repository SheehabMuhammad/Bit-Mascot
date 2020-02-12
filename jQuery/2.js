$(document).ready(function() {
    setInterval(function() {
        $.ajax({
            url: "/dynamic.php",
        }).done(function( data ) {
            $('#my-div').html(data);
            console.log("Refreshed");
        });
    }, 15000);
});