package service;

import model.Incident;
import service.exception.IncidentException;

import java.util.Collection;

public interface IncidentService {

    public void addIncident (Incident incident);

    public Collection<Incident> getIncidents ();

    public Incident getIncident (String id);

    public Incident editIncident (Incident incident) throws IncidentException;

    public boolean existIncident (String id);
}
