//Kenneth Ortega November 17,2023
import java.util.List;
//runoffelection class file
public class RunoffElection {
    private List<Ballot> ballots;
    //create a election object
    public RunoffElection(List<Ballot> ballots) {
        this.ballots = ballots;
    }

    public String simulateRunoffElection() {
        // Sort the ballots in decreasing order of first choice votes.
        ballots.sort((b1, b2) -> Integer.compare(b2.getPreferences().indexOf(b2.getCandidate()), b1.getPreferences().indexOf(b1.getCandidate())));

        // Eliminate the candidate with the fewest first choice votes.
        String eliminatedCandidate = ballots.get(ballots.size() - 1).getCandidate();
        ballots.remove(ballots.size() - 1);

        // Redistribute the votes for the eliminated candidate to the remaining candidates based on the voters' ranked preferences.
        for (Ballot ballot : ballots) {
            if (ballot.getCandidate().equals(eliminatedCandidate)) {
                ballot.setCandidate(ballot.getPreferences().get(0));
            }
        }

        // Repeat steps 2 and 3 until there is only one candidate remaining.
        if (ballots.size() > 1) {
            return simulateRunoffElection();
        }

        // Return the remaining candidate as the winner of the runoff election.
        return ballots.get(0).getCandidate();
    }
}
