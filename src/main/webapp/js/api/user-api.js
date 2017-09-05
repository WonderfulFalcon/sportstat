import { store } from "../main";
import { currentSelectedTeamAction, currentSelectedLeague } from './../actions/actions.js';

export function selectTeam(selectedTeam) {
    store.dispatch(currentSelectedTeamAction(selectedTeam));
}

export function selectLeague(selectedLeague) {
    store.dispatch(currentSelectedLeague(selectedLeague));
}