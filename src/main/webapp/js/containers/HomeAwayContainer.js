import React, {Component} from 'react';
import { connect } from 'react-redux';
import { changeHomeAway } from './../actions/actions.js';

import HomeAwaySelect from './../components/HomeAwaySelect';


class HomeAwayContainer extends Component {
    render () {
        return (
            <HomeAwaySelect homeAway={this.props.homeAway} />
        )
    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        homeAway : (value) => dispatch(changeHomeAway(value))
    };
};

export default connect(
    state => ({}),
    mapDispatchToProps
)(HomeAwayContainer);