import React from 'react';
import { connect } from 'react-redux';

import TeamPlayers from './../components/TeamPlayers';

const mapStateToProps = (state) => {
    return {
        currentSelectedTeam: state.currentSelectedTeam,
        teamPlayers : state.teamPlayers
    }
};

export default connect(mapStateToProps)(TeamPlayers);