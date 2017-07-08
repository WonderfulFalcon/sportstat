import React, { Component } from 'react';
import { Provider } from 'react-redux';
import ReactDOM from 'react-dom';

import { store } from './main';

import LeagueSelect from './LeagueSelect';

class ControlsPanel extends Component {
    renderLeagueSelect() {
        return (
            <Provider store={store}>
                <LeagueSelect />
            </Provider>
        );
    }

    render () {
        return (
            <div>
                {this.renderLeagueSelect()}
            </div>
        )
    }
}

export default ControlsPanel;