import React, { Component } from 'react';
import PropTypes from 'prop-types';

export default class LeagueSelectItem extends Component {
    render () {
        return (
            <option value={this.props.leagueId} >
                {this.props.leagueName}
            </option>
        )
    }
}

LeagueSelectItem.propTypes = {
    leagueId : PropTypes.number,
    leagueName : PropTypes.string
};