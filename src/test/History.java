package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class History {

    private final static Map<Student, List<Questionnaire>> history = new HashMap<>();//переменная хранит всех студентов, проходивших тесты, и их вопросники

    public static void addStudent(Student stud) {//обновление данных для поля history
        history.put(stud, stud.getPastTests());
    }

    public static void showStudent(Student stud) { //показать успеваемость студента
        int count = 0;
        if (history.containsKey(stud)) {
            for (Questionnaire q : stud.getPastTests()) {
                if (q.isPassed()) count++;
            }
            System.out.println("Студент сдал " + count + " тестов из " + stud.getPastTests().size());
        }
    }

    //геттеры/сеттеры
    public static Map<Student, List<Questionnaire>> getHistory() {
        return history;
    }

}
