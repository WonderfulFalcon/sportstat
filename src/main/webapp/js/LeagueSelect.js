import React, { Component } from 'react';
import { connect } from 'react-redux';

class LeagueSelect extends Component {
    leagueChanged(event) {
        {console.log(event)}
    }

    render () {
        return (
            <div>
                <select id="leagueInfo" onChange={this.leagueChanged}>
                    {this.props.testStore.map((league, index) =>
                        <option key={index} data-league-id={league.id}
                                data-league-tours-played={league.toursPlayed}>
                            {league.name}
                        </option>
                    )}
                </select>
            </div>
        )
    }
}

export default connect(
        state => ({ testStore : state }),
        dispatch => ({})
)(LeagueSelect);