package application.services;

import application.entities.Project;
import application.entities.ProjectUpdatePayload;
import application.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    public List<Project> getProjects() {
        return this.projectRepository.findAll();
    }

    public Project createProject(Project project) {
        return this.projectRepository.insert(project);
    }

    public Optional<Project> getProjectById(int id) {
        return this.projectRepository.findById(id);
    }

    public Optional<Project> deleteProjectById(int id) {
        Optional<Project> project = this.projectRepository.findById(id);
        project.ifPresent(p -> this.projectRepository.delete(p));
        return project;
    }

    public Optional<Project> updateProjectById(int id, ProjectUpdatePayload projectUpdatePayload) {
        Optional<Project> project = this.projectRepository.findById(id);
        project.ifPresent(p -> p.setName(projectUpdatePayload.getName()));
        project.ifPresent(p -> p.setDescription(projectUpdatePayload.getDescription()));
        project.ifPresent(p -> p.setType(projectUpdatePayload.getType()));
        project.ifPresent(p -> p.setExistingTests(projectUpdatePayload.getExistingTests()));
        project.ifPresent(p -> this.projectRepository.save(p));
        return project;
    }

    public Optional<Project> updateAmountOfTestsProjectById(int id, int existingTests) {
        Optional<Project> project = this.projectRepository.findById(id);
        project.ifPresent(p -> p.setExistingTests(existingTests + p.getExistingTests()));
        project.ifPresent(p -> this.projectRepository.save(p));
        return project;
    }
}
