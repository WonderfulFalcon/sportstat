import React from 'react';
import { connect } from 'react-redux';

import LeagueTable from '../components/league/LeagueTable';

const mapStateToProps = (state) => {
    return {
        leagueTable : state.leagueTable,
        homeAwayState : state.homeAwayState,
        selectedLeague : state.currentSelectedLeague,
        leagueHistory : state.leagueHistory
    }
};

export default connect(
    mapStateToProps
)(LeagueTable);
