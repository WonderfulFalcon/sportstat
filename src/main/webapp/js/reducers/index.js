import { combineReducers } from 'redux';

import availableLeagues from './availableLeagues'
import leagueTable from './leagueTable'
import teamPlayers from './teamPlayers';
import leagueMatches from './leagueMatches';
import homeAwayState from './homeAwayState';
import currentSelectedTeam from './currentSelectedTeam';
import currentSelectedLeague from './currentSelectedLeague';
import leagueHistory from './leagueHistory';

import { localeReducer as locale} from 'react-localize-redux';

export default combineReducers({
    availableLeagues,
    leagueTable,
    teamPlayers,
    leagueMatches,
    homeAwayState,
    currentSelectedTeam,
    currentSelectedLeague,
    locale,
    leagueHistory
});