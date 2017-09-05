import React from 'react';
import { connect } from 'react-redux';

import LeagueTable from '../components/league/LeagueTable';

const mapStateToProps = (state) => {
    return {
        leagueTable : state.leagueTable,
        homeAwayState : state.homeAwayState
    }
};

export default connect(
    mapStateToProps
)(LeagueTable);