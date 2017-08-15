import React, {Component} from 'react';
import { connect } from 'react-redux';

class LeagueInfo extends Component {
    render () {
        return (
            <div id="col1">
                {this.props.leagueMatches.length > 0 &&
                    <div>
                        <div className="match-results-header">
                            <span>
                                Match results
                            </span>
                        </div>
                        <table className="match-results">
                            <LeagueStatistic matches={this.props.leagueMatches} />
                        </table>
                    </div>
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
                            <span>{match.goalsHomeTeam}</span>
                            <span>-</span>
                            <span>{match.goalsAwayTeam}</span>
                        </td>
                        <td><span>{match.awayTeamName}</span></td>
                    </tr>
                )}
            </tbody>
        )
    }
}

export default connect(
    state => ({ leagueMatches : state.leagueMatches }),
    dispatch => ({})
)(LeagueInfo);