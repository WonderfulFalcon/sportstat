import React, { Component } from 'react';
import { connect } from 'react-redux';

import LeagueSelectContainer from './LeagueSelectContainer';
import MatchDayContainer from './MatchDayContainer';
import HomeAwayContainer from './HomeAwayContainer';
import LocalizeBoxContainer from './LocalizeBoxContainer';

class ControlsPanel extends Component {
    render () {
        return (
            <div className="leagueControls">
                {this.props.availableLeagues.length > 0 && <div className="controls">
                    <LeagueSelectContainer availableLeagues={this.props.availableLeagues} />
                    <MatchDayContainer availableLeagues={this.props.availableLeagues} />
                    <HomeAwayContainer />
                    <LocalizeBoxContainer />
                </div>}
            </div>
        )
    }
}

const mapStateToProps = (state) => {
    return {
        availableLeagues : state.availableLeagues
    };
};

export default connect(mapStateToProps)(ControlsPanel);