$(document).ready(function () {
    console.log("script file loaded");

    var dogId;


    var dogPhotos = function (dogId) {
        dogId = $(".profile-image-container").attr('id').replace("profile-image-container_", "");
        var url = "/api/photos/" + dogId;
        console.log(dogId);

        $.getJSON(url,
            function (data) {
                console.log("in success");
                $.each(data, function (key, value) {
                    var $img = $('<img/>')
                        .attr("src", value.path)
                        .attr("alt", "photo" + value.path);
                    console.log($img);
                    $("#profile-image-container").append($img);

                })
            }, function (xhr, status, error) {
                var err = eval("(" + xhr.responseText + ")");
                console.log(err.Message);
            },

            "jsonp")
    };

    dogPhotos(dogId);
});