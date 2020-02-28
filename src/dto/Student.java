package dto;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private int studentID;
    private String name;
    private final List<Questionnaire> pastTests = new ArrayList<>();

    public Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
    }

    public List<Questionnaire> getPastTests() {
        return pastTests;
    }


    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj){
        if(super.equals(obj)) return true;
        if(obj == null || !(obj instanceof Student)) return false;
        Student student = (Student)obj;
        return this.studentID == student.studentID && this.getName().equalsIgnoreCase(student.getName());
    }
    @Override
    public int hashCode(){
        return this.studentID*2 + this.getName().length()+3;
    }

    @Override
    public String toString() {
        return "Студент №" + studentID + " Имя - "+ name;

    }
}
