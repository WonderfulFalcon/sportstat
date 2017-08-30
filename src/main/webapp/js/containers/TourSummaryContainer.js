import React, {Component} from 'react';
import { connect } from 'react-redux';
import TourSummary from './../components/TourSummary';

class TourSummaryContainer extends Component {
    render () {
        return (
            <TourSummary matches={this.props.leagueMatches} />
        )
    }
}

export default connect(
    state => ({ leagueMatches : state.leagueMatches }),
    dispatch => ({})
)(TourSummaryContainer);