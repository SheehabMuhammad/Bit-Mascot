$(document).on("click", "a", function(){
    alert("Clicked on anchor tag!");
    //Added to prevent from visiting to the link
    event.preventDefault();
});