$(document).ready(function() {
    $("#leagueTable").on("click", function() {
        var matchDay = parseInt($('#matchDay').find(":selected").text());

        $.ajax({
            url: "/leagueTable",
            type: "POST",
            dataType: "html",
            data: {
                leagueId : 426,
                matchDay : matchDay
            },
            success : function(response) {
                $("[data-league-container]").html(response);
            }
        });
    });
});