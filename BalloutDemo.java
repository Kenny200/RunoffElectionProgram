//Kenneth Ortega November 17,2023
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BalloutDemo {

    private List<Ballot> ballots = new ArrayList<>();

    public BalloutDemo() {
        ballots.add(new Ballot("Alice", Arrays.asList("Alice", "Bob", "Charlie")));
        ballots.add(new Ballot("Bob", Arrays.asList("Bob", "Charlie", "Alice")));
        ballots.add(new Ballot("Charlie", Arrays.asList("Charlie", "Alice", "Bob")));
    }

    public String simulateRunoffElection() {
    //Print the Ballots and Results
        if (ballots.size() > 1) {
        System.out.println("Round results:");
        for (Ballot ballot : ballots) {
            System.out.println(ballot.getCandidate() + ": " + ballot.getPreferences());
        }
        System.out.println();
        
        return simulateRunoffElection();
    }
        ballots.sort((b1, b2) -> Integer.compare(b2.getPreferences().indexOf(b2.getCandidate()), b1.getPreferences().indexOf(b1.getCandidate())));

        String eliminatedCandidate = ballots.get(ballots.size() - 1).getCandidate();
        ballots.remove(ballots.size() - 1);

        for (Ballot ballot : ballots) {
            if (ballot.getCandidate().equals(eliminatedCandidate)) {
                ballot.setCandidate(ballot.getPreferences().get(0));
            }
        }

        if (ballots.size() > 1) {
            return simulateRunoffElection();
        }

        return ballots.get(0).getCandidate();
    }

    public static void main(String[] args) {
    	BalloutDemo demo = new BalloutDemo();
        String winner = demo.simulateRunoffElection();
        System.out.println("The winner of the runoff election is: " + winner);
    }
}
