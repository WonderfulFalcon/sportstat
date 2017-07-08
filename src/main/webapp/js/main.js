require("./../css/style.less");

import App from './App';
import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import { createStore } from 'redux';
import { Provider } from 'react-redux';

function leaguesReducer(state = [], action = {}) {
    if (action.type == 'LOAD_LEAGUES') {
        return action.payload;
    }
    return state;
}

function loadAvailableLeagues() {
    return {
        type: "POST",
        payload: fetch('/availableLeagues', { method: 'POST'})
            .then(response => response.json())
            .then(json => store.dispatch({ type : "LOAD_LEAGUES", payload: json }))
    }
}

export const store = createStore(leaguesReducer);
loadAvailableLeagues();

ReactDOM.render(<App />, document.getElementById('root'));


//$(document).ready(function() {
//    var leagueSelect = $("#leagueInfo");
//    var toursPlayed = leagueSelect.find(":selected").data("leagueToursPlayed");
//    var leagueId = leagueSelect.find(":selected").data("leagueId");
//
//    loadLeague(leagueId, toursPlayed);
//    resetMatchDaySelect(toursPlayed);
//
//    $(document).on("change", "#leagueInfo", function() {
//        var matchDaySelect = $("#matchDay");
//        var currentLeague = $(this).find(":selected");
//
//        var leagueId = parseInt(currentLeague.data("leagueId"));
//
//        matchDaySelect.find("option").remove();
//        var toursPlayed =  parseInt(currentLeague.data("leagueToursPlayed"));
//
//        resetMatchDaySelect(toursPlayed, matchDaySelect);
//        loadLeague(leagueId, toursPlayed);
//    });
//
//    $(document).on("change", "#matchDay", function() {
//        var leagueId = parseInt($("#leagueInfo").find(":selected").data("leagueId"));
//        var matchDay = parseInt(this.value);
//        loadLeague(leagueId, matchDay);
//    });
//
//    $(document).on("click", "[data-clickable-team]", function() {
//        var teamId = $(this).data("clickableTeam");
//        var teamName = $(this).find(".team-name span").text();
//
//        $(".teamColumn").css("background-color", "");
//        $(this).css("background-color", "#ffd090");
//
//        $.ajax({
//            url: "/teamPlayers",
//            type: "POST",
//            dataType: "html",
//            data: {
//                teamId: teamId
//            },
//            success: function (response) {
//                $("[data-players-container]").html(response);
//                $("#team-squad").text(teamName);
//            }
//        });
//    });
//
//    function resetMatchDaySelect(toursPlayed) {
//        var matchDaySelect = $("#matchDay");
//        for (var i = 0; i <= toursPlayed; i++) {
//            matchDaySelect.append($('<option>', {value: i, text: i}));
//        }
//        matchDaySelect.find("option:last-child").prop('selected', true)
//    }
//
//    function loadLeague(leagueId, matchDay) {
//        $.ajax({
//            url: "/league",
//            type: "POST",
//            dataType: "html",
//            data: {
//                leagueId : leagueId,
//                matchDay : matchDay
//            },
//            success: function (response) {
//                $("[data-league-container]").html(response);
//            }
//        });
//    }
//});