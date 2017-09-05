import React, { Component } from 'react';

import Header from './Header';
import ControlsPanel from './../containers/ControlsPanel';
import LeagueTableContainer from '../containers/LeagueTableContainer';
import TeamPlayers from '../containers/TeamPlayersContainer';
import TourSummaryContainer from '../containers/TourSummaryContainer';
import LoadingContainer from '../containers/LoadingContainer';

export default class App extends Component {
    render() {
        return (
            <div>
                <Header />
                <ControlsPanel />
                <LoadingContainer />
                <TourSummaryContainer />
                <LeagueTableContainer />
                <TeamPlayers />
            </div>
        );
    }
}