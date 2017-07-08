import React, { Component } from 'react';
import { connect } from 'react-redux';
import ReactDOM from 'react-dom';
import { Provider } from 'react-redux';

import Header from './Header';
import Gutter from './Gutter';
import ControlsPanel from './ControlsPanel';

class App extends Component {
    render() {
        return (
            <div>
                <Header />
                <Gutter />
                <ControlsPanel />
            </div>
        );
    }
}

export default App;