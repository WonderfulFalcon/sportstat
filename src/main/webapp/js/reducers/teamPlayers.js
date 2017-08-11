const initialState = [];

export default function teamPlayers(state = initialState, action = {}) {
    if (action.type == 'LOAD_PLAYERS') {
        return action.payload;
    }
    return state;
}