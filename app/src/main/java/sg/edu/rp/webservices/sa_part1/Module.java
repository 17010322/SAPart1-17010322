package sg.edu.rp.webservices.sa_part1;

import java.io.Serializable;

public class Module implements Serializable {

    private int id;
    private int numStudents;
    private String name;
    private String code;
    private String school;

    public Module (int id,int numStudents,String name,String code,String school){
        this.id = id;
        this.numStudents = numStudents;
        this.name = name;
        this.code = code;
        this.school = school;
    }

    public int getId() {return id;}
    public int getNumStudents() {return numStudents;}
    public String getName() {return name;}
    public String getCode() {return code;}
    public String getSchool() {return school;}
}


