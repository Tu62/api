package de.unistuttgart.iste.pe2ws20.api.klassen;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@RestController
public class RegistrierungCtrl {
    private AtomicInteger counter;
    private List<Registrierung> registrierungen;

    private ArrayList<Student> myStudents = new ArrayList<>();
    private ArrayList<Project> myProjects = new ArrayList<>();
    private Project project1;
    private Student student1;

    private Long date;

    // executed after start-up and dependency injection
    @PostConstruct
    public void init() {
        this.counter = new AtomicInteger();
        this.registrierungen = new ArrayList<>();

        Registrierung reg1 = new Registrierung(counter.getAndIncrement(),
                new Date().getTime(),myStudents, myProjects );

        registrierungen.add(reg1);
    }

    // get all registrations
    @GetMapping("/registrations")
    public List<Object> getRegistrierung() {
        return this.registrierungen.stream().map(registrierung -> new Object(){
            public final int id = registrierung.getId();
            public final long created = registrierung.getCreated();
            public final int anzahlStudenten = registrierung.getStudentslist().size();
            public final List<Integer> idListe = bevorzugteIDs(registrierung);
        }).collect(Collectors.toList());
    }

    //Hilfsmethode
    public List<Integer> bevorzugteIDs(Registrierung registrierung){
        return registrierung.getBevorzugteProjekte().stream().map(Project::getId).collect(Collectors.toList());
    }

    // get a single registration
    @GetMapping("/registrations/{id}")
    public Registrierung getRegistration(@PathVariable("id") int id) {

        for (Registrierung reg : this.registrierungen) {
            if (reg.getId() == id) {
                return reg;
            }
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Registration with ID %s not found!", id));
    }

    // create a project
    @PostMapping("/registrations")
    @ResponseStatus(HttpStatus.CREATED)
    public Registrierung createRegistration(@Valid @RequestBody Registrierungseingabe requestBody) {
       ArrayList <Project> bevProjekte = getBevProjekte(requestBody);
        Registrierung registrierung2 = new Registrierung(counter.getAndIncrement(),new Date().getTime(),
                 requestBody.getStudenten(), bevProjekte);
        this.registrierungen.add(registrierung2);
        return registrierung2;
    }
    //Hilfsmethode POST
    public ArrayList<Project> getBevProjekte(Registrierungseingabe requestBody){
        ArrayList<Project> bevProjekte = new ArrayList<>();
        if(requestBody.getIdsBevorzugterProjekte()!=null){
            for(Integer integerID : requestBody.getIdsBevorzugterProjekte()){
                bevProjekte.add(ProjektCtrl.getProjectlist().stream()
                        .filter(projekt -> projekt.id == integerID)
                        .findAny().orElse(null));
            }
        }
        return bevProjekte;
    }



    // update a project
    @PutMapping("/registrations/{id}")
    public Registrierung updateRegistration(@PathVariable("id") int id, @Valid @RequestBody Registrierungseingabe requestBody) {
       for(Registrierung reg1 : this.registrierungen){
           if(reg1.getId()==id){
               for(int i=0; i<registrierungen.size();i++){
                   registrierungen.get(i).setStudenten(requestBody.getStudenten());
               }

           }
           ArrayList<Project> bevProjekte = new ArrayList<>();
           if(requestBody.getIdsBevorzugterProjekte()!=null){
               for(Integer integerID : requestBody.getIdsBevorzugterProjekte()){
                   bevProjekte.add(ProjektCtrl.getProjectlist().stream()
                           .filter(projekt -> projekt.id == integerID)
                           .findAny().orElse(null));
               }
           }
           reg1.setBevorzugteProjekte(bevProjekte);
           return reg1;
       }


        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Registration with ID %s not found!", id));
    }
    //Gegebene Reg ändern, nur int-liste änderbar Hilfsmethode von Post nochmal benutzen.For-Each.
    // delete a cat
    @DeleteMapping("/registrations/{id}")
    public Registrierung deleteRegistration(@PathVariable("id") int id) {

        for (int x = 0; x < this.registrierungen.size(); x++) {
            if (this.registrierungen.get(x).getId() == id) {
                Registrierung deleteRegistration = this.registrierungen.get(x);
                this.registrierungen.remove(x);
                return deleteRegistration;
            }
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Registration with ID %s not found!", id));
    }


}
