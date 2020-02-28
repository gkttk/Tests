package service;

import dto.Question;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class QuestionService implements IService<Question> {

    private static QuestionService questionService;
    private Random random = new Random();
    private QuestionService() {
    }

    public static synchronized QuestionService getSingletonQuestionService() {
        if (questionService == null) {
            questionService = new QuestionService();
        }
        return questionService;
    }

    @Override
    public Question createInstance() {
        Question question = new Question();
        this.updateInstance(question);
        String stringOfQData, correctAnswers;
        try (BufferedReader reader = new BufferedReader(new FileReader("src\\questions\\Question_" + question.getqID() + ".txt"))){//читает случайный файл из папки test.questions
            stringOfQData = reader.readLine();
            while (stringOfQData != null) {//цикл записывает текст из файла в поле qData
                if (stringOfQData.matches("CorrectAnswer([A|B|C|D])+")) {//в последней строчке файла записан верный ответ в формате CorrectAnswerВЕРНЫЙ_ОТВЕТ, если
                    // такой паттерн обнаруживается, то выделяется подстрока с буквой/буквами верного ответа и записывается в поле "Лист правильных ответов" и цикл прерывается
                    correctAnswers = stringOfQData.substring(13);
                    if (correctAnswers.length() > 1) {//если ответов больше 1, то подстрока разбивается на символы и каждый символ законяется в поле Лист правильных ответов
                        char[] charArray = correctAnswers.toCharArray();
                        for (char a : charArray) {
                            question.getRightAnswers().add(String.valueOf(a));
                        }
                    } else {//если ответ один, то он просто добавляется в поле "Лист правильных ответов"
                        question.getRightAnswers().add(correctAnswers);
                    }
                    break;
                }//if
                question.getqData().append(stringOfQData + "\n");
                stringOfQData = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Отсутствует файл");
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода");
        }
        return question;
    }

    @Override
    public void readInstance(Question obj) {
        System.out.println(obj.toString());
    }

    @Override
    public void updateInstance(Question obj) {
        obj.setqID(random.nextInt(10) + 1);
    }

    @Override
    public boolean deleteInstance(Question obj) {
        return false;
    }
}
