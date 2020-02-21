package test;

import java.util.LinkedList;
import java.util.List;

public class Questionnaire {
    private int variant;//Вариант вопросника, генерируется (сумма номеров всех вопросов)/3
    private boolean isPassed = false;//по дефолту тест считается непройденным
    private List<Question> listOfQuestions = new LinkedList<>();//лист вопросов

    public Questionnaire() {
        Question q;
        for (; listOfQuestions.size() < 5; ) {//пока лист вопросов не будет иметь 5 элементов, цикл не закончится(цикл добавляет УНИКАЛЬНЫЙ вопрос в вопросник)
            q = new Question();
            if (listOfQuestions.contains(q)) {
                continue;
            }
            variant += q.getId();
            listOfQuestions.add(q);
        }
        variant /= 3;

       /* System.out.println(listOfQuestions.toString()); //для теста вопросника
        System.out.println("Вариант " + variant);*/
    }

    //геттеры/сеттеры
    public List<Question> getListOfQuestions() {
        return listOfQuestions;
    }

    public void setPassed(boolean passed) {
        isPassed = passed;
    }

    public boolean isPassed() {
        return isPassed;
    }

}