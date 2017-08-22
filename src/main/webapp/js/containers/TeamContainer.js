import { connect } from 'react-redux';
import Team from './../components/Team';
import {loadPlayers, selectTeam} from "../main";

const mapStateToProps = (state, ownProps) => {
    return {
        team: ownProps.team
    }
};

const mapDispatchToProps = (dispatch, ownProps) => {
    return {
        onTeamClick: () => {
            $('.teamColumn.selected').removeClass('selected');
            $('[data-clickable-team=' + ownProps.team.id + ']').addClass('selected');
            selectTeam({teamId: ownProps.team.id, teamName: ownProps.team.name});
            loadPlayers(ownProps.team.id, ownProps.team.name);
        }
    }
};

const TeamContainer = connect(
    mapStateToProps,
    mapDispatchToProps
)(Team);

export default TeamContainer;