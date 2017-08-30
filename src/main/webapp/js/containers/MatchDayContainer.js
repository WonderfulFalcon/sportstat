import React, { Component } from 'react';
import { connect } from 'react-redux';

import MatchDaySelect from './../components/MatchDaySelect';

class MatchDayContainer extends Component {
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
                    <MatchDaySelect
                        matchDays={this.matchDays()}
                        selectedMatchDay={this.props.leagueTable.matchDay}
                        leagueId={this.props.leagueTable.id}
                    />
                }
            </div>
        );
    }
}

export default connect(
    state => ({ leagueTable : state.leagueTable })
)(MatchDayContainer);