import api.LettersAnswer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Student {
    private int id;
    private String name;
    private Questionnaire currentQuestionnaire;
    private List<Questionnaire> pastTests = new ArrayList<>();

    public Student(String name) {
        this.name = name;
        id = (int) (Math.random() * 100) + this.name.length();
        History.addStudent(this);
    }

    public List<Questionnaire> getPastTests() {
        return pastTests;
    }


    public void startTest(Questionnaire q) {
        int count = 0;
        currentQuestionnaire = q;//создается объект вопросника(без sql пока так)
        for (Question question : currentQuestionnaire.getQuestions()) {
            if (this.answerQuestion(question, LettersAnswer.A, LettersAnswer.C)) {//ответы принимаются тут
                count++;
            }
        }
        if (count >= 2) {//если верно отвечено на 2 и более вопросов, то тест считается пройденным
            currentQuestionnaire.setPast(true);
        }
        pastTests.add(currentQuestionnaire);
    }

    public boolean answerQuestion(Question q, LettersAnswer... answers) {
        return (q.getCorrectAnswers().length == answers.length && Arrays.equals(q.getCorrectAnswers(), answers));//сравнение массивов????
    }

    public void performance() {//успеваемость студента
        int count = 0;
        for (Questionnaire q : pastTests) {
            if (q.isPast()) {
                count++;
            }
            System.out.println("Студент " + name + " прошел " + count + " тестов из " + pastTests.size());
        }
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Student)) {
            return false;
        }
        Student stud = (Student) o;
        if (this.name.equalsIgnoreCase(stud.name) && this.id == stud.id) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.id / 2 + name.length() * 3;
    }
}

