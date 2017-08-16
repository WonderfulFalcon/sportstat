const initialState = "All";

export default function homeAwayState(state = initialState, action = {}) {
    if (action.type == 'HOME_AWAY_CHANGED') {
        return action.payload;
    }
    return state;
}