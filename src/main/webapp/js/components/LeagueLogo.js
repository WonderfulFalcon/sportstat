import React, { Component } from 'react';

export default class LeagueLogo extends Component {
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