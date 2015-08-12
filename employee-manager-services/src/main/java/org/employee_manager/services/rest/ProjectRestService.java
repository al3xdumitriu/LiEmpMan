package org.employee_manager.services.rest;

import org.employee_manager.model.Project;
import org.employee_manager.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/project")
public class ProjectRestService {

    @Autowired
    private ProjectService projectService;

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProjects() {

        List<Project> projectList = null;
        Response response = null;

        try {
            projectList = projectService.findAllProjects();

            if (projectList != null) {
                for (Project project : projectList) {
                    project.setEmployeeProjects(null);
                    project.setProjectEvaluations(null);
                }

                response = Response.status(Response.Status.FOUND).entity(projectList).build();
            } else {
                response = Response.status(Response.Status.NOT_FOUND).entity(projectList).build();
            }

        } catch (Exception e) {
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

        return response;
    }
}
