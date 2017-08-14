import { combineReducers } from 'redux';

import availableLeagues from './availableLeagues'
import leagueTable from './leagueTable'
import teamPlayers from './teamPlayers';
import leagueLogo from './leagueLogo'

export default combineReducers({
    availableLeagues,
    leagueTable,
    teamPlayers
    leagueLogo
})