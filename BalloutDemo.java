//Kenneth Ortega November 17,2023
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BalloutDemo {

    private List<Ballot> ballots = new ArrayList<>();

    public BalloutDemo() {
        ballots.add(new Ballot("Alice", Arrays.asList("Alice", "Bob", "Charlie", "John", "Jane")));
        ballots.add(new Ballot("Bob", Arrays.asList("Bob", "Charlie", "Alice", "John", "Jane")));
        ballots.add(new Ballot("Charlie", Arrays.asList("Charlie", "Alice", "Bob", "John", "Jane")));
    }

    public String simulateRunoffElection() {
        // Print the number of voters and ranks for each ballot
        printRoundInfo();

        /* Print the ballots and results before sorting and eliminating(for testing purposes)
        if (ballots.size() > 1) {
            printRoundResults(ballots);
        }
        */

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

        String winner = ballots.get(0).getCandidate();
        System.out.println("Winner: " + winner);
        return winner + " is the winner";
    }

    private void printRoundInfo() {
        System.out.println("Number of voters: " + ballots.size());

        for (Ballot ballot : ballots) {
            System.out.println("Rank 1: " + ballot.getPreferences().get(0));
            System.out.println("Rank 2: " + ballot.getPreferences().get(1));
            System.out.println("Rank 3: " + ballot.getPreferences().get(2));
            System.out.println();
        }
    }

    


    public static void main(String[] args) {
    	BalloutDemo demo = new BalloutDemo();
        String winner = demo.simulateRunoffElection();
    }
}
