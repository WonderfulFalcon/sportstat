const initialState = {};

export default function leagueTable(state = initialState, action = {}) {
    if (action.type == 'LOAD_TABLES') {
        return action.payload;
    }
    return state;
}