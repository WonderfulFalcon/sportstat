import React, { Component } from 'react';
import { connect } from 'react-redux';
import { loadLeague } from './../api/external-api';

class LoadLeague extends Component {
    loadFirst () {
        const firstLeague = this.props.availableLeagues[0];
        if (firstLeague) {
            loadLeague(firstLeague.id, firstLeague.toursPlayed);
        }
    }

    render () {
        return (
            <div>
                {this.loadFirst()}
            </div>
        );
    }
}

export default connect(
        state => ({ availableLeagues : state.availableLeagues }),
        dispatch => ({})
)(LoadLeague);