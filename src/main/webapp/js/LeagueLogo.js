import React, { Component } from 'react';
import { connect } from 'react-redux';
import { createStore } from 'redux';
import { store } from './main';

class LeagueLogo extends Component {
    imagePath (name) {
        return "/images/League/" + name + ".svg";
    }

    render() {
        return (<div className="club-logo">
            <img src={ this.imagePath(this.props.shortName) } />
        </div>)
    }
}

export default connect(
    state => ({
        shortName : state.leagueLogo
    }),
    dispatch => ({})
)(LeagueLogo);