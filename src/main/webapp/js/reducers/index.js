import { combineReducers } from 'redux';
import availableLeagues from './availableLeagues'
import leagueTable from './leagueTable'
import leagueLogo from './leagueLogo'

export default combineReducers({
    availableLeagues,
    leagueTable,
    leagueLogo
})