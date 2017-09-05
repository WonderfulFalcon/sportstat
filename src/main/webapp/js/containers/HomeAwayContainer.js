import { connect } from 'react-redux';

import { changeHomeAway } from './../actions/actions.js';
import HomeAwaySelect from './../components/HomeAwaySelect';

const mapDispatchToProps = (dispatch) => {
    return {
        homeAway : (value) => dispatch(changeHomeAway(value))
    };
};

export default connect(
    state => ({}),
    mapDispatchToProps
)(HomeAwaySelect);