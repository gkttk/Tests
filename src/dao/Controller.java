package dao;

import dto.History;
import dto.Question;
import dto.Questionnaire;
import dto.Student;
import service.IService;
import service.QuestionnaireService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {
    IService service;

    public void startTest(Student student) {
        service = QuestionnaireService.getSingletonQuestionnaireService();
        Questionnaire questionnaire1 = (Questionnaire) service.createInstance();
        List<Question> bufferQuestions = questionnaire1.getQuestions().stream().filter(question -> {
            try (BufferedReader reader = new BufferedReader(new FileReader("src\\answers\\answer.txt"))) {
                return answerQuestion(question, reader.readLine());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return false;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }).collect(Collectors.toList());
        if (bufferQuestions.size() >= questionnaire1.getQuestions().size() * 0.7) {
            questionnaire1.setPassed(true);
        }
        student.getPastTests().add(questionnaire1);
        History.getHistory().put(student, student.getPastTests());
    }

    public static boolean answerQuestion(Question question, String answers) {
        if (answers.length() == question.getRightAnswers().size()) {
            if (answers.length() > 1) {
                char[] charArray = answers.toCharArray();
                for (char a : charArray) {
                    if (!question.getRightAnswers().contains(String.valueOf(a))) return false;
                }
                return true;
            } else {
                return question.getRightAnswers().get(0).equalsIgnoreCase(answers);
            }
        }
        return false;
    }
}
