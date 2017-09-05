import React, { Component } from 'react';
import PropTypes from 'prop-types';

export default class Loading extends Component {
    render () {
        return (
            <div>
                {$.isEmptyObject(this.props.leagueTable) &&
                    <div className="loading-gif-container">
                        <img src="/images/loading_football.gif" />
                    </div>
                }
            </div>
        )
    }
}

Loading.propTypes = {
    leagueTable : PropTypes.object
};