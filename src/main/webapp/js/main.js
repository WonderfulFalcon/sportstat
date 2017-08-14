require("./../css/style.less");

import App from './App';
import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import { createStore } from 'redux';
import reducer from './reducers';
import { Provider } from 'react-redux';
import { Provider } from 'react-redux';

function loadAvailableLeagues() {
    return {
        type: "POST",
        payload: fetch('/availableLeagues', { method: 'POST'})
            .then(response => response.json())
            .then(json => store.dispatch({ type : "LOAD_LEAGUES", payload: json }))
    }
}

export function loadLeague(leagueId, matchDay) {
    if (leagueId && matchDay) {
        let data = new FormData();
        data.append("leagueId", leagueId);
        data.append("matchDay", matchDay);

        fetch('/league', { method: 'post', body: data })
            .then(response => response.json())
            .then(json => store.dispatch({type : "LOAD_TABLES", payload: json }));
    }
}

export function loadPlayers (teamId) {
    let data = new FormData();
    data.append("teamId", teamId);

    fetch('/teamPlayers', { method: 'post', body: data })
        .then(response => response.json())
        .then(json => store.dispatch({type : "LOAD_PLAYERS", payload: json }));
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
