import React, { Component } from 'react';

export default class Loading extends Component {
    render () {
        return (
            <div>
                {$.isEmptyObject(this.props.leagueTable) &&
                    <div className="loading-gif-container">
                        <img src="/images/loading_football.gif" />
                    </div>
                }
            </div>
        )
    }
}