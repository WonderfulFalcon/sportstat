import React, { Component } from 'react';

import Header from './Header';
import ControlsPanel from './../containers/ControlsPanel';
import LeagueTable from './../containers/LeagueTable';
import LoadLeague from './../containers/LoadLeague';
import TeamPlayers from './../containers/TeamPlayers';
import TourSummaryContainer from '../containers/TourSummaryContainer';
import Loading from './../containers/Loading';

class App extends Component {
    render() {
        return (
            <div>
                <Header />
                <ControlsPanel />
                <Loading />
                <LoadLeague />
                <TourSummaryContainer />
                <LeagueTable />
                <TeamPlayers />
            </div>
        );
    }
}

export default App;