$(document).ready(function () {
    console.log("script file loaded");

    var dogId = $(".profile-image-container").attr('id').replace("profile-image-container_", "");
    console.log(dogId);

    var url = "/api/photos/" + dogId;

    console.log(url);
    var dogPhotos = function(dogId){
        $.ajax(url,
            function (data) {
            console.log(data);
            $.each(data, function (key, value) {
                var $img = $('<img/>')
                    .attr("src", value)
                    .attr("alt", "photo"+key);
                console.log($img);
                $("#profile-image-container").append($img);

                console.log("tralala");
            })
        }, "jsonp")
    };

    $("body").on("load", function() {
        console.log("on body load")
        dogPhotos(dogId);
    });

    $("#image-upload").on("click", function() {
        console.log("on click event")
        dogPhotos(dogId);
    });
});