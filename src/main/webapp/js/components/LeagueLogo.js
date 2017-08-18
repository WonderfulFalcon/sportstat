import React, { Component } from 'react';

class LeagueLogo extends Component {
    imagePath (name) {
        return "/images/League/" + name + ".svg";
    }

    render() {
        return (<div className="league-logo">
            <img src={ this.imagePath(this.props.shortName) } />
        </div>)
    }
}

export default LeagueLogo;