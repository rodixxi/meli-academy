package model;

import model.status.IncidentClassification;
import model.status.IncidentStatus;

import java.util.Date;

public class Incident {

    private int id;
    private IncidentClassification classification;
    private String description;
    private User reporter;
    private User responsible;
    private IncidentStatus status;
    private Date creationDate;
    private Date solutionDate;

    public Incident(int id, IncidentClassification classification, String description, User reporter, User responsible, IncidentStatus status, Date creationDate, Date solutionDate) {
        this.id = id;
        this.classification = classification;
        this.description = description;
        this.reporter = reporter;
        this.responsible = responsible;
        this.status = status;
        this.creationDate = creationDate;
        this.solutionDate = solutionDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public IncidentClassification getClassification() {
        return classification;
    }

    public void setClassification(IncidentClassification classification) {
        this.classification = classification;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getReporter() {
        return reporter;
    }

    public void setReporter(User reporter) {
        this.reporter = reporter;
    }

    public User getResponsible() {
        return responsible;
    }

    public void setResponsible(User responsible) {
        this.responsible = responsible;
    }

    public IncidentStatus getStatus() {
        return status;
    }

    public void setStatus(IncidentStatus status) {
        this.status = status;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getSolutionDate() {
        return solutionDate;
    }

    public void setSolutionDate(Date solutionDate) {
        this.solutionDate = solutionDate;
    }
}
