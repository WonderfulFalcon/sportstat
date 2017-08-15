import React, { Component } from 'react';
import ReactDOM from 'react-dom';

import { loadLeague } from './main';

class MatchDaySelect extends Component {
    toursPlayed () {
        const league = this.props.availableLeagues[0];
        return league ? league.toursPlayed : 0;
    }

    matchDays () {
        let matchDays = [];
        for (var i = 1; i < this.toursPlayed() + 1; i++) {
            matchDays.push(i);
        }
        return matchDays;
    }

    render () {
        return (
            <div>
                <select id="matchDay" name="Match Day" onChange={ function() {
                        const selectedLeague = $("#leagueInfo").find(":selected");
                        const leagueId = selectedLeague.data("leagueId");

                        const matchDay = $("#matchDay").find(":selected").val();
                        loadLeague(leagueId, matchDay);
                    }
                }>
                    {this.matchDays().map((item, count) =>
                        <MatchDayOption matchday={item} />
                    )}
                </select>
            </div>
        );
    }
}

class MatchDayOption extends Component {
    render () {
        return (
            <option key={this.props.matchday}>
                {this.props.matchday}
            </option>
        );
    }
}

export default MatchDaySelect;