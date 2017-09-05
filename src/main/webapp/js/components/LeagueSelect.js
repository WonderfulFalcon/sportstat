import React, { Component } from 'react';
import PropTypes from 'prop-types';


import LeagueSelectItem from './LeagueSelectItem';

export default class LeagueSelect extends Component {
    handleSelectLeague () {
        const selectedLeague = $("#leagueInfo").find(":selected");
        const leagueId = selectedLeague.data("leagueId");
        const matchDay = selectedLeague.data("toursPlayed");

        this.props.selectTeam();
        this.props.loadLeague(leagueId, matchDay);
    }

    render () {
        return (
            <div>
                <select id="leagueInfo" onChange={ this.handleSelectLeague.bind(this) }>
                    {this.props.availableLeagues.map((league, index) =>
                        <LeagueSelectItem key={league.id} league={league} />
                    )}
                </select>
            </div>
        )
    }
}

LeagueSelect.PropTypes = {
    availableLeagues : PropTypes.array,
    selectTeam : PropTypes.func,
    loadLeague : PropTypes.func
};