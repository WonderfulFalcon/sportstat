require("./../css/style.less");

import App from './components/App';
import React from 'react';
import ReactDOM from 'react-dom';
import { createStore } from 'redux';
import reducer from './reducers/index';
import { Provider } from 'react-redux';

import { loadAvailableLeagues } from './api/external-api';

import {
    loadPlayersAction,
    currentSelectedTeamAction } from './actions/actions.js';


export function loadPlayers (team) {
    let data = new FormData();
    data.append("teamId", team.teamId);

    fetch('/teamPlayers', { method: 'post', body: data })
        .then(response => response.json())
        .then(json => store.dispatch(loadPlayersAction(json, team.teamName)));
}

export function selectTeam(selectedTeam) {
    store.dispatch(currentSelectedTeamAction(selectedTeam));
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
