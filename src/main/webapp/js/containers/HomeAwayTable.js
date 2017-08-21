import React, {Component} from 'react';
import { connect } from 'react-redux';

class HomeAwayTable extends Component {
    getTable() {
        if (this.props.homeAwayState == "Home") {
            return this.props.leagueTable.tables[0].teams.map((team) => {
                return team.statistic.homeStatistic;
            });
        } else if (this.props.homeAwayState == "Away") {
            return this.props.leagueTable.tables[0].teams.map((team) => {
                return team.statistic.awayStatistic;
            });
        }
        return [];
    }

    render () {
        const table = this.getTable();
        return (
            <div id='col2'>
                {this.props.homeAwayState != "All" && <table>
                    <thead>
                        <tr>
                            <th><span>Pos.</span></th>
                            <th><span>Team</span></th>
                            <th><span>W</span></th>
                            <th><span>D</span></th>
                            <th><span>L</span></th>
                            <th><span>GD</span></th>
                            <th><span>Points</span></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>

                        </tr>
                    </tbody>
                </table>}
            </div>
        )
    }
}

const mapStateToProps = (state) => {
    return {
        homeAwayState : state.homeAwayState,
        leagueTable : state.leagueTable
    }
};

export default connect(
    mapStateToProps
)(HomeAwayTable);