import React, {Component} from 'react';
import { connect } from 'react-redux';

class LeagueInfo extends Component {
    render () {
        return (
            <div id="col1">
                {this.props.leagueMatches.length > 0 &&
                    <table class="match-results">
                        <thead>
                            <tr>
                                <th>
                                    <span>
                                        Match results:
                                    </span>
                                </th>
                            </tr>
                        </thead>
                        <LeagueStatistic matches={this.props.leagueMatches} />
                    </table>
                }
            </div>
        )
    }
}

class LeagueStatistic extends Component {
    render () {
        return (
            <tbody>
                {this.props.matches.map((match, index) =>
                    <tr>
                        <td><span>{match.homeTeamName}</span></td>
                        <td class="scoreColumn">
                            <span>${match.goalsHomeTeam}</span>
                            <span>-</span>
                            <span>${match.goalsAwayTeam}</span>
                        </td>
                        <td><span>${match.awayTeamName}</span></td>
                    </tr>
                )}
            </tbody>
        )
    }
}

export default connect(
    state => ({ leagueMatches : state.leagueMatches }),
    dispatch => ({})
);