import React from 'react';
import { connect } from 'react-redux';
import TourSummary from './../components/TourSummary';

const mapStateToProps = (state) => {
    return {
        leagueMatches : state.leagueMatches
    }
};

export default connect(
    mapStateToProps
)(TourSummary);