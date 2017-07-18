import { combineReducers } from 'redux';
import availableLeagues from './availableLeagues'
import leagueTable from './leagueTable'

export default combineReducers({
    availableLeagues,
    leagueTable
})