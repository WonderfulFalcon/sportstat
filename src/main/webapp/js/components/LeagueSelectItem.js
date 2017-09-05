import React, { Component } from 'react';

export default class LeagueSelectItem extends Component {
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