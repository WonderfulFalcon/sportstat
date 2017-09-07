import React, { Component } from 'react';
import LeagueTableHeader from './LeagueTableHeader';
import LeagueTableBody from './LeagueTableBody';

export default class LeagueTable extends Component {
    render () {
        return (
            <div id='col2'>
                {!($.isEmptyObject(this.props.leagueTable)) && <table className="leagueTable">
                    <LeagueTableHeader tableName={this.props.leagueTable.name} />
                    <LeagueTableBody teams={this.props.leagueTable.teams}
                                     homeAwayState={this.props.homeAwayState}
                    />
                </table>}
            </div>
        )
    }
}