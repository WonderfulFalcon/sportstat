import { loadTablesAction, loadMatchesAction, loadLeaguesAction, loadPlayersAction, currentSelectedLeague, loadLeagueHistory } from "../actions/actions";
import { store } from "../main";


export function loadLeague(leagueId, matchDay) {
    if (leagueId && matchDay) {
        let data = new FormData();
        data.append("leagueId", leagueId);
        data.append("matchDay", matchDay);

        fetch('/league', { method: 'post', body: data })
            .then(response => response.json())
            .then(league => {
                    store.dispatch(loadTablesAction(league));
                    loadMatches(league.id, league.matchDay);
                    loadHistory(league.id, 5);
                }
            );
    }
}

export function loadHistory(leagueId, matchesCount) {
    if (leagueId) {
        let data = new FormData();
        data.append("leagueId", leagueId);
        data.append("matchesCount", matchesCount);

        fetch('/lastMatchesByTeams', { method : 'post', body: data })
            .then(response => response.json())
            .then(history => {
                store.dispatch(loadLeagueHistory(history));
            });
    }
}

export function loadMatches(leagueId, matchDay) {
    let data = new FormData();
    data.append("leagueId", leagueId);
    data.append("matchDay", matchDay);

    fetch('/matches', { method: 'post', body: data })
        .then(response => response.json())
        .then(matches => {
                store.dispatch(loadMatchesAction(matches));
            }
        );
}

export function loadAvailableLeagues() {
    return {
        type: "POST",
        payload: fetch('/availableLeagues', { method: 'POST'})
            .then(response => response.json())
            .then(availableLeagues => {
                store.dispatch(loadLeaguesAction(availableLeagues));
                return availableLeagues;
            })
            .then(availableLeagues => {
                const firstLeague = availableLeagues[0];
                if (firstLeague) {
                    store.dispatch(currentSelectedLeague(firstLeague));
                    loadLeague(firstLeague.id, firstLeague.toursPlayed);
                }
            })
    }
}

export function loadPlayers (team) {
    let data = new FormData();
    data.append("teamId", team.teamId);

    fetch('/teamPlayers', { method: 'post', body: data })
        .then(response => response.json())
        .then(json => store.dispatch(loadPlayersAction(json, team.teamName)));
}