import React, { Component } from 'react';
import PropTypes from 'prop-types';

export default class TourSummary extends Component {
    render () {
        return (
            <div id="col1">
                {this.props.leagueMatches.length > 0 &&
                    <div>
                        <div className="match-results-header">
                            <span>
                                {this.props.translate("headers.matchResults")}
                            </span>
                        </div>
                        <table className="match-results">
                            <tbody>
                                {this.props.leagueMatches.map((match, index) =>
                                    <tr key={index}>
                                        <td><span>{match.homeTeamName}</span></td>
                                        <td className="scoreColumn">
                                            <span>{match.goalsHomeTeam}</span>
                                            <span>-</span>
                                            <span>{match.goalsAwayTeam}</span>
                                        </td>
                                        <td><span>{match.awayTeamName}</span></td>
                                    </tr>
                                )}
                            </tbody>
                        </table>
                    </div>
                }
            </div>
        )
    }
}

TourSummary.propTypes = {
    leagueMatches : PropTypes.array,
    translate : PropTypes.func
};