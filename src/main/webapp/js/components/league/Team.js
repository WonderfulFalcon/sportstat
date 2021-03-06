import React, { Component } from 'react';
import PropTypes from 'prop-types';

import TeamName from './TeamName';
import HistoryVidget from './HistoryVidget';

export default class Team extends Component {
    getStyle (teamId) {
        return this.props.currentSelectedTeam.teamId === teamId ?
            "teamColumn selected" :
            "teamColumn"
    }

    getTable () {
        const homeAway = this.props.homeAwayState;
        if (homeAway === "Home") {
            return this.props.team.homeStatistic;
        } else if (homeAway === "Away") {
            return this.props.team.awayStatistic;
        }
        return this.props.team.allStatistic;
    }

    static checkedValue (value) {
        return (value === null || value === undefined) ? "-" : value;
    }

    render () {
        const table = this.getTable();
        return (
            <tr>
                <td><span>{this.props.position}</span></td>
                <td className={this.getStyle(this.props.team.id)} onClick={this.props.onTeamClick}>
                    <TeamName teamName={this.props.team.name} />
                </td>
                <td><span>{Team.checkedValue(table.playedGames)}</span></td>
                <td><span>{Team.checkedValue(table.wins)}</span></td>
                <td><span>{Team.checkedValue(table.draws)}</span></td>
                <td><span>{Team.checkedValue(table.losses)}</span></td>
                <td><span>{Team.checkedValue(table.goalsScored)}</span></td>
                <td><span>{Team.checkedValue(table.goalsAgainst)}</span></td>
                <td><span>{Team.checkedValue(table.goalsDifference)}</span></td>
                <td><span><b>{Team.checkedValue(table.points)}</b></span></td>
                <td><HistoryVidget history={this.props.teamHistory} /></td>
            </tr>
        );
    }
}

Team.propTypes = {
    currentSelectedTeam : PropTypes.object,
    homeAwayState : PropTypes.oneOf(['Home', 'Away', 'All']),
    team : PropTypes.object,
    position : PropTypes.number,
    teamHistory : PropTypes.object
};