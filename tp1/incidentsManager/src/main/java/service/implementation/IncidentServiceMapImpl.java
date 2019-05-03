package service.implementation;

import model.Incident;
import model.status.IncidentStatus;
import service.IncidentService;
import service.exception.IncidentException;

import java.util.Collection;
import java.util.HashMap;

public class IncidentServiceMapImpl implements IncidentService {

    private HashMap<String, Incident> incidentMap;

    private static IncidentServiceMapImpl instance = null;

    private IncidentServiceMapImpl() {
        this.incidentMap = new HashMap<String, Incident>();
    }

    private IncidentServiceMapImpl(HashMap<String, Incident> incidentMap) {
        this.incidentMap = incidentMap;
    }

    public static IncidentServiceMapImpl getInstance() {
        if (instance == null) {
            instance = new IncidentServiceMapImpl();
        }
        return instance;
    }

    @Override
    public void addIncident(Incident incident) {
        incidentMap.put(String.valueOf(incident.getId()), incident);
    }

    @Override
    public Collection<Incident> getIncidents() {
        return incidentMap.values();
    }

    @Override
    public Incident getIncident(String id) {
        return incidentMap.get(id);
    }

    @Override
    public Incident editIncident(Incident incident) throws IncidentException {
        try {
            if (incident.getId() == 0) {
                throw new IncidentException("Id cant be 0(zero) or null.");
            }
            if (this.existIncident(String.valueOf(incident.getId()))) {
                Incident incidentToEdit = incidentMap.get(incident.getId());
                if (incident.getStatus() != null) {
                    if (incident.getStatus().equals(IncidentStatus.RESOLVED)
                            && incidentToEdit.getStatus().equals(IncidentStatus.ASSIGNED)) {
                        incidentToEdit.setStatus(incident.getStatus());
                    } else {
                        throw  new IncidentException("Incident state can only be change to resolved.");
                    }
                }
                if (incident.getDescription() != null) {
                    incidentToEdit.setDescription(new StringBuilder()
                            .append(incidentToEdit.getDescription())
                            .append("\n").append(incident.getDescription())
                            .toString());
                }
                return incidentToEdit;
            }
            return null;
        } catch (Exception e){
            throw new IncidentException(e.getMessage());
        }
    }

    @Override
    public boolean existIncident(String id) {
        return incidentMap.containsKey(id);
    }
}
