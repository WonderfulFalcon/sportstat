import React, { Component } from 'react';
import { connect } from 'react-redux';
import { createStore } from 'redux';
import { store } from './main';

import { loadLeague } from './main';

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