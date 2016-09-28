(function ($) {
    $(function () {

        $('#app-rest-search').click(function () {


            var loc = $('#app-geo-location');
            if (!navigator.geolocation) {
                loc.text("この端末では位置情報を取得できません");
                return;
            }
            $.blockUI();

            navigator.geolocation.getCurrentPosition(function (position) {
                var latitude = position.coords.latitude;
                var longitude = position.coords.longitude;
                var restaurantApiUrl = "/api/restaurant";
                var searchWord = $("#app-result").text();
                var params = {
                    latitude: latitude,
                    longitude: longitude,
                    freeword: searchWord
                };
                $.getJSON(restaurantApiUrl, params, function (resultData) {
                    var $tbl = $('#app-suggest-rest');
                    $tbl.empty();
                    for (var i = 0; i < resultData.length; i++) {
                        var html = "";
                        html += "<tr>";
                        html += "<td>" + resultData[i].name + "</td>";
                        html += "<td><a href='" + resultData[i].urlMobile + "' class='btn btn-default'>移動</a></td>";
                        html += "<td>" + resultData[i].address + "</td>";
                        html += "</tr>";
                        $tbl.append(html);
                    }

                });
                $.unblockUI();
            }, function (error) {
                var errMsg = "位置情報の取得に失敗しました";
                $.unblockUI();
                console.log(error);
            });

        });

    });
})(window.jQuery);