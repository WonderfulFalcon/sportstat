const initialState = [];

export default function availableLeagues(state = initialState, action = {}) {
    if (action.type == 'LOAD_LEAGUES' && action.payload) {
        return action.payload;
    }
    return state;
}