import React, { Component } from 'react';

export default class MatchDaySelect extends Component {
    handleOnChange (event) {
        const matchDay = parseInt(event.target.options[event.target.selectedIndex].value);
        const leagueId = this.props.leagueTable.id;
        return this.props.loadLeague(leagueId, matchDay);
    }

    currentMatchDay() {
        return this.props.availableLeagues.find((league) => {
            return league.id === this.props.leagueTable.id;
        }).toursPlayed;
    };

    matchDays() {
        let matchDays = [];
        for (let matchDay = 1; matchDay < this.currentMatchDay() + 1; matchDay++) {
            matchDays.push(matchDay);
        }
        return matchDays;
    }

    render () {
        return (
            <div>
                {!$.isEmptyObject(this.props.leagueTable) &&
                    <select
                        id="matchDay"
                        value={this.props.leagueTable.matchDay}
                        onChange={(e) => this.handleOnChange(e)}
                    >
                        {this.matchDays().map((item) =>
                            <option key={item} value={item}>
                                {item}
                            </option>
                        )}
                    </select>
                }
            </div>
        )
    }
}