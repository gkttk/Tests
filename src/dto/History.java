package dto;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class History {
    private final static Map<Student, List<Questionnaire>> history = new HashMap<>();
    private final static List<Student> listOfStudents = new LinkedList<>();
    private final static List<Questionnaire> listOfQuestionnaires = new LinkedList<>();


    public static Map<Student, List<Questionnaire>> getHistory() {
        return history;
    }

    public static List<Student> getListOfStudents() {
        return listOfStudents;
    }

    public static List<Questionnaire> getListOfQuestionnaires() {
        return listOfQuestionnaires;
    }
}
