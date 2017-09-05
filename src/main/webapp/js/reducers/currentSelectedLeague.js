const initialState = {};

export default function currentSelectedLeague(state = initialState, action = {}) {
    if (action.type === "SELECT_LEAGUE") {
        return action.payload;
    }
    return state;
}