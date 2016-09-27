(function ($) {
    $(function () {
        var loc = $('#app-geo-location');
        if (!navigator.geolocation) {
            loc.text("この端末では位置情報を取得できません");
            return;
        }
        navigator.geolocation.getCurrentPosition(function (position) {
            var latitude = position.coords.latitude;
            var longitude = position.coords.longitude;
            var locationText = "緯度：" + latitude + "経度；" + longitude;
            loc.text(locationText);
            //周りのレストランを検索
            var restaurantApiUrl = "/api/restaurant";
            var searchWord = $("#app-result").text();
            var params = {
                latitude: latitude,
                longitude: longitude,
                freeword: searchWord
            };
            console.log(params);
            $.getJSON(restaurantApiUrl, params, function (resultData) {
                console.log(resultData);
                var $tbl = $('#app-suggest-rest');
                for (var i = 0; i < resultData.length; i++) {
                    var html = "";
                    html += "<tr>";
                    html += "<td>" + resultData[i].name + "</td>";
                    html += "<td>" + resultData[i].urlMobile + "</td>";
                    html += "<td>" + resultData[i].address + "</td>";
                    html += "</tr>";
                    $tbl.append(html);
                }

            })
        }, function (error) {
            var errMsg = "位置情報の取得に失敗しました";
            loc.text(errMsg);
            console.log(error);
        });
    });
})(window.jQuery);