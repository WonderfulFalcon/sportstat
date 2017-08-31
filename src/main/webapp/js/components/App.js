import React, { Component } from 'react';

import Header from './Header';
import ControlsPanel from './../containers/ControlsPanel';
import LeagueTableContainer from '../containers/LeagueTableContainer';
import LoadLeague from './../containers/LoadLeague';
import TeamPlayers from '../containers/TeamPlayersContainer';
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
                <LeagueTableContainer />
                <TeamPlayers />
            </div>
        );
    }
}

export default App;