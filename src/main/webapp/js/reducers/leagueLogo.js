const initialState = "PL";

export default function leagueLogo(state = initialState, action = {}) {
    if (action.type == 'LOAD_LEAGUE_TABLE') {
        return action.payload;
    }
    return state;
}