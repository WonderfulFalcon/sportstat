import React, { Component } from 'react';
import ReactDOM from 'react-dom';

import Header from './Header';
import ControlsPanel from './../containers/ControlsPanel';
import LeagueTable from './../containers/LeagueTable';
import LoadLeague from './../containers/LoadLeague';
import HomeAwayTable from './../containers/HomeAwayTable';
import TeamPlayers from './../containers/TeamPlayers';
import LeagueInfo from './../containers/LeagueInfo';
import Loading from './../containers/Loading';

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
                <HomeAwayTable />
                <TeamPlayers />
            </div>
        );
    }
}

export default App;