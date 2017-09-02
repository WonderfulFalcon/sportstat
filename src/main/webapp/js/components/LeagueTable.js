import React, { Component } from 'react';
import { connect } from 'react-redux';

import LeagueTableHeader from './LeagueTableHeader';
import LeagueTableBody from './LeagueTableBody';

class LeagueTable extends Component {
    render () {
        return (
            <div id='col2'>
                {!($.isEmptyObject(this.props.leagueTable)) && <table className="leagueTable">
                    <LeagueTableHeader tableName={this.props.leagueTable.name} />
                    <LeagueTableBody teams={this.props.leagueTable.table.teams}
                                     homeAwayState={this.props.homeAwayState}
                        />
                </table>}
            </div>
        )
    }
}

export default LeagueTable;