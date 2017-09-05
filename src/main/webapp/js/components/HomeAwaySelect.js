import React, { Component } from 'react';
import PropTypes from 'prop-types';

export default class HomeAwaySelect extends Component {
    homeAwayChange () {
        return (event) => {
            const selectedIndex = event.target.selectedIndex;
            return this.props.homeAway(
                event.target.options[selectedIndex].text);
        }
    }

    render () {
        return (
            <div>
                <select id="homeAwaySelect" onChange={ this.homeAwayChange()}>
                    <option key="1">All</option>
                    <option key="2">Home</option>
                    <option key="3">Away</option>
                </select>
            </div>
        )
    }
}

HomeAwaySelect.PropTypes = {
    homeAway : PropTypes.func
};