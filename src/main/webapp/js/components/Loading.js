import React, { Component } from 'react';
import PropTypes from 'prop-types';
import {isEmpty} from 'underscore';

export default class Loading extends Component {
    render () {
        return (
            <div className="loading-gif-container">
                {isEmpty(this.props.leagueTable) &&
                    <div className="mdl-spinner mdl-js-spinner is-active">
                    </div>
                }
            </div>
        )
    }
}

Loading.propTypes = {
    leagueTable : PropTypes.object
};