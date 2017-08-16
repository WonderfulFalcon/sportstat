import React, { Component } from 'react';
import { connect } from 'react-redux';
import { createStore } from 'redux';
import { store } from './main';

class Loading extends Component {
    render () {
        return (
            <div class="loading-gif-container">
                {this.props.first_loading &&
                        <img src="/images/loading_football.gif" />}
            </div>
        );
    }
}

export default connect(
    state => ({ first_loading : state.loading }),
    dispatch => ({})
)(Loading);