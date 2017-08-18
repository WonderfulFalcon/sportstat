import React, {Component} from 'react';

class TeamName extends Component {
    imagePath (name) {
        return "/images/Clubs/" + name + ".svg";
    }

    render () {
        return (<div>
            <div className="club-logo">
                <img src={this.imagePath(this.props.teamName)} />
            </div>
            <div className="team-name">
                <span>{this.props.teamName}</span>
            </div>
        </div>)
    }
}

export default TeamName;