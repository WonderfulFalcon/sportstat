$(document).ready(function() {
    $(document).on("change", "#matchDay", function() {
        var matchDay = parseInt(this.value);
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

    $(document).on("click", "[data-clickable-team]", function() {
        var teamId = $(this).data("clickableTeam");

        $.ajax({
            url: "/teamPlayers",
            type: "POST",
            dataType: "html",
            data: {
                teamId: teamId
            },
            success: function (response) {
                $("[data-players-container]").html(response);
            }
        });
    });
});