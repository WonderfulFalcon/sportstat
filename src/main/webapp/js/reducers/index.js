import { combineReducers } from 'redux';

import availableLeagues from './availableLeagues'
import leagueTable from './leagueTable'
import teamPlayers from './teamPlayers';
import leagueMatches from './leagueMatches';
import currentSelectedTeam from './currentSelectedTeam';
import currentState from './currentState';

export default combineReducers({
    availableLeagues,
    leagueTable,
    teamPlayers,
    leagueMatches,
    currentSelectedTeam,
    currentState
})