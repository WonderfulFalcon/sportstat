import React, { Component } from 'react';
import { connect } from 'react-redux';

import LeagueTableHeader from './../components/LeagueTableHeader';
import LeagueTable from './../components/LeagueTable';

class LeagueTableContainer extends Component {
    render () {
        return (
            <div id='col2'>
                {!($.isEmptyObject(this.props.leagueTable)) && <table className="leagueTable">
                    <LeagueTableHeader tableName={this.props.leagueTable.name} />
                    <LeagueTable teams={this.props.leagueTable.table.teams}
                                 homeAwayState={this.props.homeAwayState}
                    />
                </table>}
            </div>
        )
    }
}

export default connect(
    state => ({
        leagueTable : state.leagueTable,
        homeAwayState : state.homeAwayState
    }),
    dispatch => ({})
)(LeagueTableContainer);