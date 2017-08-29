export function loadLeaguesAction(json) {
   return { type : "LOAD_LEAGUES", payload: json };
}

export function loadTablesAction(json) {
    return {type : "LOAD_TABLES", payload: json };
}

export function loadMatchesAction(json) {
    return {type : "LOAD_MATCHES", payload: json };
}

export function loadPlayersAction(json, teamName) {
    return {type : "LOAD_PLAYERS", payload: { teamPlayers: json, teamName: teamName }};
}

export function currentSelectedTeamAction(selectedTeam = {}) {
    return { type: "SELECT_TEAM", payload: selectedTeam };
}

export function changeCurrentState(attribute, value) {
    return {
        type: "CURRENT_STATE_CHANGED",
        payload : {
            attribute : attribute,
            value : value
        }
    }
}