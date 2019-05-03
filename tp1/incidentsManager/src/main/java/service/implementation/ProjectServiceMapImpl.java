package service.implementation;

import model.Project;
import model.User;
import service.ProjectService;
import service.exception.ProjectException;

import java.util.Collection;
import java.util.HashMap;

public class ProjectServiceMapImpl implements ProjectService {

    private HashMap<String, Project> projectMap;

    private static ProjectServiceMapImpl instance = null;

    private UserServiceMapImpl userService = UserServiceMapImpl.getInstance();

    private IncidentServiceMapImpl incidentService = IncidentServiceMapImpl.getInstance();

    private ProjectServiceMapImpl() {
        this.projectMap = new HashMap<String, Project>();
    }

    private ProjectServiceMapImpl(HashMap<String, Project> projectMap) {
        this.projectMap = projectMap;
    }

    public static ProjectServiceMapImpl getInstance() {
        if (instance == null) {
            instance = new ProjectServiceMapImpl();
        }
        return instance;
    }

    @Override
    public void addProject(Project project) {
        if (userService.existUser(String.valueOf(project.getOwner().getId()))) {
            projectMap.put(String.valueOf(project.getId()), project);
        }
    }

    @Override
    public Collection<Project> getProjects() {
        return projectMap.values();
    }

    @Override
    public Project getProject(String id) {
        return projectMap.get(id);
    }

    @Override
    public Project editProject(Project project) throws ProjectException {
        try {
            if (project.getId() == 0) {
                throw new ProjectException("Id cant be 0(zero) or null.");
            }
            if (this.existProject(String.valueOf(project.getId()))) {
                Project projectToEdit = projectMap.get(project.getId());
                if (project.getIncidents() != null) {
                    projectToEdit.setIncidents(project.getIncidents());
                }
                if (project.getOwner() != null) {
                    projectToEdit.setOwner(project.getOwner());
                }
                if (project.getTitle() != null) {
                    projectToEdit.setTitle(project.getTitle());
                }
                return projectToEdit;
            }
            return null;
        } catch (Exception e){
            throw new ProjectException(e.getMessage());
        }
    }

    @Override
    public Project deleteProject(String id) {
        if (projectMap.get(id).hasAssignedIncidents()) {
            return null;
        }
        return projectMap.remove(id);
    }

    @Override
    public boolean existProject(String id) {
        return projectMap.containsKey(id);
    }
}
