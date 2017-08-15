const initialState = [];

export default function leagueMatches(state = initialState, action = {}) {
    if (action.type == 'LOAD_MATCHES') {
        return action.payload;
    }
    return state;
}