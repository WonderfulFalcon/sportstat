import React, { Component } from 'react';

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
        )
    }
}

export default Loading;