import React, { Component } from 'react';
import { Provider } from 'react-redux';
import ReactDOM from 'react-dom';
import { store } from './main';

import LeagueSelect from './LeagueSelect';
import MatchDaySelect from './MatchDaySelect';

class ControlsPanel extends Component {
    renderSelect(select) {
        return (
            <Provider store={store}>
                {select}
            </Provider>)
    }

    render () {
        return (
            <div className="leagueControls">
                {this.renderSelect(<LeagueSelect />)}
                {this.renderSelect(<MatchDaySelect />)}
            </div>
        )
    }
}

export default ControlsPanel;