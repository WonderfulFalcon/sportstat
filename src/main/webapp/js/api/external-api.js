import { loadTablesAction, loadMatchesAction, loadLeaguesAction } from "../actions/actions";
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
                }
            );
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
            .then(json => store.dispatch(loadLeaguesAction(json)))
    }
}


