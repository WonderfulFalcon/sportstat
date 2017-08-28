import { connect } from 'react-redux';
import Team from './../components/Team';
import {loadPlayers, selectTeam} from "../main";

const mapStateToProps = (state, ownProps) => {
    return {
        currentSelectedTeam: state.currentSelectedTeam,
        team: ownProps.team,
        teamPlayers: state.teamPlayers,
        homeAwayState: ownProps.homeAwayState,
        position: ownProps.position
    }
};

const mergeProps = (stateProps, dispatchProps, ownProps) => {
    const { currentSelectedTeam, teamPlayers, homeAwayState, position } = stateProps;
    const { team } = ownProps;
    return {
        currentSelectedTeam: currentSelectedTeam,
        team: team,
        teamPlayers: teamPlayers,
        homeAwayState: homeAwayState,
        position: position,
        onTeamClick: () => {
            if (currentSelectedTeam.teamId === team.id) {
                selectTeam();
            } else if (teamPlayers && teamPlayers.teamName === team.name) {
                selectTeam({teamId: team.id, teamName: team.name});
            } else {
                selectTeam({teamId: team.id, teamName: team.name});
                loadPlayers(team.id, team.name);
            }
        }
    }
};

const TeamContainer = connect(
    mapStateToProps,
    null,
    mergeProps
)(Team);

export default TeamContainer;