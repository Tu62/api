package de.unistuttgart.iste.pe2ws20.api.klassen;

import java.util.ArrayList;

public class Registrierungseingabe {
    public ArrayList<Student> studenten;
    public ArrayList<Integer> idsBevorzugterProjekte;

    public ArrayList<Student> getStudenten() {
        return studenten;
    }

    public ArrayList<Integer> getIdsBevorzugterProjekte() {
        return idsBevorzugterProjekte;
    }

    public void setStudenten(ArrayList<Student> studenten) {
        this.studenten = studenten;
    }

    public void setIdsBevorzugterProjekte(ArrayList<Integer> idsBevorzugterProjekte) {
        this.idsBevorzugterProjekte = idsBevorzugterProjekte;
    }
}
