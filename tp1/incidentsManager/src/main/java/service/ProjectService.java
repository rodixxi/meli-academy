package service;

import model.Project;
import service.exception.ProjectException;

import java.util.Collection;

public interface ProjectService {

    public void addProject (Project project);

    public Collection<Project> getProjects ();

    public Project getProject (String id);

    public Project editProject (Project project) throws ProjectException;

    public Project deleteProject (String id);

    public boolean existProject (String id);
}
