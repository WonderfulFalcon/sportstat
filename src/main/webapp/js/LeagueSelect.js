import React, { Component } from 'react';
import { connect } from 'react-redux';
import { createStore } from 'redux';
import { store } from './main';
import { loadLeague } from './main';

class LeagueSelect extends Component {
    render () {
        return (
            <div>
                {this.props.availableLeagues.length > 0 &&
                    <select id="leagueInfo" onChange={ function() {
                            const selectedLeague = $("#leagueInfo").find(":selected");
                            const leagueId = selectedLeague.data("leagueId");
                            const matchDay = selectedLeague.data("toursPlayed");
                            loadLeague(leagueId, matchDay);
                        }
                    }>
                        {this.props.availableLeagues.map((league, index) =>
                            <LeagueItem key={league.id} league={league} />
                        )}
                    </select>
                }
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