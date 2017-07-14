import React, { Component } from 'react';

class LeagueTable extends Component {
    render () {
        return (
            <div id='col1'>
                {this.props.testStore.map((table, index) =>
                    <table key={index}></table>
                )}
            </div>
        )
    }
}

export default connect(
        state => ({ testStore : state }),
        dispatch => ({})
)(LeagueTable);