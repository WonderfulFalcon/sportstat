import React, { Component } from 'react';
import { connect } from 'react-redux';

import LeagueSelect from './../components/LeagueSelect';
import MatchDayContainer from './MatchDayContainer';
import HomeAwaySelect from './HomeAwaySelect';

class ControlsPanel extends Component {
    render () {
        return (
            <div className="leagueControls">
                {this.props.availableLeagues.length > 0 && <div className="controls">
                    <LeagueSelect availableLeagues={this.props.availableLeagues} />
                    <MatchDayContainer availableLeagues={this.props.availableLeagues} />
                    <HomeAwaySelect />
                </div>}
            </div>
        )
    }
}

export default connect(
    state => ({
        availableLeagues : state.availableLeagues
    }),
    dispatch => ({})
)(ControlsPanel);