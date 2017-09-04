import React from 'react';
import { connect } from 'react-redux';

import Loading from './../components/Loading';

const mapStateToProps = (state) => {
    return {
        leagueTable : state.leagueTable
    }
};

export default connect(mapStateToProps)(Loading);