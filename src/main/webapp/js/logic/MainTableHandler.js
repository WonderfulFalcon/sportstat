export default class MainTableHandler
{
    static total (table) {
        return table.wins * 3 + table.draws;
    }

    static options (table) {
        table.points = MainTableHandler.total(table);
        table.goalsDifference = table.goalsScored - table.goalsAgainst;
        table.playedGames = table.wins + table.draws + table.losses;
    }

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

    tableComparators () {
        return {
            Home : (team1, team2) => {
                return MainTableHandler.total(team2['homeStatistic']) -
                    MainTableHandler.total(team1['homeStatistic'])
            },
            Away : (team1, team2) => {
                return MainTableHandler.total(team2['awayStatistic']) -
                    MainTableHandler.total(team1['awayStatistic'])
            },
            All : (team1, team2) => {
                return team1.allStatistic.position - team2.allStatistic.position;
            }
        };
    };

    tableProcessors () {
        return {
            Home : (team) => {
                MainTableHandler.options(team['homeStatistic']);
            },
            Away : (team) => {
                MainTableHandler.options(team['awayStatistic']);
            },
            All : (team) => {}
        }
    }
}