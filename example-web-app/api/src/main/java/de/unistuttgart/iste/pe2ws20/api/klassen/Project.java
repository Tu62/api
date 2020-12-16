package de.unistuttgart.iste.pe2ws20.api.klassen;

public class Project {

    public int id;
    private String projektname;

    public Project(int id , String projektname) {
        this.id = id;
        this.projektname = projektname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjektname() {
        return projektname;
    }

    public void setProjektname(String projektname) {
        this.projektname = projektname;
    }


}

