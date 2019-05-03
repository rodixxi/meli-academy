package model;

import model.status.IncidentStatus;

import java.util.Collection;

public class Project {

    private int id;
    private String title;
    private User owner;
    private Collection<Incident> incidents;

    public Project(int id, String title, User owner, Collection<Incident> incidents) {
        this.id = id;
        this.title = title;
        this.owner = owner;
        this.incidents = incidents;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Collection<Incident> getIncidents() {
        return incidents;
    }

    public void setIncidents(Collection<Incident> incidents) {
        this.incidents = incidents;
    }

    public boolean hasAssignedIncidents() {
        return  incidents
                .stream()
                .anyMatch(incident -> incident.getStatus() == IncidentStatus.ASSIGNED);
    }
}
