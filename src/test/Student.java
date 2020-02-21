package test;

import test.api.Answers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Student {

    private String name;
    private Questionnaire currentQuestionnaire;//текущий вопросник(который проходит студент в данный момент)
    private List<Questionnaire> pastTests = new ArrayList<>();//список законченых тестов

    public Student(String name) {
        this.name = name;
    }

    public void startTest() {
        int count = 0;//переменная для того чтобы узнать пройден ли тест
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src\\test\\answers\\answer.txt"));//ответ будет читаеться из файла(пока нет запросов браузера)

            String answerString = reader.readLine();
            currentQuestionnaire = new Questionnaire();//студент получает опросник со случайными уникальными вопросами
            for (Question question : currentQuestionnaire.getListOfQuestions()) {
                System.out.println(question.getqData());
                Thread.sleep(500);
                System.out.println("Ответ " + answerString + "\n");
                if (answerQuestion(question, answerString)) {
                    count++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (count >= 0.7 * currentQuestionnaire.getListOfQuestions().size()) {//если верный ответ дан 70% вопросам, то тест считается пройденным
            currentQuestionnaire.setPassed(true);
        }
        pastTests.add(currentQuestionnaire);//запись теста в поле студента "Законченные тесты"
        History.addStudent(this);//обновление информации в классе test.History
    }


    private boolean answerQuestion(Question q, String answer) {
        for (int i = 0; i < answer.length() - 1; i++) {
            if (q.getListOfAnswers().contains(Answers.valueOf(answer.substring(i, i + 1)))) continue;
            else {
                return false;
            }//else
        }//for
        return true;
    }


    public List<Questionnaire> getPastTests() {
        return pastTests;
    }

}
