import { connect } from 'react-redux';
import Team from './../components/Team';
import { loadPlayers } from "../main";

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
            loadPlayers(ownProps.team.id, ownProps.team.name);
        }
    }
};

const TeamContainer = connect(
    mapStateToProps,
    mapDispatchToProps
)(Team);

export default TeamContainer;