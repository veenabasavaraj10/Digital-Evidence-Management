package DEM;
import java.sql.Date;
public class Evidence {
	  private int evidenceId;
	    private String caseId;
	    private String evidenceName;
	    private String description;
	    private String collectedBy;
	    private Date dateCollected;
	    private String status;

	    // Constructor
	    public Evidence(String caseId, String evidenceName, String description,
	                    String collectedBy, Date dateCollected, String status) {
	        this.caseId = caseId;
	        this.evidenceName = evidenceName;
	        this.description = description;
	        this.collectedBy = collectedBy;
	        this.dateCollected = dateCollected;
	        this.status = status;
	    }

	    // Getters
	    public String getCaseId() { return caseId; }
	    public String getEvidenceName() { return evidenceName; }
	    public String getDescription() { return description; }
	    public String getCollectedBy() { return collectedBy; }
	    public Date getDateCollected() { return dateCollected; }
	    public String getStatus() { return status; }

}