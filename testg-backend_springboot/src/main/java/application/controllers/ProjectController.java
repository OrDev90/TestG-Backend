package application.controllers;

import application.entities.Project;
import application.entities.ProjectUpdatePayload;
import application.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projects")
@CrossOrigin(origins = "http://localhost:4200")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @GetMapping
    public List<Project> getProjects() {
        return this.projectService.getProjects();
    }

    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return this.projectService.createProject(project);
    }

    @GetMapping(value="/{id}")
    public Optional<Project> getProjectById(@PathVariable("id") int id) {
        return this.projectService.getProjectById(id);
    }

    @DeleteMapping(value="/{id}")
    public Optional<Project> deleteProjectById(@PathVariable("id") int id) {
        return this.projectService.deleteProjectById(id);
    }

    @PutMapping(value="/{id}")
    public Optional<Project> updateProjectById(@PathVariable("id") int id,
                                               @RequestBody ProjectUpdatePayload projectUpdatePayload) {
        return this.projectService.updateProjectById(id, projectUpdatePayload);
    }

    @PutMapping(value="/{id}/{existingTests}")
    public Optional<Project> updateAmountOfTestsProjectById(@PathVariable("id") int id,
                                                            @PathVariable("existingTests") int existingTests) {
        return this.projectService.updateAmountOfTestsProjectById(id, existingTests);
    }
}
