import React, { Component } from 'react';
import { connect } from 'react-redux';
import ReactDOM from 'react-dom';
import { Provider } from 'react-redux';
import { store } from './main';

import Header from './Header';
import Gutter from './Gutter';
import ControlsPanel from './ControlsPanel';
import LeagueTable from './LeagueTable';
import LeagueLogo from './LeagueLogo';

class App extends Component {
    render() {
        return (
            <div>
                <Header />
                <Gutter />
                <ControlsPanel />

                <Provider store={store}>
                    <LeagueLogo />
                    <LeagueTable />
                </Provider>
            </div>
        );
    }
}

export default App;