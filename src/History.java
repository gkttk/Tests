import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class History {

    private final static Map<Student, List<Questionnaire>> history = new HashMap<>();

    public static void addStudent(Student stud) {
        history.put(stud, stud.getPastTests());
    }

    public static void showStudent(Student stud){
        if(history.containsKey(stud)){
            stud.performance();
        }
    }
}
