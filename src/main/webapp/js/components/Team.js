import React, { Component } from 'react';
import TeamName from './TeamName';

class Team extends Component {
    getStyle (teamId) {
        return this.props.currentSelectedTeam.teamId === teamId ?
            "teamColumn selected" :
            "teamColumn"
    }

    render () {
        const team = this.props.team;
        return (
            <tr>
                <td><span>{team.allStatistic.position}</span></td>
                <td className={this.getStyle(team.id)} onClick={this.props.onTeamClick}>
                    <TeamName teamName={team.name} />
                </td>
                <td><span>{team.allStatistic.playedGames}</span></td>
                <td><span>{team.allStatistic.wins}</span></td>
                <td><span>{team.allStatistic.draws}</span></td>
                <td><span>{team.allStatistic.losses}</span></td>
                <td><span>{team.allStatistic.goalsScored}</span></td>
                <td><span>{team.allStatistic.goalsAgainst}</span></td>
                <td><span>{team.allStatistic.goalsDifference}</span></td>
                <td><span><b>{team.allStatistic.points}</b></span></td>
            </tr>
        );
    }
}

export default Team;