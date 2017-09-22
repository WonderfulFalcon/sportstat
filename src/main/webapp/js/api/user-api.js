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
    const languages = ['en', 'ru'];
    store.dispatch(initialize(languages, { defaultLanguage: 'en' }));
}

export function initLocalizeData() {
    const json = require('./../../localization/headers.json');
    store.dispatch(addTranslation(json));
}