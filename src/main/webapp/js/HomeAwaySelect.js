import React, {Component} from 'react';
import { store } from './main.js';

import { connect } from 'react-redux';
import { changeHomeAway } from './actions/actions.js';

class HomeAwaySelect extends Component {
    render () {
        return (
            <div>
                <select id="homeAwaySelect" onChange={
                    (e) => this.props.homeAway($(e.target).find(":selected").val())
                 }>
                    <option key="1">
                        All
                    </option>
                    <option key="2">
                        Home
                    </option>
                    <option key="3">
                        Away
                    </option>
                </select>
            </div>
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
)(HomeAwaySelect);