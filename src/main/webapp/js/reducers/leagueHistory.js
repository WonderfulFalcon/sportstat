const initialState = {};

export default function leagueHistory(state = initialState, action = {}) {
    if (action.type == 'LOAD_HISTORY') {
        return action.payload;
    }
    return state;
}