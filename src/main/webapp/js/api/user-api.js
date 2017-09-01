import { store } from "../main";
import { currentSelectedTeamAction } from './../actions/actions.js';

export function selectTeam(selectedTeam) {
    store.dispatch(currentSelectedTeamAction(selectedTeam));
}