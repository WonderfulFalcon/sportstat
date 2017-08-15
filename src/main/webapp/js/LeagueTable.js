import React, { Component } from 'react';
import { connect } from 'react-redux';
import { loadPlayers } from './main';
import LeagueLogo from './LeagueLogo';

class LeagueTable extends Component {
    tables () {
        let tables = this.props.leagueTable.tables;
        return tables ? tables : [];
    }

    render () {
        return (
            <div id='col2'>
                {this.tables().map((table, index) =>
                    <table className="leagueTable" key={index}>
                            <TableHeader tableName={table.name} />
                            <TableBody teams={table.teams} />
                    </table>
                )}
            </div>
        )
    }
}

class TableHeader extends Component {
    leagueShortName () {
        return $("#leagueInfo").find(":selected").data("shortName");
    }

    render () {
        return (
            <thead>
                <tr>
                    <th>
                        <LeagueLogo shortName={this.leagueShortName()} />
                    </th>
                    <th>
                        <span id="tableNameHeader">
                            {this.props.tableName}
                        </span>
                    </th>
                </tr>
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
        return "/images/Clubs/" + name + ".svg";
    }

    render () {
        return (
            <tbody>
            {this.props.teams.map((team, index) =>
                <tr key={index}>
                    <td><span>{team.statistic.position}</span></td>
                    <td className="teamColumn" data-clickable-team={team.id} onClick={function (event) {
                        $('.selected').removeClass('selected');
                        $(event.target).closest('td').addClass('selected');
                        loadPlayers(team.id);
                    }}>
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