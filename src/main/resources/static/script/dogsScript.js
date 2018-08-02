$(document).ready(function () {
    console.log("script file loaded");

    var dogId;


    var getPhotos = function (dogId) {
        $(".profile-image-container").empty();
        dogId = $(".profile-image-container").attr('id').replace("profile-image-container_", "");
        var url = "/api/photos/" + dogId;
        console.log(dogId);

        $.getJSON(url,
            function (data) {
                console.log("in success");
                $.each(data, function (index, photo) {
                    var $imageSpan = $("<span />")
                        .attr("class", "imageSpan");
                    var $imgRow = $("<img />")
                        .attr("src", photo.path)
                        .attr("alt", "photo" + photo.path);
                    $imageSpan.append($imgRow);
                    $(".profile-image-container").append($imageSpan);

                })
            }, function (xhr, status, error) {
                var err = eval("(" + xhr.responseText + ")");
                console.log(err.Message);
            },

            "jsonp")
    };

    getPhotos(dogId);
});