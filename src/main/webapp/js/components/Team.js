import React, { Component } from 'react';
import TeamName from './TeamName';

class Team extends Component {
    getStyle (teamId) {
        return this.props.currentSelectedTeam.teamId === teamId ?
            "teamColumn selected" :
            "teamColumn"
    }

    getTable () {
        const homeAway = this.props.homeAwayState;
        if (homeAway == "Home") {
            return this.props.team.homeStatistic;
        } else if (homeAway == "Away") {
            return this.props.team.awayStatistic;
        }
        return this.props.team.allStatistic;
    }

    checkedValue (value) {
        return value ? value : "-";
    }

    render () {
        const table = this.getTable();
        return (
            <tr>
                <td><span>{this.checkedValue(table.position)}</span></td>
                <td className={this.getStyle(this.props.team.id)} onClick={this.props.onTeamClick}>
                    <TeamName teamName={this.props.team.name} />
                </td>
                <td><span>{this.checkedValue(table.playedGames)}</span></td>
                <td><span>{this.checkedValue(table.wins)}</span></td>
                <td><span>{this.checkedValue(table.draws)}</span></td>
                <td><span>{this.checkedValue(table.losses)}</span></td>
                <td><span>{this.checkedValue(table.goalsScored)}</span></td>
                <td><span>{this.checkedValue(table.goalsAgainst)}</span></td>
                <td><span>{this.checkedValue(table.goalsDifference)}</span></td>
                <td><span><b>{this.checkedValue(table.points)}</b></span></td>
            </tr>
        );
    }
}

export default Team;