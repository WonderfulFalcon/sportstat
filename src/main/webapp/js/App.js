import React, { Component } from 'react';
import { connect } from 'react-redux';
import ReactDOM from 'react-dom';
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
                <LeagueLogo />
                <LeagueTable />
            </div>
        );
    }
}

export default App;