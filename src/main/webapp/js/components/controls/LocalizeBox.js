import React, { Component } from 'react';
import { logoClass } from './../../components/TeamPlayers';

export default class LocalizeBox extends Component {
    changeLanguage (language) {
        if (!language.active) {
            this.props.changeLanguage(language.code);
        }
    }

    render () {
        return (
            <div className="localize-box">
                {this.props.languages.map((language) =>
                    <span key={language.code}>
                        <i className={logoClass(language.code)}
                           onClick={e => this.changeLanguage(language, e)}
                        />
                    </span>
                )}
            </div>
        );
    }
}