import React, { Component } from 'react';
import { connect } from 'react-redux';
import TeamName from './../components/TeamName';

class TeamPlayers extends Component {
    countryLogoClass (country) {
        return "flag-" + country;
    }

    render () {
        return (
            <div id="col3">
                {!$.isEmptyObject(this.props.currentSelectedTeam) && this.props.teamPlayers.teamPlayers && this.props.teamPlayers.teamPlayers.length > 0 &&
                    <div>
                        <div className="players-table-header">
                            <TeamName teamName={this.props.teamPlayers.teamName} />
                        </div>
                        <table>
                            <tbody>
                                {this.props.teamPlayers.teamPlayers.map((player, index) =>
                                    <tr key={index}>
                                        <td className="player-country">
                                            <i className={this.countryLogoClass(player.country)}></i>
                                        </td>
                                        <td>{player.name}</td>
                                        <td>{player.number}</td>
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

export default connect(
    state => ({
        currentSelectedTeam: state.currentSelectedTeam,
        teamPlayers : state.teamPlayers
    }),
    dispatch => ({})
)(TeamPlayers);