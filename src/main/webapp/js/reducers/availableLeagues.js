const initialState = [];

export default function availableLeagues(state = initialState, action = {}) {
    if (action.type == 'LOAD_LEAGUES') {
        return action.payload;
    }
    return state;
}