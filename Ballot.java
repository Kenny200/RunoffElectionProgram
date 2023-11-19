//Kenneth Ortega November 17,2023
import java.util.List;
//Ballot class file
public class Ballot {
    private String candidate;
    private List<String> preferences;
//Ballot object which uses our string candidate and our List String preferences
    public Ballot(String candidate, List<String> preferences) {
        this.candidate = candidate;
        this.preferences = preferences;
    }
    //the getters and setters
    public void setCandidate(String string) {	
		
	}
    
    public String getCandidate() {
        return candidate;
    }

    public List<String> getPreferences() {
        return preferences;
    }

	
}
