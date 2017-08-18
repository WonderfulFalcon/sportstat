import React, { Component } from 'react';
import { connect } from 'react-redux';
import { loadPlayers } from './../main';
import LeagueLogo from './../components/LeagueLogo';
import TeamName from './../components/TeamName';

class LeagueTable extends Component {
    tableIsAvailable () {
        return this.props.homeAwayState == "All" &&
            this.props.leagueTable.tables;
    }

    render () {
        return (
            <div id='col2'>
                {this.tableIsAvailable() && this.props.leagueTable.tables.map((table, index) =>
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
                        <span className="table-name-header">
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
    render () {
        $('.teamColumn.selected').removeClass('selected');
        return (
            <tbody>
            {this.props.teams.map((team, index) =>
                <tr key={index}>
                    <td><span>{team.statistic.position}</span></td>
                    <td className="teamColumn" data-clickable-team={team.id} onClick={function () {
                         $('.teamColumn.selected').removeClass('selected');
                         $('[data-clickable-team=' + team.id + ']').addClass('selected');
                        loadPlayers(team.id, team.name);
                    }}>
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
            )}
            </tbody>
        )
    }
}

export default connect(
        state => ({
            leagueTable : state.leagueTable,
            homeAwayState : state.homeAwayState
        }),
        dispatch => ({})
)(LeagueTable);