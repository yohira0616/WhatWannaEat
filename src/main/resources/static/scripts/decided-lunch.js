console.log('Readed!');

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
            var restaurantApiUrl = "http://api.gnavi.co.jp/RestSearchAPI/20150630/?callback=?";
            var searchWord = $("#app-result").text();
            var params = {
                keyid: '35214ad59b8f8771a0d090041b391b05',
                format: 'json',
                latitude: latitude,
                longitude: longitude,
                freeword: searchWord
            };
            console.log(params);
            $.getJSON(restaurantApiUrl, params, function (resultData) {
                console.log(resultData);
                var rests = resultData.rest;
                var $tbl = $('#app-suggest-rest');
                for (var i = 0; i < rests.length; i++) {
                    var html = "";
                    html += "<tr>";
                    html += "<td>" + rests[i].name + "</td>";
                    html += "<td>" + rests[i].url_mobile + "</td>";
                    html += "<td>" + rests[i].address + "</td>";
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