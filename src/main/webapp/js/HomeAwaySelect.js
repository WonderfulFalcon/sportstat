import React, {Component} from 'react';
import { connect } from 'react-redux';
import { changeHomeAway } from './actions/mainPageActions.js';

class HomeAwaySelect extends Component {
    homeAway () {
        return this.props.store.dispatch(
            changeHomeAway(
                $("#leagueInfo").find(":selected").val()
            )
        );
    }

    render () {
        return (
            <div>
                <select id="homeAwaySelect" onChange={(e) => this.homeAway() }>
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

const mapDispatchToProps = () => {
    return {
        changeHomeAway: changeHomeAway
    };
};

export default connect(
    state => ({store : state}),
    mapDispatchToProps
)(HomeAwaySelect);