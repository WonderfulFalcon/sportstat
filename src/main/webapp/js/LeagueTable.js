import React, { Component } from 'react';
import { connect } from 'react-redux';

class LeagueTable extends Component {
    tables () {
        let tables = this.props.leagueTable.tables;
        return tables ? tables : [];
    }

    render () {
        return (
            <div id='col2'>
                {this.tables().map((table, index) =>
                    <div>
                        <h3>{table.name}</h3>
                        <table key={index}>
                            <TableHeader />
                            <TableBody teams={table.teams} />
                        </table>
                    </div>
                )}
            </div>
        )
    }
}

class TableHeader extends Component {
    render () {
        return (
            <thead>
                <tr>
                    <th><span>Pos.</span></th>
                    <th><span>Team</span></th>
                    <th><span>P</span></th>
                    <th><span>W</span></th>
                    <th><span>D</span></th>
                    <th><span>L</span></th>
                    <th><span>GS</span></th>
                    <th><span>GA</span></th>
                    <th><span>GD</span></th>
                    <th><span>Points</span></th>
                </tr>
            </thead>
        );
    }
}

class TableBody extends Component {
    imagePath (name) {
        return "/images/clubs/England/" + name + ".svg";
    }

    render () {
        return (
            <tbody>
            {this.props.teams.map((team, index) =>
                <tr key={index}>
                    <td><span>{team.statistic.position}</span></td>
                    <td className="teamColumn" data-clickable-team={team.id}>
                        <div className="club-logo">
                            <img src={this.imagePath(team.name)} />
                        </div>
                        <div className="team-name">
                            <span>{team.name}</span>
                        </div>
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
            )}
            </tbody>
        )
    }
}

export default connect(
        state => ({ leagueTable : state.leagueTable }),
        dispatch => ({})
)(LeagueTable);