package de.unistuttgart.iste.pe2ws20.api.klassen;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class StudentCtrl {
    private AtomicInteger counter;
    private List<Student> studenten;

    // executed after start-up and dependency injection
    @PostConstruct
    public void init() {
        this.counter = new AtomicInteger();
        this.studenten = new ArrayList<>();

        Student st1 = new Student(counter.getAndIncrement(), "Anna Cristina",
                "Franco da Silva", "st12345@stud.uni-stuttgart.de",
                "AnaCristinaFrancoDaSilva");
        this.studenten.add(st1);

    }

    // get all projects
    @GetMapping("/students")
    public List<Student> getStudenten() {
        return this.studenten;
    }

    // get a single project
    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable("id") int id) {

        for (Student student : this.studenten) {
            if (student.getId() == id) {
                return student;
            }
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Student with ID %s not found!", id));
    }

    // create a project
    @PostMapping("/students")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@Valid @RequestBody Student requestBody) {
        Student student = new Student( counter.getAndIncrement(),
                requestBody.getPrename(), requestBody.getName(), requestBody.getEmail(),
                requestBody.getIliasName());
        this.studenten.add(student);
        return student;
    }

    // update a project
    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable("id") int id, @Valid @RequestBody Student requestBody) {
        requestBody.setId(id);

        for (int x = 0; x < this.studenten.size(); x++) {
            if (this.studenten.get(x).getId() == id) {
                this.studenten.set(x, requestBody);
                return requestBody;
            }
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Student with ID %s not found!", id));
    }

    // delete a cat
    @DeleteMapping("/students/{id}")
    public Student deleteStudent(@PathVariable("id") int id) {

        for (int x = 0; x < this.studenten.size(); x++) {
            if (this.studenten.get(x).getId() == id) {
                Student deletedStudent = this.studenten.get(x);
                this.studenten.remove(x);
                return deletedStudent;
            }
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Students with ID %s not found!", id));
    }
}
