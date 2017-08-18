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
                {this.props.teamPlayers.teamPlayers && this.props.teamPlayers.teamPlayers.length > 0 &&
                    <div>
                        <div className="players-table-header">
                            <TeamName teamName={this.props.teamPlayers.teamName} />
                        </div>
                        <table>
                            {this.props.teamPlayers.teamPlayers.map((player, index) =>
                                <tr>
                                    <td className="player-country">
                                        <i className={this.countryLogoClass(player.country)}></i>
                                    </td>
                                    <td>{player.name}</td>
                                    <td>{player.number}</td>
                                </tr>
                            )}
                        </table>
                    </div>
                }
            </div>
        )
    }
}

export default connect(
    state => ({teamPlayers : state.teamPlayers}),
    dispatch => ({})
)(TeamPlayers);