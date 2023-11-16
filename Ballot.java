import java.util.List;

public class Ballot {
    private String candidate;
    private List<String> preferences;

    public Ballot(String candidate, List<String> preferences) {
        this.candidate = candidate;
        this.preferences = preferences;
    }
    
    public void setCandidate(String string) {
		
		
	}
    
    public String getCandidate() {
        return candidate;
    }

    public List<String> getPreferences() {
        return preferences;
    }

	
}
