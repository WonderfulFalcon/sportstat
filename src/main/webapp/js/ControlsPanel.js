import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import { connect } from 'react-redux';

import LeagueSelect from './LeagueSelect';
import MatchDaySelect from './MatchDaySelect';
import HomeAwaySelect from './HomeAwaySelect';

class ControlsPanel extends Component {
    render () {
        return (
            <div className="leagueControls">
                {this.props.availableLeagues.length > 0 && <div className="controls">
                    <LeagueSelect availableLeagues={this.props.availableLeagues} />
                    <MatchDaySelect />
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