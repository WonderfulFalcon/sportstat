export default class MainTableHandler
{
    constructor (teams, homeAwayState) {
        this.teams = teams;
        this.homeAwayState = homeAwayState;
    }

    convertTable() {
        this.teams.sort(this.tableComparators()[this.homeAwayState]);

        this.teams.forEach((team) => {
            this.tableProcessors()[this.homeAwayState](team);
        });
    }

    total (table) {
        return table.wins * 3 + table.draws;
    }

    options (table) {
        table.points = this.total(table);
        table.goalsDifference = table.goalsScored - table.goalsAgainst;
        table.playedGames = table.wins + table.draws + table.losses;
    }


    tableComparators () {
        return {
            Home : (team1, team2) => {
                return this.total(team2['homeStatistic']) -
                    this.total(team1['homeStatistic'])
            },
            Away : (team1, team2) => {
                return this.total(team2['awayStatistic']) -
                    this.total(team1['awayStatistic'])
            },
            All : (team1, team2) => {
                return team1.allStatistic.position - team2.allStatistic.position;
            }
        };
    };

    tableProcessors () {
        return {
            Home : (team) => {
                this.options(team['homeStatistic']);
            },
            Away : (team) => {
                this.options(team['awayStatistic']);
            },
            All : (team) => {}
        }
    }
}