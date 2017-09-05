import React, { Component } from 'react';
import PropTypes from 'prop-types';

export default class LeagueSelectItem extends Component {
    render () {
        return (
            <option value={this.props.league.id} data-short-name={this.props.league.shortName}>
                {this.props.league.name}
            </option>
        )
    }
}

LeagueSelectItem.PropTypes = {
    league : PropTypes.object
};