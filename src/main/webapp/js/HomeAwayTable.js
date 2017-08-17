import React, {Component} from 'react';
import { connect } from 'react-redux';

class HomeAwayTable extends Component {
    render () {

    }
}

export default connect(
    state => ({ homeAwayState : state.homeAwayState })
)(HomeAwayTable);