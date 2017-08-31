export default class TeamSelector {
    constructor (team = {}, teamPlayers = [], currentSelectedTeam = {}) {
        this.team = team;
        this.teamPlayers = teamPlayers;
        this.currentSelectedTeam = currentSelectedTeam;
    }

    isSelected () {
        return this.currentSelectedTeam.teamId === this.team.id;
    }

    isRepeatSelected () {
        return this.teamPlayers.teamName === this.team.name;
    }

    isFirstSelect () {
        return !this.isSelected() && !this.isRepeatSelected();
    }

    getSelectedTeam () {
        if (this.isSelected()) {
            return {};
        }

        if (this.isFirstSelect() || this.isRepeatSelected()) {
            return {
                teamId: this.team.id,
                teamName: this.team.name
            };
        }
        return {};
    }
}