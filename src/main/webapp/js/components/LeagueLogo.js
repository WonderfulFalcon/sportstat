import React, { Component } from 'react';

class LeagueLogo extends Component {
    static imagePath (name) {
        return "/images/League/" + name + ".svg";
    }

    render() {
        return (
            <div className="league-logo">
                <img src={ LeagueLogo.imagePath(this.props.shortName) } />
            </div>
        )
    }
}

export default LeagueLogo;