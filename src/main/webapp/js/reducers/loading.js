const initialState = true;

export default function teamPlayers(state = initialState, action = {}) {
    if (action.type == 'FIRST_LOADING') {
        return action.payload;
    }
    return state;
}