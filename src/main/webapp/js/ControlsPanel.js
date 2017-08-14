import React, { Component } from 'react';
import ReactDOM from 'react-dom';

import LeagueSelect from './LeagueSelect';
import MatchDaySelect from './MatchDaySelect';

class ControlsPanel extends Component {
    render () {
        return (
            <div className="leagueControls">
                <LeagueSelect />
                <MatchDaySelect />
            </div>
        )
    }
}

export default ControlsPanel;