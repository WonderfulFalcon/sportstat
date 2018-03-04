import React, { Component } from 'react';
import { logoClass } from './../../components/TeamPlayers';

export default class LocalizeBox extends Component {
    render () {
        return (
            <div className="localize-box">
                {this.props.languages.map((language) =>
                    <span key={language.code}>
                        <i className={logoClass(language.code)} />
                    </span>
                )}
            </div>
        );
    }
}