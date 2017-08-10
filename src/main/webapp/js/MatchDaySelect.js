import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import { connect } from 'react-redux';

class MatchDaySelect extends Component {
    toursPlayed () {
        const league = this.props.leagueTable;
        return league ? league.matchDay : 0
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
                <select id="matchDay" name="Match Day">
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

export default connect(
        state => ({ leagueTable : state.leagueTable }),
        dispatch => ({})
)(MatchDaySelect);