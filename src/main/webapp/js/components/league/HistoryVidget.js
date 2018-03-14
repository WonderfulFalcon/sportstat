import React, { Component } from 'react';
import {isEmpty} from 'underscore';

export default class HistoryVidget extends Component {
    static imagePath (name) {
        return "/images/Results/" + name + ".png";
    }

    render () {
        return (
            <div>
                {!(isEmpty(this.props.history)) &&
                    <div>
                        <span>
                            {this.props.history.matches.map((match, index) =>
                                <img src={ HistoryVidget.imagePath(match.result) } />
                            )}
                        </span>
                    </div>
                }
            </div>
        );
    }
}