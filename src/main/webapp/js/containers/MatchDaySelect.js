import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import { connect } from 'react-redux';

import { loadLeague } from './../main';

class MatchDaySelect extends Component {
    matchDays() {
        let matchDays = [];
        for (let matchDay = 1; matchDay < this.props.leagueTable.matchDay + 1; matchDay++) {
            matchDays.push(matchDay);
        }
        return matchDays;
    }

    render () {
        return (
            <div>
                {this.props.leagueTable &&
                    <Select matchDays={this.matchDays()} />
                }
            </div>
        );
    }
}

class Select extends Component {
    render () {
        return (
            <select id="matchDay" name="Match Day" onChange={ function() {
                        const selectedLeague = $("#leagueInfo").find(":selected");
                        const leagueId = selectedLeague.data("leagueId");

                        const matchDay = $("#matchDay").find(":selected").val();
                        loadLeague(leagueId, matchDay);
                    }
                }>
                {this.props.matchDays.map((item, count) =>
                        <option key={item}>
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