import React, {Component} from 'react';

class HomeAwaySelect extends Component {
    render () {
        return (
            <div>
                <select>
                    <option key="1">
                        All
                    </option>
                    <option key="2">
                        Home
                    </option>
                    <option key="3">
                        Away
                    </option>
                </select>
            </div>
        )
    }
}

export default HomeAwaySelect;