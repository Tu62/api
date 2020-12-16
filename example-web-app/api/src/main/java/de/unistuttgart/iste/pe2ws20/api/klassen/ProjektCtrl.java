package de.unistuttgart.iste.pe2ws20.api.klassen;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
public class ProjektCtrl {

    private AtomicInteger counter;
    private  static List<Project> projekte = new ArrayList<>();

    // executed after start-up and dependency injection
    @PostConstruct
    public void init() {
        this.counter = new AtomicInteger();
        this.projekte = new ArrayList<>();
        Project projekt1 = new Project(counter.getAndIncrement(), "Customer Project 1");
        this.projekte.add(projekt1);
        Project projekt2 = new Project(counter.getAndIncrement(), "Customer Project 2");
        this.projekte.add(projekt2);

    }

    // get all projects
    @GetMapping("/projects")
    public List<Project> getProjekte() {
        return getProjectlist();
    }


    // get a single project
    @GetMapping("/projects/{id}")
    public Project getProjekt(@PathVariable("id") int id) {

        for (Project projekt : this.projekte) {
            if (projekt.getId() == id) {
                return projekt;
            }
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Project with ID %s not found!", id));
    }

    // create a project
    @PostMapping("/projects")
    @ResponseStatus(HttpStatus.CREATED)
    public Project createProjekte(@Valid @RequestBody Project requestBody) {
        Project projekt = new Project(counter.getAndIncrement(),
                requestBody.getProjektname());
        getProjectlist().add(projekt);
        return projekt;
    }

    // update a project
    @PutMapping("/projects/{id}")
    public Project updateProject(@PathVariable("id") long id, @Valid @RequestBody Project requestBody) {

        for (int x = 0; x < this.projekte.size(); x++) {
          Project projekt = this.getProjectlist().get(x);
          if(projekt.getId()==id){
              projekt.setProjektname(requestBody.getProjektname());
              this.getProjectlist().set(x,projekt);
          }
            return projekt;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Project with ID %s not found!", id));
    }

    // delete a project
    @DeleteMapping("/projects/{id}")
    public Project deleteProjekt(@PathVariable("id") int id) {

        for (int x = 0; x < this.projekte.size(); x++) {
            if (this.projekte.get(x).getId() == id) {
                Project deletedProject = this.projekte.get(x);
                this.projekte.remove(x);
                return deletedProject;
            }
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Project with ID %s not found!", id));
    }

    //Hilfsmethoden
    public static List<Project> getProjectlist(){
        return projekte;
    }
}
