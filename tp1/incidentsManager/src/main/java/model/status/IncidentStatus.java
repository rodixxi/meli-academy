package model.status;

public enum IncidentStatus {
    ASSIGNED ("Assigned"),
    RESOLVED ("Resolved");

    private String status;

    IncidentStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
