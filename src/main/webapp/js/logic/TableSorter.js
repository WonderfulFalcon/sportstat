export default class TableSorter
{
    convertedTable(teams, homeAwayState) {
        if (homeAwayState == "All") {
            return teams;
        }

        teams.sort((team1, team2) => {
            if (homeAwayState == "Home") {
                return team2.homeStatistic.wins - team1.homeStatistic.wins;
            }
            return team2.awayStatistic.wins - team1.awayStatistic.wins
        });
        return teams;
    }
}