import React, { Component } from 'react';
import { connect } from 'react-redux';
import { createStore } from 'redux';
import { store } from './main';

class LeagueSelect extends Component {
    leagueChanged(event) {
        let leagueId = $(event.target).find(":selected").data("leagueId");
        let matchDay = $(event.target).find(":selected").data("toursPlayed");
        let shortName = $(event.target).find(":selected").data("shortName");

        let data = new FormData();
        data.append("leagueId", leagueId);
        data.append("matchDay", matchDay);

        fetch('/league', { method: 'post', body: data })
            .then(response => response.json())
            .then(json => store.dispatch({type : "LOAD_TABLES", payload: json }));

        store.dispatch({type : "LOAD_LEAGUE_TABLE", payload: shortName });
    }

    render () {
        return (
            <div>
                <select id="leagueInfo" onChange={this.leagueChanged}>
                    {this.props.availableLeagues.map((league, index) =>
                        <LeagueItem key={league.id} league={league} />
                    )}
                </select>
            </div>
        )
    }
}

class LeagueItem extends Component {
    render () {
        return (
            <option key={this.props.league.id} data-league-id={this.props.league.id}
                    data-tours-played={this.props.league.toursPlayed}
                    data-short-name={this.props.league.shortName}>
                {this.props.league.name}
            </option>
        )
    }
}

export default connect(
        state => ({
            availableLeagues : state.availableLeagues
        }),
        dispatch => ({})
)(LeagueSelect);