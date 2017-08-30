import React, { Component } from 'react';
import { connect } from 'react-redux';

import LeagueSelect from './../components/LeagueSelect';
import MatchDayContainer from './MatchDayContainer';
import HomeAwayContainer from './HomeAwayContainer';

class ControlsPanel extends Component {
    render () {
        return (
            <div className="leagueControls">
                {this.props.availableLeagues.length > 0 && <div className="controls">
                    <LeagueSelect availableLeagues={this.props.availableLeagues} />
                    <MatchDayContainer availableLeagues={this.props.availableLeagues} />
                    <HomeAwayContainer />
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