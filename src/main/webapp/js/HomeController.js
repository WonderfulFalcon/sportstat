$(document).ready(function() {
    $("#leagueTable").on("click", function() {
        var matchDay = parseInt($('#matchDay').find(":selected").text());

        $.ajax({
            url: "127.0.0.1:8585/leagueTable",
            type: "POST",
            dataType: "json",
            data: {
                leagueId : 426,
                matchDay : matchDay
            },
            success : function(response) {
                console.log(response)
            }
        });
    });
});