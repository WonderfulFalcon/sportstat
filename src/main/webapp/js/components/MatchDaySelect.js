import React, { Component } from 'react';

import { loadLeague } from './../main';

class MatchDaySelect extends Component {
    selectOnChange () {
        return (event) => {
            const matchDay = parseInt(event.target.options[event.target.selectedIndex].value);
            const leagueId = this.props.leagueId;

            loadLeague(leagueId, matchDay);
        }
    }

    render () {
        return (
            <select id="matchDay" value={this.props.selectedMatchDay} onChange={ this.selectOnChange() }>
                {this.props.matchDays.map((item) =>
                    <option key={item} value={item}>
                        {item}
                    </option>
                )}
            </select>
        )
    }
}

export default MatchDaySelect;