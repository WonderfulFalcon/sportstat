require("./../css/style.less");

import App from './App';
import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import { createStore } from 'redux';
import reducer from './reducers';
import { Provider } from 'react-redux';

import {
    loadLeaguesAction,
    loadTablesAction,
    loadMatchesAction,
    loadPlayersAction } from './actions/actions.js';


function loadAvailableLeagues() {
    return {
        type: "POST",
        payload: fetch('/availableLeagues', { method: 'POST'})
            .then(response => response.json())
            .then(json => store.dispatch(loadLeaguesAction(json)))
    }
}

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

export function loadPlayers (teamId, teamName) {
    let data = new FormData();
    data.append("teamId", teamId);

    fetch('/teamPlayers', { method: 'post', body: data })
        .then(response => response.json())
        .then(json => store.dispatch(loadPlayersAction(json, teamName)));
}

export const store = createStore(reducer, window.__REDUX_DEVTOOLS_EXTENSION__ &&
    window.__REDUX_DEVTOOLS_EXTENSION__());

loadAvailableLeagues();

ReactDOM.render(
    <Provider store={store}>
        <App />
    </Provider>,
    document.getElementById('root')
);
