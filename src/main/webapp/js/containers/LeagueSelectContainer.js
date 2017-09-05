import React, { Component } from 'react';

import { loadLeague } from "../api/external-api";
import LeagueSelect from "../components/controls/LeagueSelect";
import { selectTeam, selectLeague } from "../api/user-api";

export default class LeagueSelectContainer extends Component {
    render () {
        return (
            <LeagueSelect
                availableLeagues={this.props.availableLeagues}
                loadLeague={loadLeague}
                selectTeam={selectTeam}
                selectLeague={selectLeague}
            />
        )
    }
}