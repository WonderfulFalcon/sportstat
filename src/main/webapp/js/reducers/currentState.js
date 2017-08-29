const initialState = {
    matchDay : 1,
    league : {},
    homeAwayState : "All",
    currentSelectedTeam : {}
};

export default function currentState(state = initialState, action = {}) {
    if (action.type == "CURRENT_STATE_CHANGED") {
        state[action.payload.attribute] = action.payload.value;
        return state;
    }
    return state;
}