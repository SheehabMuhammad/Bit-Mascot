$(document).ready(function() {
    var array = ["apple", "banana", "cake"];
    $.each( array, function( key, value ) {
        $('#my-ul').append( "<li>" + value + "</li>" );
    });
});