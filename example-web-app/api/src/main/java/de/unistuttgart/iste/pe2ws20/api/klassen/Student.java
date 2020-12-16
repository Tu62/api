package de.unistuttgart.iste.pe2ws20.api.klassen;

public class Student  {

    private int id;
    private String prename;
    private String name;
    private String email;
    private String iliasName;

    public Student(int id, String prename, String name, String email, String iliasName) {
        this.id = id;
        this.prename = prename;
        this.name = name;
        this.email = email;
        this.iliasName = iliasName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrename() {
        return prename;
    }

    public void setPrename(String prename) {
        this.prename = prename;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIliasName() {
        return iliasName;
    }

    public void setIliasName(String iliasName) {
        this.iliasName = iliasName;
    }
}

