import React from 'react';
import { connect } from 'react-redux';
import { getTranslate } from 'react-localize-redux';

import TourSummary from './../components/TourSummary';

const mapStateToProps = (state) => {
    return {
        translate: getTranslate(state.locale),
        leagueMatches : state.leagueMatches
    }
};

export default connect(
    mapStateToProps
)(TourSummary);