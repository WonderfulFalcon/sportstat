import React, { Component } from 'react';
import { connect } from 'react-redux';
import LeagueLogo from './../components/LeagueLogo';
import TeamContainer from './TeamContainer';

class LeagueTable extends Component {
    render () {
        return (
            <div id='col2'>
                {!($.isEmptyObject(this.props.leagueTable)) && <table className="leagueTable">
                    <TableHeader tableName={this.props.leagueTable.name} />
                    <TableBody teams={this.props.leagueTable.table.teams} />
                </table>}
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
        return (
            <tbody>
                {this.props.teams.map((team, index) =>
                    <TeamContainer team={team} key={index}/>
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