import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import { connect } from 'react-redux';

class MatchDaySelect extends Component {
    render () {
        return (
            <select id="matchDay" name="Match Day">
                {this.props.testStore.map((league, index) =>
                    <option key={index}>
                        {index}
                    </option>
                )}
            </select>
        );
    }
}

export default connect(
        state => ({ testStore : state }),
        dispatch => ({})
)(MatchDaySelect);