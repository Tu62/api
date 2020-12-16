package de.unistuttgart.iste.pe2ws20.api.klassen;

import java.util.ArrayList;

public class Registrierung {
    private int id;
    private ArrayList<Project> bevorzugteProjekte;
    private ArrayList<Student> studenten;
    private Long created;

    public Registrierung(int id, Long created, ArrayList<Student> studenten, ArrayList<Project> bevorzugteProjekte) {
        this.id = id;
        this.created = created;
        this.studenten = studenten;
        this.bevorzugteProjekte = bevorzugteProjekte;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public ArrayList<Student> getStudentslist(){
        return this.studenten;
    }

    public ArrayList<Project> getBevorzugteProjekte(){
        return this.bevorzugteProjekte;
    }

    public void setBevorzugteProjekte(ArrayList<Project> bevorzugteProjekte) {
        this.bevorzugteProjekte = bevorzugteProjekte;
    }

    public ArrayList<Student> getStudenten() {
        return studenten;
    }

    public void setStudenten(ArrayList<Student> studenten) {
        this.studenten = studenten;
    }
}
