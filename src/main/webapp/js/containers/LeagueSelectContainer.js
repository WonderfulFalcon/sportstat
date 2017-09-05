import React, { Component } from 'react';

import { loadLeague } from "../api/external-api";
import LeagueSelect from "../components/LeagueSelect";
import { selectTeam } from "../api/user-api";

export default class LeagueSelectContainer extends Component {
    render () {
        return (
            <LeagueSelect
                availableLeagues={this.props.availableLeagues}
                loadLeague={loadLeague}
                selectTeam={selectTeam}
            />
        )
    }
}
