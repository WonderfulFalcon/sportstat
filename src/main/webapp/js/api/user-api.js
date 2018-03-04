import { addTranslation } from 'react-localize-redux';
import { initialize } from 'react-localize-redux';

import { store } from "../main";
import { currentSelectedTeamAction, currentSelectedLeague } from './../actions/actions.js';

export function selectTeam(selectedTeam) {
    store.dispatch(currentSelectedTeamAction(selectedTeam));
}

export function selectLeague(selectedLeague) {
    store.dispatch(currentSelectedLeague(selectedLeague));
}

export function initLocalize() {
    const languages = ['England', 'Russia'];
    store.dispatch(initialize(languages, { defaultLanguage: 'England' }));
}

export function initLocalizeData() {
    const json = require('./../../localization/headers.json');
    store.dispatch(addTranslation(json));
}