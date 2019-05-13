$(document).ready(function() {

    /** gets the time **/
    var currentTime = new Date();
    console.log(currentTime.toTimeString());

    /** conditional to verify time of day to set the background **/
    var src;
    var time = currentTime.toTimeString();
    if (time >= "09:00:00" && time < "12:00:00") {
        src = "url(/img/morning.png)"
    } else if (time >= "12:00:00" && time < "15:00:00") {
        src = "url(/img/latemorning.png)"
    } else if (time >= "15:00:00" && time < "18:00:00") {
        src = "url(/img/afternoon.png)"
    } else if (time >= "18:00:00" && time < "21:00:00") {
        src = "url(/img/lateafternoon.png)"
    } else if (time >= "21:00:00" || time === "23:59:59") {
        src = "url(/img/evening.png)"
    } else if (time >= "00:00:00" && time < "03:00:00") {
        src = "url(/img/lateevening.png)"
    } else if (time >= "03:00:00" && time < "06:00:00") {
        src = "url(/img/night.png)"
    } else if (time >= "06:00:00" && time < "09:00:00") {
        src = "url(/img/latenight.png)"
    }

    $(".bg").css("background-image", src);


    function timeWarp() {
        var secretCode = "";
        var konamiCode = "8473776987658280";
        $(document).on("keydown", function (e) {
            secretCode = secretCode + ("" + e.keyCode);
            if (secretCode === konamiCode) {
                setTimeout(function () {
                    $("body").css("background-image", "url(img/morning.png)");
                }, 1000);
                setTimeout(function () {
                    $("body").css("background-image", "url(img/latemorning.png)");
                }, 2000);
                setTimeout(function () {
                    $("body").css("background-image", "url(img/afternoon.png)");
                }, 3000);
                setTimeout(function () {
                    $("body").css("background-image", "url(img/lateafternoon.png)");
                }, 4000);
                setTimeout(function () {
                    $("body").css("background-image", "url(img/evening.png)");
                }, 5000);
                setTimeout(function () {
                    $("body").css("background-image", "url(img/lateevening.png)");
                }, 6000);
                setTimeout(function () {
                    $("body").css("background-image", "url(img/night.png)");
                }, 7000);
                setTimeout(function () {
                    $("body").css("background-image", "url(img/latenight.png)");
                }, 8000);

            }
            if (!konamiCode.indexOf(secretCode)) return;
            secretCode = ("" + e.keyCode);

        });

    }

    $(document).keyup(function (event) {
        console.log(event.keyCode);
    });
    timeWarp();

});