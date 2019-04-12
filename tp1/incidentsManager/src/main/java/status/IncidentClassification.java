package status;

public enum IncidentClassification {
    CRITICAL ("Critical"),
    NORMAL ("Normal"),
    MINOR ("Minor");

    private String classification;

    IncidentClassification(String classification) {
        this.classification = classification;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }
}
