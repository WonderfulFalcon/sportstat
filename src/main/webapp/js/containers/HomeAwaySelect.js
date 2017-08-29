import React, {Component} from 'react';
import { store } from './../main.js';

import { connect } from 'react-redux';
import { changeCurrentState } from './../actions/actions.js';

class HomeAwaySelect extends Component {
    render () {
        return (
            <div>
                <select id="homeAwaySelect" onChange={
                    (e) => {
                        const selected = $(e.target).find(":selected").val();
                        this.props.currentState(selected);
                    }
                 }>
                    <option key="1">All</option>
                    <option key="2">Home</option>
                    <option key="3">Away</option>
                </select>
            </div>
        )
    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        currentState : (value) => dispatch(changeCurrentState("homeAwayState", value))
    };
};

export default connect(
    state => ({}),
    mapDispatchToProps
)(HomeAwaySelect);