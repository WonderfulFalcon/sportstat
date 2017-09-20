import React, { Component } from 'react';
import PropTypes from 'prop-types';

import LeagueSelectItem from './LeagueSelectItem';

export default class LeagueSelect extends Component {
    handleSelectLeague (event) {
        const selected = event.target.options[event.target.selectedIndex];
        const id = selected.value;

        const selectedLeague = this.props.availableLeagues
            .find((league) => league.id === id);

        this.props.selectTeam();
        this.props.loadLeague(id, selectedLeague['toursPlayed']);
        this.props.selectLeague(selectedLeague);
    }

    render () {
        return (
            <div>
                <select id="leagueInfo" onChange={(e) => { this.handleSelectLeague.bind(this)(e) }}>
                    {this.props.availableLeagues.map((league) =>
                        <LeagueSelectItem
                            key={league.id}
                            leagueId={league.id}
                            leagueName={league.name}
                        />
                    )}
                </select>
            </div>
        )
    }
}

LeagueSelect.PropTypes = {
    availableLeagues : PropTypes.array,
    selectTeam : PropTypes.func,
    loadLeague : PropTypes.func,
    selectLeague : PropTypes.func
};