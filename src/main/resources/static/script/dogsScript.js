$(document).ready(function () {
        $.get("api/list", function (data) {
            console.log(data);
            $.each( data, function( key, value ){
                var eachrow = "<tr>"
                    + "<td>" + value.name + "</td>"
                    + "<td>" + value.breed.name + "</td>"
                    + "<td>" + value.age + "</td>"
                    + "</tr>";
                $("#dog-list").append(eachrow);
            });
        });
    }
);