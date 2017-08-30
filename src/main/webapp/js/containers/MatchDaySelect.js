import React, { Component } from 'react';
import { connect } from 'react-redux';

import { loadLeague } from './../main';

class MatchDaySelect extends Component {
    currentMatchDay() {
        const leagueInfo = this.props.availableLeagues.find((league) => {
            return league.id === this.props.leagueTable.id;
        });
        return leagueInfo ? leagueInfo['toursPlayed'] : 0;
    }

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
                    <Select
                        matchDays={this.matchDays()}
                        selectedMatchDay={this.props.leagueTable.matchDay}
                        leagueId={this.props.leagueTable.id}
                    />
                }
            </div>
        );
    }
}

class Select extends Component {
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

export default connect(
    state => ({ leagueTable : state.leagueTable })
)(MatchDaySelect);