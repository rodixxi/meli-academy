package main;

import com.google.gson.Gson;
import main.response.StandardResponse;
import main.response.StatusResponse;
import model.Incident;
import model.Project;
import model.User;
import service.exception.IncidentException;
import service.exception.ProjectException;
import service.exception.UserException;
import service.implementation.IncidentServiceMapImpl;
import service.implementation.ProjectServiceMapImpl;
import service.implementation.UserServiceMapImpl;

import static spark.Spark.*;

public class RestHandled {

    public static void main(String[] args) {

        port(8080);

        /* /////////// USER /////////// */

        UserServiceMapImpl userService = UserServiceMapImpl.getInstance();

        get("/users", (request, response) -> {
            response.type("application/json");

            return new Gson().toJson(
                    new StandardResponse(StatusResponse.SUCCESS, new Gson()
                            .toJsonTree(userService.getUsers()))
            );
        });

        get("/users/:id", (request, response) -> {
            response.type("application/json");

            return new Gson().toJson(
                    new StandardResponse(StatusResponse.SUCCESS, new Gson()
                            .toJsonTree(userService.getUser(request.params(":id"))))
            );
        });

        post("/users", (request, response) -> {
            response.type("application/json");
            User user = new Gson().fromJson(request.body(), User.class);
            userService.addUser(user);

            return new Gson()
                    .toJson(new StandardResponse(StatusResponse.SUCCESS));
        });

        put("/users", (request, response) -> {
            response.type("application/json");
            String errorMessage = "User not found or error trying to edit.";
            User userToEdit = new Gson().fromJson(request.body(), User.class);
            User userEdited = null;
            try {
                userEdited = userService.editUser(userToEdit);
            } catch (UserException e) {
                errorMessage = e.getMessage();
            }

            if (userEdited != null) {
                return new Gson().toJson(
                        new StandardResponse(StatusResponse.SUCCESS, new Gson()
                                .toJsonTree(userEdited))
                );
            } else {
                return new Gson().toJson(
                        new StandardResponse(StatusResponse.ERROR, new Gson()
                                .toJson(errorMessage))
                );
            }
        });

        delete("/users/:id", (request, response) -> {
            response.type("application/json");
            User userDeleted = userService.deleteUser(request.params(":id"));

            if (userDeleted != null) {
                return new Gson().toJson(
                        new StandardResponse(StatusResponse.SUCCESS, new Gson()
                                .toJsonTree(userDeleted))
                );
            } else {
                return new Gson().toJson(
                        new StandardResponse(StatusResponse.ERROR, new Gson()
                                .toJson("User not found or error trying to delete."))
                );
            }
        });

        options("/users/:id", (request, response) -> {
            response.type("application/json");

            return new Gson().toJson(
                    new StandardResponse(StatusResponse.SUCCESS,
                            (userService.existUser(request.params("id")) ? "User exist." : "User DONT exist."))
            );
        });

        /* /////////// PROJECT /////////// */

        ProjectServiceMapImpl projectService = ProjectServiceMapImpl.getInstance();

        get("/projects", (request, response) -> {
            response.type("application/json");

            return new Gson().toJson(
                    new StandardResponse(StatusResponse.SUCCESS, new Gson()
                            .toJsonTree(projectService.getProjects()))
            );
        });

        get("/projects/:id", (request, response) -> {
            response.type("application/json");

            return new Gson().toJson(
                    new StandardResponse(StatusResponse.SUCCESS, new Gson()
                            .toJsonTree(projectService.getProject(request.params(":id"))))
            );
        });

        post("/projects", (request, response) -> {
            response.type("application/json");
            Project project = new Gson().fromJson(request.body(), Project.class);
            projectService.addProject(project);

            return new Gson()
                    .toJson(new StandardResponse(StatusResponse.SUCCESS));
        });

        put("/projects", (request, response) -> {
            response.type("application/json");
            String errorMessage = "Project not found or error trying to edit.";
            Project projectToEdit = new Gson().fromJson(request.body(), Project.class);
            Project projectEdited = null;
            try {
                projectEdited = projectService.editProject(projectToEdit);
            } catch (ProjectException e) {
                errorMessage = e.getMessage();
            }

            if (projectEdited != null) {
                return new Gson().toJson(
                        new StandardResponse(StatusResponse.SUCCESS, new Gson()
                                .toJsonTree(projectEdited))
                );
            } else {
                return new Gson().toJson(
                        new StandardResponse(StatusResponse.ERROR, new Gson()
                                .toJson(errorMessage))
                );
            }
        });

        delete("/projects/:id", (request, response) -> {
            response.type("application/json");
            Project projectDeleted = projectService.deleteProject(request.params(":id"));

            if (projectDeleted != null) {
                return new Gson().toJson(
                        new StandardResponse(StatusResponse.SUCCESS, new Gson()
                                .toJsonTree(projectDeleted))
                );
            } else {
                return new Gson().toJson(
                        new StandardResponse(StatusResponse.ERROR, new Gson()
                                .toJson("User not found or error trying to delete."))
                );
            }
        });

        options("/projects/:id", (request, response) -> {
            response.type("application/json");

            return new Gson().toJson(
                    new StandardResponse(StatusResponse.SUCCESS,
                            (projectService.existProject(request.params("id")) ? "Project exist." : "Project DONT exist."))
            );
        });

        /* /////////// INCIDENT /////////// */

        IncidentServiceMapImpl incidentService = IncidentServiceMapImpl.getInstance();

        get("/incidents", (request, response) -> {
            response.type("application/json");

            return new Gson().toJson(
                    new StandardResponse(StatusResponse.SUCCESS, new Gson()
                            .toJsonTree(incidentService.getIncidents()))
            );
        });

        get("/incidents/:id", (request, response) -> {
            response.type("application/json");

            return new Gson().toJson(
                    new StandardResponse(StatusResponse.SUCCESS, new Gson()
                            .toJsonTree(incidentService.getIncident(request.params(":id"))))
            );
        });

        post("/incidents", (request, response) -> {
            response.type("application/json");
            Incident incident = new Gson().fromJson(request.body(), Incident.class);
            incidentService.addIncident(incident);

            return new Gson()
                    .toJson(new StandardResponse(StatusResponse.SUCCESS));
        });

        put("/incidents", (request, response) -> {
            response.type("application/json");
            String errorMessage = "Incident not found or error trying to edit.";
            Incident incidentToEdit = new Gson().fromJson(request.body(), Incident.class);
            Incident incidentEdited = null;
            try {
                incidentEdited = incidentService.editIncident(incidentToEdit);
            } catch (IncidentException e) {
                errorMessage = e.getMessage();
            }

            if (incidentEdited != null) {
                return new Gson().toJson(
                        new StandardResponse(StatusResponse.SUCCESS, new Gson()
                                .toJsonTree(incidentEdited))
                );
            } else {
                return new Gson().toJson(
                        new StandardResponse(StatusResponse.ERROR, new Gson()
                                .toJson(errorMessage))
                );
            }
        });

        options("/incidents/:id", (request, response) -> {
            response.type("application/json");

            return new Gson().toJson(
                    new StandardResponse(StatusResponse.SUCCESS,
                            (incidentService.existIncident(request.params("id")) ? "Incident exist." : "Incident DONT exist."))
            );
        });
    }
}
