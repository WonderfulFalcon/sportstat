import React, { Component } from 'react';
import PropTypes from 'prop-types';

import LeagueTableHeader from './LeagueTableHeader';
import LeagueTableBody from './LeagueTableBody';

export default class LeagueTable extends Component {
    render () {
        return (
            <div id='col2'>
                {!($.isEmptyObject(this.props.leagueTable)) &&
                    <table className="leagueTable">
                        <LeagueTableHeader
                            tableName={this.props.leagueTable.name}
                            shortName={this.props.selectedLeague.shortName}
                        />

                        <LeagueTableBody
                            teams={this.props.leagueTable.table.teams}
                            homeAwayState={this.props.homeAwayState}
                        />
                    </table>
                }
            </div>
        )
    }
}

LeagueTable.propTypes = {
    leagueTable : PropTypes.object,
    homeAwayState : PropTypes.oneOf(['Home', 'Away', 'All']),
    selectedLeague : PropTypes.object
};