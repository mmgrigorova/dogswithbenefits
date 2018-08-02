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
                $.each(data, function (index, photo) {
                    var $imgRow = $("<img />")
                        .attr("src", photo.path)
                        .attr("alt", "photo" + photo.path);
                    $(".profile-image-container").append($imgRow);

                })
            }, function (xhr, status, error) {
                var err = eval("(" + xhr.responseText + ")");
                console.log(err.Message);
            },

            "jsonp")
    };
    dogPhotos(dogId);
});