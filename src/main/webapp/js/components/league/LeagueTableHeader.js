import React, { Component } from 'react';
import PropTypes from 'prop-types';

import LeagueLogo from './LeagueLogo';

export default class LeagueTableHeader extends Component {
    render () {
        return (
            <thead>
                <tr>
                    <th>
                        <LeagueLogo shortName={this.props.shortName} />
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

LeagueTableHeader.propTypes = {
    tableName : PropTypes.string,
    shortName : PropTypes.string
};