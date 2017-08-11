import React, { Component } from 'react';
import { connect } from 'react-redux';

class TeamPlayers extends Component {
    countryLogoClass (country) {
        return "flag-" + country;
    }

    render () {
        return (
            <table>
                <thead>
                    <tr>
                        <th>Country</th>
                        <th>Name</th>
                        <th>Number</th>
                    </tr>
                </thead>
                <tbody>
                    {this.props.teamPlayers.map((player, index) =>
                        <tr>
                            <td className="player-country">
                                <i className={this.countryLogoClass(player.country)}></i>
                            </td>
                            <td>{player.name}</td>
                            <td>{player.number}</td>
                        </tr>
                    )}
                </tbody>
            </table>
        )
    }
}

export default connect(
    state => ({teamPlayers : state.teamPlayers}),
    dispatch => ({})
)(TeamPlayers);