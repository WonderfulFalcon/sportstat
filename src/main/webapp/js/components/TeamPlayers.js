import React, { Component } from 'react';
import TeamName from './TeamName';

class TeamPlayers extends Component {
    static logoClass (country) {
        return "flag-" + country;
    }

    render () {
        return (
            <div>
                <div className="players-table-header">
                    <TeamName teamName={this.props.teamPlayers.teamName} />
                </div>
                <table>
                    <tbody>
                    {this.props.teamPlayers.teamPlayers.map((player, index) =>
                        <tr key={index}>
                            <td className="player-country">
                                <i className={TeamPlayers.logoClass(player.country)}/>
                            </td>
                            <td>{player.name}</td>
                            <td>{player.number}</td>
                        </tr>
                    )}
                    </tbody>
                </table>
            </div>
        )
    }
}

export default TeamPlayers;