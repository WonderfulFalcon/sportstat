import React, { Component } from 'react';

import TeamContainer from './../containers/TeamContainer';
import MainTableHandler from './../logic/MainTableHandler';

class LeagueTableBody extends Component {
    render () {
        const tableHandler = new MainTableHandler(
            this.props.teams,
            this.props.homeAwayState);

        tableHandler.convertTable();

        return (
            <tbody>
                {this.props.teams.map((team, index) =>
                    <TeamContainer position={index + 1}
                                   team={team}
                                   homeAwayState={this.props.homeAwayState}
                                   key={index}
                    />
                )}
            </tbody>
        )
    }
}

export default LeagueTableBody;