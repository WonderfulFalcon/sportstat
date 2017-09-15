import React, { Component } from 'react';
import PropTypes from 'prop-types';
import {isEmpty} from 'underscore';

export default class Loading extends Component {
    render () {
        return (
            <div>
                {isEmpty(this.props.leagueTable) &&
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