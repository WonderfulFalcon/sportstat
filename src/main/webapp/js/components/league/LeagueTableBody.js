import React, { Component } from 'react';
import PropTypes from 'prop-types';
import {filter} from 'underscore';

import TeamContainer from '../../containers/TeamContainer';
import MainTableHandler from '../../logic/MainTableHandler';

export default class LeagueTableBody extends Component {
    getTeamHistory(teamId) {
        return filter(this.props.history, function(h) {
            return h.teamId == teamId;
        })[0];
    }

    render () {
        const tableHandler = new MainTableHandler(
            this.props.teams,
            this.props.homeAwayState);

        tableHandler.convertTable();

        return (
            <tbody>
                {this.props.teams.map((team, index) =>
                    <TeamContainer
                        position={index + 1}
                        team={team}
                        homeAwayState={this.props.homeAwayState}
                        key={index}
                        teamHistory={this.getTeamHistory(team.id)}
                    />
                )}
            </tbody>
        )
    }
}

LeagueTableBody.propTypes = {
    teams : PropTypes.array,
    homeAwayState : PropTypes.oneOf(['Home', 'Away', 'All'])
};