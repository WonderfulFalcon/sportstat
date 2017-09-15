import React, { Component } from 'react';
import PropTypes from 'prop-types';
import {isEmpty} from 'underscore';

import TeamName from './league/TeamName';

export default class TeamPlayers extends Component {
    static logoClass (country) {
        return "flag-" + country;
    }

    isShowPlayers () {
        return !isEmpty(this.props.currentSelectedTeam) &&
            this.props.teamPlayers.teamPlayers &&
            this.props.teamPlayers.teamPlayers.length > 0
    }

    render () {
        return (
            <div id="col3">
                {this.isShowPlayers() &&
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
                }
            </div>
        )
    }
}

TeamPlayers.propTypes = {
    currentSelectedTeam : PropTypes.object,
    teamPlayers : PropTypes.object
};