import api.LettersAnswer;

import java.util.Arrays;


public class Question {

    private int id;
    private String qData;
    private String pictureUrl;
    private LettersAnswer[] letters;
    private LettersAnswer[] correctAnswers;

    Question(String qData, String pictureUrl, int numberOfAnswers, LettersAnswer...correctAnswers) {
        this.qData = qData;
        this.pictureUrl = pictureUrl;
        this.id = (int) (Math.random() * 10) + qData.length();
        letters = Arrays.copyOf(LettersAnswer.values(), numberOfAnswers);
        int x = 0;
        for (LettersAnswer a : letters) { //заполнение текста ответа(пока что автоматически цифрами от 0 до 5)
            a.setData(String.valueOf(x));
            x++;
        }
        this.correctAnswers = correctAnswers;
    }

    public LettersAnswer[] getCorrectAnswers() {
        return correctAnswers;
    }
    public String getPictureUrl() {
        if (this.pictureUrl == null) {
            return "Ссылка отсутствует";
        }
        return pictureUrl;
    }
    public LettersAnswer[] getLetters() {
        return letters;
    }
    public int getId() {
        return id;
    }
    public String getqData() {
        return qData;
    }

    public static Question createQuestion(String qData, String pictureUrl, int numberOfAnswers) {
        return new Question(qData, pictureUrl, numberOfAnswers);
    }//создание вопроса с урлом картинки(+)
    public static Question createQuestion(String qData, int numberOfAnswers) {
        return createQuestion(qData, null, numberOfAnswers);
    }//создание вопроса без урла картинки(+)
    public void readQuestion() {
        readQuestion(this);
    }  //вывод на экран вопроса с вариантами ответа(+)
    public static void readQuestion(Question q) {
        System.out.println(q.getqData());
        System.out.println(q.getPictureUrl());
        for (LettersAnswer a : q.getLetters()) {
            System.out.println(a.getNumber() + ". " + a.getData());
        }
    } //вывод на экран вопроса с вариантами ответа(статический)(+)
    public void updateQuestion(String qData, String pictureUrl, int numberOfAnswers) {
        this.qData = qData;
        this.pictureUrl = pictureUrl;
        letters = Arrays.copyOf(LettersAnswer.values(), numberOfAnswers);
        int x = 0;
        for (LettersAnswer a : letters) { //заполнение текста ответа(пока что автоматически цифрами от 0 до 5)
            a.setData(String.valueOf(x));
            x++;
        }
    }//изменение вопроса
    public static void updateQuestion(Question q, String qData, String pictureUrl, int numberOfAnswers) {
        q.qData = qData;
        q.pictureUrl = pictureUrl;
        q.letters = Arrays.copyOf(LettersAnswer.values(), numberOfAnswers);
        int x = 0;
        for (LettersAnswer a : q.getLetters()) { //заполнение текста ответа(пока что автоматически цифрами от 0 до 5)
            a.setData(String.valueOf(x));
            x++;
        }
    }//изменение вопроса(статический)(+)



    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Question)) {
            return false;
        }
        Question quest = (Question) o;
        if (this.letters.length == quest.letters.length && this.getqData().equals(quest.getqData()) && this.getPictureUrl().equals(quest.getPictureUrl())) {
            return true;
        }
        return false;
    }//переопределен equals(все ли учёл?)(+)
    public int hashCode() {
        return this.getId() * 2 + getqData().length() * 3;
    }//переопределен hashCode(просто случайная формула, заявзанная на полях класса)(+)


}
