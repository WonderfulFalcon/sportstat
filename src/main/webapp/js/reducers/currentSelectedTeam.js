const initialState = {};

export default function currentSelectedTeam(state = initialState, action = {}) {
    if (action.type == 'SELECT_TEAM') {
        return action.payload;
    }
    return state;
}
