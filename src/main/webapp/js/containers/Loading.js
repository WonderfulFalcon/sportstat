import React, { Component } from 'react';
import { connect } from 'react-redux';

class Loading extends Component {
    render () {
        return (
            <div>
                {$.isEmptyObject(this.props.leagueTable) &&
                    <div className="loading-gif-container">
                        <img src="/images/loading_football.gif" />
                    </div>
                }
            </div>
        );
    }
}

export default connect(
        state => ({ leagueTable : state.leagueTable }),
        dispatch => ({})
)(Loading);