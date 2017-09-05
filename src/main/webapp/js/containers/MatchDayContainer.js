import React, { Component } from 'react';
import { connect } from 'react-redux';

import MatchDaySelect from '../components/controls/MatchDaySelect';
import { loadLeague } from './../api/external-api';

class MatchDayContainer extends Component {
    render () {
        return (
            <MatchDaySelect
                availableLeagues={this.props.availableLeagues}
                leagueTable={this.props.leagueTable}
                loadLeague={loadLeague}
            />
        );
    }
}

export default connect(
    state => ({ leagueTable : state.leagueTable })
)(MatchDayContainer);