export default class TableSorter
{
    convertedTable(teams, homeAwayState) {
        teams.sort((team1, team2) => {
            if (homeAwayState == "Home") {
                const team1Points = team1.homeStatistic.wins * 3 + team1.homeStatistic.draws;
                const team2Points = team2.homeStatistic.wins * 3 + team2.homeStatistic.draws;
                return team2Points - team1Points;
            } else if (homeAwayState == "Away") {
                const team1Points = team1.awayStatistic.wins * 3 + team1.awayStatistic.draws;
                const team2Points = team2.awayStatistic.wins * 3 + team2.awayStatistic.draws;
                return team2Points - team1Points;
            }
            return team1.allStatistic.position - team2.allStatistic.position;
        });

        if (homeAwayState == "All") {
            return teams;
        }

        teams.forEach((team, index) => {
            if (homeAwayState == "Home") {
                team.homeStatistic.position = index + 1;
                team.homeStatistic.points = team.homeStatistic.wins * 3 + team.homeStatistic.draws;
                team.homeStatistic.goalsDifference = team.homeStatistic.goalsScored - team.homeStatistic.goalsAgainst;
                team.homeStatistic.playedGames = team.allStatistic.playedGames / 2;
            } else if (homeAwayState == "Away") {
                team.awayStatistic.position = index + 1;
                team.awayStatistic.points = team.awayStatistic.wins * 3 + team.awayStatistic.draws;
                team.awayStatistic.goalsDifference = team.awayStatistic.goalsScored - team.awayStatistic.goalsAgainst;
                team.awayStatistic.playedGames = team.allStatistic.playedGames / 2;
            }
        });
        return teams;
    }
}