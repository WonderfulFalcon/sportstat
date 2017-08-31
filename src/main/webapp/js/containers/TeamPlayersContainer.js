import React, { Component } from 'react';
import { connect } from 'react-redux';

import TeamPlayers from './../components/TeamPlayers';

class TeamPlayersContainer extends Component {
    isShowPlayers () {
        return !$.isEmptyObject(this.props.currentSelectedTeam) &&
            this.props.teamPlayers.teamPlayers &&
            this.props.teamPlayers.teamPlayers.length > 0
    }

    render () {
        return (
            <div id="col3">
                {this.isShowPlayers() && <TeamPlayers teamPlayers={this.props.teamPlayers} /> }
            </div>
        )
    }
}

export default connect(
    state => ({
        currentSelectedTeam: state.currentSelectedTeam,
        teamPlayers : state.teamPlayers
    }),
    dispatch => ({})
)(TeamPlayersContainer);