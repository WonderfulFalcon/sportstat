import React, { Component } from 'react';
import ReactDOM from 'react-dom';

import Header from './Header';
import ControlsPanel from './ControlsPanel';
import LeagueTable from './LeagueTable';
import LoadLeague from './LoadLeague';
import TeamPlayers from './TeamPlayers';
import LeagueInfo from './LeagueInfo';
import Loading from './Loading';

class App extends Component {
    render() {
        return (
            <div>
                <Header />
                <ControlsPanel />
                <Loading />
                <LoadLeague />
                <LeagueInfo />
                <LeagueTable />
                <TeamPlayers />
            </div>
        );
    }
}

export default App;