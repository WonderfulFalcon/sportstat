import React, { Component } from 'react';
import TeamName from './TeamName';

class Team extends Component {
    render () {
        let team = this.props.team;
        return (
            <tr>
                <td><span>{team.statistic.position}</span></td>
                <td className="teamColumn" data-clickable-team={team.id} onClick={this.props.onTeamClick}>
                    <TeamName teamName={team.name}/>
                </td>
                <td><span>{team.statistic.playedGames}</span></td>
                <td><span>{team.statistic.wins}</span></td>
                <td><span>{team.statistic.draws}</span></td>
                <td><span>{team.statistic.losses}</span></td>
                <td><span>{team.statistic.goalsScored}</span></td>
                <td><span>{team.statistic.goalsAgainst}</span></td>
                <td><span>{team.statistic.goalsDifference}</span></td>
                <td><span><b>{team.statistic.points}</b></span></td>
            </tr>
        );
    }
}

export default Team;